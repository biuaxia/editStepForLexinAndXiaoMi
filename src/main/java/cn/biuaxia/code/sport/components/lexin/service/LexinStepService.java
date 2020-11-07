package cn.biuaxia.code.sport.components.lexin.service;

import cn.biuaxia.code.sport.components.lexin.forms.RequestSubAndAutoSchForm;
import cn.biuaxia.code.sport.components.lexin.forms.WantStepForm;
import cn.biuaxia.code.sport.engine.forms.UserLoginForm;

/**
 *
 * @author biuaxia
 * @date 2020-11-07 21:00:05
 */
public interface LexinStepService {

    /**
     * 获取用户的 userId 信息
     *
     * @param userLoginForm 用户信息表单，包括了账号，密码
     * @return userId 信息
     */
    String getUserId(UserLoginForm userLoginForm);

    /**
     * 提交步数
     *
     * @param wantStepForm 刷步信息表单，包括了userId，想要刷取的步数
     * @return 是否成功
     */
    boolean submitStep(WantStepForm wantStepForm);

    /**
     * 提交步数且自动加入定时任务
     *
     * @param subAndAutoSchForm 用户步数信息表单，包括了账号，密码，步数
     * @return 是否成功
     */
    boolean submitStepAndAutoScheduled(RequestSubAndAutoSchForm subAndAutoSchForm);

}
