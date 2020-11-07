package cn.biuaxia.code.sport.components.lexin.forms;

import lombok.Builder;
import lombok.Data;

/**
 *
 * @author biuaxia
 * @date 2020-11-07 21:09:12
 */
@Data
@Builder
public class WantStepForm {

    /**
     * 账号ID
     */
    private String userId;

    /**
     * 想要刷的步数
     */
    private int wantSteps;

}
