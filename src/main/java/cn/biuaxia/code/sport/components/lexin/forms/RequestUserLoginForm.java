package cn.biuaxia.code.sport.components.lexin.forms;

import lombok.Builder;
import lombok.Data;

/**
 *
 * @author biuaxia
 * @date 2020-11-07 21:02:25
 */
@Data
@Builder
public class RequestUserLoginForm {

    /**
     * 账号
     */
    private String loginName;

    /**
     * 密码
     */
    private String password;

    private String clientId;

    private Integer appType;

    private Integer roleType;

    /**
     * 表单初始化
     *
     * @return 初始化后的对象
     */
    public RequestUserLoginForm initialForm() {
        return RequestUserLoginForm.builder()
                .loginName(this.getLoginName())
                .password(this.getPassword())
                .clientId("8e844e28db7245eb81823132464835eb")
                .appType(6)
                .roleType(0)
                .build();
    }

}
