package cn.biuaxia.code.sport.components.lexin.forms;

import cn.biuaxia.code.sport.engine.forms.UserLoginForm;
import lombok.Builder;
import lombok.Data;

/**
 *
 * @author biuaxia
 * @date 2020-11-07 21:51:42
 */
@Data
@Builder
public class RequestSubAndAutoSchForm {

    /**
     * 账号
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 想要刷的步数
     */
    private int wantSteps;

    /**
     * 用户信息表单
     *
     * @return 初始化后的对象
     */
    public UserLoginForm buildUserLoginForm() {
        return UserLoginForm.builder()
                .username(this.getUsername())
                .password(this.getPassword())
                .build();
    }

    /**
     * 刷步信息表单
     *
     * @return 初始化后的对象
     */
    public WantStepForm buildWantStepForm(String userId) {
        return WantStepForm.builder()
                .userId(userId)
                .wantSteps(this.getWantSteps())
                .build();
    }

}
