package cn.biuaxia.code.sport.components.lexin.reverse;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author biuaxia
 * @date 2020-11-07 21:23:24
 */
@Data
@NoArgsConstructor
public class ResponseLoginReverse {

    private Integer code;
    private String msg;
    private DataReverse data;

    @Data
    @NoArgsConstructor
    public static class DataReverse {

        private Boolean exist;
        private Boolean hasMobile;
        private Boolean hasEmail;
        private String userId;
        private String accessToken;
        private Long expireAt;
        private Integer userType;
        private Boolean needInfo;

    }

}
