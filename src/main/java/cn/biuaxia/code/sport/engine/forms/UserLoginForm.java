package cn.biuaxia.code.sport.engine.forms;

import lombok.Builder;
import lombok.Data;

/**
 *
 * @author biuaxia
 * @date 2020-11-07 21:02:25
 */
@Data
@Builder
public class UserLoginForm {

    /**
     * 账号
     */
    private String username;

    /**
     * 密码
     */
    private String password;

}
