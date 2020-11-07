package cn.biuaxia.code.sport.engine.controller;

import cn.biuaxia.code.sport.components.lexin.service.LexinStepService;
import cn.biuaxia.code.sport.components.xiaomi.service.XiaomiStepService;
import cn.biuaxia.code.sport.engine.task.mapper.TimedTaskErrorLogMapper;
import cn.biuaxia.code.sport.engine.task.mapper.TimedTaskMapper;
import cn.biuaxia.code.sport.engine.task.mapper.TimedTaskSuccessLogMapper;

import javax.annotation.Resource;

/**
 *
 * @author biuaxia
 * @date 2020-11-07 22:13:29
 */
public class IController {

    /**
     * 账号不允许为空
     */
    public static final String TIPS_USERNAME = "手机不允许为空";

    /**
     * 密码不允许为空
     */
    public static final String TIPS_PASSWORD = "密码不允许为空";

    /**
     * 步数不允许为空
     */
    public static final String TIPS_STEP = "步数不允许为空";

    /**
     * 账号参数
     */
    public static final String USERNAME_PARAMETER = "u";

    /**
     * 密码参数
     */
    public static final String PASSWORD_PARAMETER = "p";

    /**
     * 步数参数化
     */
    public static final String STEP_PARAMETER = "s";

    /**
     * 默认页码
     */
    public static final String DEFAULT_PAGE = "0";

    /**
     * 默认大小
     */
    public static final String DEFAULT_SIZE = "10";

    @Resource
    protected LexinStepService lexinStepService;

    @Resource
    protected XiaomiStepService xiaomiStepService;

    @Resource
    protected TimedTaskMapper timedTaskMapper;

    @Resource
    protected TimedTaskSuccessLogMapper timedTaskSuccessLogMapper;

    @Resource
    protected TimedTaskErrorLogMapper timedTaskErrorLogMapper;

}
