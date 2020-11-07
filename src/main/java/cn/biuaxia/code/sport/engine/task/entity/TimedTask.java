package cn.biuaxia.code.sport.engine.task.entity;

import lombok.Builder;
import lombok.Data;

/**
 * @author biuaxia
 * @date 2020-09-19 02:48:56
 */
@Builder
@Data
public class TimedTask {
    private Long id;
    private String username;
    private String password;
    private Integer step;
}
