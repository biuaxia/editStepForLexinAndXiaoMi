package cn.biuaxia.code.sport.components.lexin.service.impl;

import cn.biuaxia.code.sport.components.lexin.forms.RequestSubAndAutoSchForm;
import cn.biuaxia.code.sport.components.lexin.forms.RequestUpdateStepsForm;
import cn.biuaxia.code.sport.components.lexin.forms.RequestUserLoginForm;
import cn.biuaxia.code.sport.components.lexin.forms.WantStepForm;
import cn.biuaxia.code.sport.components.lexin.reverse.ResponseLoginReverse;
import cn.biuaxia.code.sport.components.lexin.reverse.ResponseUpdateStepsReverse;
import cn.biuaxia.code.sport.components.lexin.service.LexinStepService;
import cn.biuaxia.code.sport.engine.config.ProjectConfig;
import cn.biuaxia.code.sport.engine.exception.BusinessException;
import cn.biuaxia.code.sport.engine.forms.UserLoginForm;
import cn.biuaxia.code.sport.engine.task.entity.TimedTaskErrorLog;
import cn.biuaxia.code.sport.engine.task.entity.TimedTaskSuccessLog;
import cn.biuaxia.code.sport.engine.task.forms.LexinUserInfoForm;
import cn.biuaxia.code.sport.engine.task.mapper.TimedTaskErrorLogMapper;
import cn.biuaxia.code.sport.engine.task.mapper.TimedTaskSuccessLogMapper;
import cn.biuaxia.code.sport.engine.task.service.ScheduledTaskService;
import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.http.Header;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpStatus;
import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author biuaxia
 * @date 2020-11-07 21:10:27
 */
@Slf4j
@Service
public class LexinStepServiceImpl implements LexinStepService {

    @Resource
    private ProjectConfig projectConfig;

    @Resource
    private TimedTaskSuccessLogMapper timedTaskSuccessLogMapper;

    @Resource
    private TimedTaskErrorLogMapper timedTaskErrorLogMapper;

    @Resource
    private ScheduledTaskService scheduledTaskService;

    @Override
    public String getUserId(UserLoginForm userLoginForm) {
        String body = HttpRequest.post(projectConfig.getLexinLoginUrl())
                .header(Header.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(JSONUtil.toJsonStr(
                        RequestUserLoginForm.builder()
                                .loginName(userLoginForm.getUsername())
                                .password(SecureUtil.md5(userLoginForm.getPassword()))
                                .build()
                                .initialForm()))
                .timeout(20000)
                .execute()
                .body();

        if (log.isDebugEnabled()) {
            log.debug("getUserId: [{}]", JSONUtil.toJsonPrettyStr(body));
        }

        ResponseLoginReverse loginReverse = JSONUtil.toBean(body, ResponseLoginReverse.class);

        boolean result = HttpStatus.HTTP_OK == loginReverse.getCode();

        if (result) {
            return loginReverse.getData().getUserId();
        }
        return null;
    }

    @Override
    public boolean submitStep(WantStepForm wantStepForm) {
        int steps = wantStepForm.getWantSteps();
        String userId = wantStepForm.getUserId();

        int calories = steps / 4;
        int distance = steps / 3;
        RequestUpdateStepsForm updateStepsForm = RequestUpdateStepsForm.builder()
                .userId(Long.parseLong(userId))
                .step(steps)
                .calories(calories)
                .distance(distance)
                .build()
                .initialForm();

        HashMap<String, List<RequestUpdateStepsForm>> map = new HashMap<>(MapUtil.DEFAULT_INITIAL_CAPACITY);
        ArrayList<RequestUpdateStepsForm> updateStepsForms = new ArrayList<>();
        updateStepsForms.add(updateStepsForm);
        map.put("list", updateStepsForms);
        String body = HttpRequest.post(projectConfig.getLexinStepUrl())
                .header(Header.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(JSONUtil.toJsonStr(map))
                .timeout(20000)
                .execute().body();

        if (log.isDebugEnabled()) {
            log.debug("submitStep: [{}]", JSONUtil.toJsonPrettyStr(body));
        }

        ResponseUpdateStepsReverse updateStepsReverse = JSONUtil.toBean(body, ResponseUpdateStepsReverse.class);

        boolean result = HttpStatus.HTTP_OK == updateStepsReverse.getCode();

        if (result) {
            log.debug("提交成功");
            timedTaskSuccessLogMapper.insert(
                    TimedTaskSuccessLog.builder()
                            .taskId(Long.valueOf(userId))
                            .responseJson(JSONUtil.toJsonStr(updateStepsReverse))
                            .build());
        } else {
            log.error("提交出错");
            timedTaskErrorLogMapper.insert(
                    TimedTaskErrorLog.builder()
                            .taskId(Long.valueOf(userId))
                            .responseJson(JSONUtil.toJsonStr(updateStepsReverse))
                            .build());
        }

        return result;
    }

    @Override
    public boolean submitStepAndAutoScheduled(RequestSubAndAutoSchForm subAndAutoSchForm) {
        UserLoginForm userLoginForm = subAndAutoSchForm.buildUserLoginForm();
        String userId = getUserId(userLoginForm);

        if (StrUtil.isBlank(userId)) {
            throw new BusinessException("获取用户ID出错");
        }

        WantStepForm wantStepForm = subAndAutoSchForm.buildWantStepForm(userId);

        boolean submitStep = submitStep(wantStepForm);
        if (submitStep) {
            return scheduledTaskService.saveOrUpdateTaskToLexin(
                    LexinUserInfoForm.builder()
                            .username(userLoginForm.getUsername())
                            .password(userLoginForm.getPassword())
                            .step(wantStepForm.getWantSteps())
                            .build());
        }
        return false;
    }

}
