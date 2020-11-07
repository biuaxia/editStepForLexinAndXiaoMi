package cn.biuaxia.code.sport.engine.task;

import cn.biuaxia.code.sport.components.lexin.forms.WantStepForm;
import cn.biuaxia.code.sport.components.lexin.service.LexinStepService;
import cn.biuaxia.code.sport.engine.task.entity.TimedTask;
import cn.biuaxia.code.sport.engine.task.mapper.TimedTaskMapper;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.thread.ThreadUtil;
import lombok.extern.slf4j.Slf4j;
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
    private LexinStepService lexinStepService;

    @Resource
    private TimedTaskMapper timedTaskMapper;

    /**
     * 每天早上7点执行一次
     */
    @Scheduled(cron = "0 0 7 * * ?")
    // @Scheduled(cron = "*/5 * * * * ?")
    public void executeScheduledTask() {
        log.info("executeScheduledTask | Perform scheduled tasks: [{}]", DateUtil.now());
        List<TimedTask> dbList = timedTaskMapper.selectList(null);
        log.info("executeScheduledTask | DbList: {}",
                 dbList.stream().map(TimedTask::getUsername)
                         .collect(Collectors.toList()));
        log.info("executeScheduledTask | Start...");
        dbList.forEach(item -> {
            Runnable r = () -> lexinStepService.submitStep(
                       WantStepForm.builder()
                               .userId(String.valueOf(item.getId()))
                               .wantSteps(item.getStep())
                               .build());
            ThreadUtil.execute(r);
        });
    }

}
