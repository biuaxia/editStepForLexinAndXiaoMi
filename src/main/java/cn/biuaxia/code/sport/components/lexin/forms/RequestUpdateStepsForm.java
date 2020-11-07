package cn.biuaxia.code.sport.components.lexin.forms;

import lombok.Builder;
import lombok.Data;

/**
 *
 * @author biuaxia
 * @date 2020-11-07 21:26:51
 */
@Data
@Builder
public class RequestUpdateStepsForm {

    private Long updated;
    private String measurementTime;
    private String deviceId;
    private Integer isUpload;
    private Integer type;
    private Integer exerciseTime;
    private Integer dataSource;

    private Long userId;
    private Integer step;
    private Integer calories;
    private Integer distance;

    /**
     * 表单初始化
     *
     * @return 初始化后的对象
     */
    public RequestUpdateStepsForm initialForm() {
        return RequestUpdateStepsForm.builder()
                .userId(this.getUserId())
                .step(this.getStep())
                .calories(this.getCalories())
                .distance(this.getDistance())
                .updated(System.currentTimeMillis())
                .deviceId("M_NULL")
                .isUpload(0)
                .type(2)
                .exerciseTime(0)
                .dataSource(2)
                .build();
    }

}
