package cn.biuaxia.code.sport.engine.task.forms;

import lombok.Builder;
import lombok.Data;

/**
 *
 * @author biuaxia
 * @date 2020-11-07 21:02:25
 */
@Data
@Builder
public class LexinUserInfoForm {

    /**
     * 账号
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 步数
     */
    private Integer step;

}
