package cn.biuaxia.code.sport.components.xiaomi.service;

import cn.biuaxia.code.sport.components.xiaomi.reverse.ResponseAccessCodeReverse;
import cn.biuaxia.code.sport.engine.forms.UserLoginForm;

/**
 *
 * @author biuaxia
 * @date 2020-11-07 22:31:14
 */
public interface XiaomiStepService {

    /**
     * 获取访问凭证
     *
     * @param userLoginForm 用户信息表单，包括了账号，密码
     * @return 访问凭证
     */
    String getAccessCode(UserLoginForm userLoginForm);

    /**
     * 登录
     *
     * @param accessCode 访问凭证
     * @return 用户ID 和 loginToken
     */
    ResponseAccessCodeReverse login(String accessCode);

    /**
     * 获取 appToken
     *
     * @param loginToken loginToken
     * @return appToken
     */
    String getAppToken(String loginToken);

    /**
     * 更新步数
     *
     * @param appToken appToken
     * @param userId 用户ID
     * @return 更新结果
     */
    boolean updateStep(String appToken, String userId);

    /**
     * 提交步数
     *
     * @param userLoginForm 用户信息表单，包括了账号，密码
     * @return 是否成功
     */
    boolean submitStep(UserLoginForm userLoginForm);

}
