package cn.biuaxia.code.sport.engine.task.service.impl;

import cn.biuaxia.code.sport.engine.task.entity.TimedTask;
import cn.biuaxia.code.sport.engine.task.forms.LexinUserInfoForm;
import cn.biuaxia.code.sport.engine.task.mapper.TimedTaskMapper;
import cn.biuaxia.code.sport.engine.task.service.ScheduledTaskService;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 *
 * @author biuaxia
 * @date 2020-11-07 21:40:31
 */
@Slf4j
@Service
public class ScheduledTaskServiceImpl implements ScheduledTaskService {

    @Resource
    private TimedTaskMapper timedTaskMapper;

    @Override
    public boolean saveOrUpdateTaskToLexin(LexinUserInfoForm userInfoForm) {
        String username = userInfoForm.getUsername();
        String password = userInfoForm.getPassword();
        Integer step = userInfoForm.getStep();
        TimedTask dbTimedTask = timedTaskMapper.selectOne(new LambdaQueryWrapper<TimedTask>()
                                                                  .eq(TimedTask::getUsername, username)
                                                                  .eq(TimedTask::getPassword, password));
        if (ObjectUtil.isEmpty(dbTimedTask)) {
            int insert = timedTaskMapper.insert(TimedTask.builder()
                                                        .username(username)
                                                        .password(password)
                                                        .step(step)
                                                        .build());

            if (log.isDebugEnabled()) {
                log.debug("新增数据: [{}] 条", insert);
            }
            return true;
        } else {
            if (ObjectUtil.isNotEmpty(dbTimedTask.getStep()) && !step.equals(dbTimedTask.getStep())) {
                dbTimedTask.setStep(step);
                int update = timedTaskMapper.updateById(dbTimedTask);

                if (log.isDebugEnabled()) {
                    log.debug("更新数据: [{}] 条", update);
                }
                return true;
            } else {
                if (log.isDebugEnabled()) {
                    log.debug("无需更新");
                }
            }
        }
        return false;
    }

    @Override
    public boolean saveOrUpdateToXiaomi() {
        return false;
    }
}
