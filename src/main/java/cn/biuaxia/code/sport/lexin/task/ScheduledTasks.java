package cn.biuaxia.code.sport.lexin.task;

import cn.biuaxia.code.sport.lexin.domain.bo.LoginBO;
import cn.biuaxia.code.sport.lexin.domain.bo.SubmitStepBO;
import cn.biuaxia.code.sport.lexin.entity.TimedTask;
import cn.biuaxia.code.sport.lexin.entity.TimedTaskErrorLog;
import cn.biuaxia.code.sport.lexin.entity.TimedTaskSuccessLog;
import cn.biuaxia.code.sport.lexin.mapper.TimedTaskErrorLogMapper;
import cn.biuaxia.code.sport.lexin.mapper.TimedTaskMapper;
import cn.biuaxia.code.sport.lexin.mapper.TimedTaskSuccessLogMapper;
import cn.biuaxia.code.sport.lexin.utils.StepUtils;
import cn.biuaxia.code.sport.lexin.utils.UserInfoUtils;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.thread.ThreadUtil;
import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author biuaxia
 * @date 2020-09-19 02:48:56
 */
@Slf4j
@Component
public class ScheduledTasks {

    @Resource
    private UserInfoUtils userInfoUtils;

    @Resource
    private StepUtils stepUtils;

    @Resource
    private TimedTaskMapper timedTaskMapper;

    @Resource
    private TimedTaskSuccessLogMapper timedTaskSuccessLogMapper;

    @Resource
    private TimedTaskErrorLogMapper timedTaskErrorLogMapper;


    /**
     * 每天早上7点执行一次
     */
    @Scheduled(cron = "0 0 7 * * ?")
    // @Scheduled(cron = "*/5 * * * * ?")
    public void executeScheduledTask() {
        log.info("executeScheduledTask | Perform scheduled tasks: [{}]", DateUtil.now());
        List<TimedTask> dbList = timedTaskMapper.selectList(null);
        log.info("executeScheduledTask | DbList: {}", dbList.stream().map(TimedTask::getUsername).collect(Collectors.toList()));
        log.info("executeScheduledTask | Start...");
        dbList.forEach(item -> {
            String username = item.getUsername();
            String password = item.getPassword();
            Integer step = item.getStep();

            Runnable r = () -> {
                LoginBO.DataDTO userInfo = userInfoUtils.getUserInfo(username, password);
                String userId = userInfo.getUserId();
                SubmitStepBO submitStepBO = stepUtils.getSubmitStepBO(userId, step);
                if (HttpStatus.OK.value() != submitStepBO.getCode()) {
                    log.error("提交出错: [{}]", JSONUtil.toJsonStr(submitStepBO));
                    timedTaskErrorLogMapper.insert(TimedTaskErrorLog.builder()
                            .taskId(item.getId())
                            .responseJson(JSONUtil.toJsonStr(submitStepBO))
                            .build());
                } else {
                    log.debug("提交成功: [{}]", JSONUtil.toJsonStr(submitStepBO));
                    timedTaskSuccessLogMapper.insert(TimedTaskSuccessLog.builder()
                            .taskId(item.getId())
                            .responseJson(JSONUtil.toJsonStr(submitStepBO))
                            .build());
                }
            };
            ThreadUtil.execute(r);
        });
    }

}
