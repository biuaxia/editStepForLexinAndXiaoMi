package cn.biuaxia.code.sport.engine.task.service;

import cn.biuaxia.code.sport.engine.task.forms.LexinUserInfoForm;

/**
 * 定时任务服务类
 *
 * @author biuaxia
 * @date 2020-11-07 21:38:43
 */
public interface ScheduledTaskService {

    /**
     * 添加乐心定时任务
     *
     * @param userInfoForm 用户信息表单
     * @return 添加是否成功
     */
    boolean saveOrUpdateTaskToLexin(LexinUserInfoForm userInfoForm);

    /**
     * 添加小米定时任务
     *
     * @return 添加是否成功
     */
    boolean saveOrUpdateToXiaomi();

}
