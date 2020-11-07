package cn.biuaxia.code.sport.components.xiaomi.reverse;

import lombok.Builder;
import lombok.Data;

/**
 *
 * @author biuaxia
 * @date 2020-11-07 22:34:32
 */
@Data
@Builder
public class ResponseAccessCodeReverse {

    private String loginToken;
    private String userId;

}
