package cn.biuaxia.code.sport.engine.task.entity;

import lombok.Builder;
import lombok.Data;

/**
 * @author biuaxia
 * @date 2020-09-19 02:48:56
 */
@Data
@Builder
public class TimedTaskSuccessLog {

    private Long id;
    private Long taskId;
    private String responseJson;

}
