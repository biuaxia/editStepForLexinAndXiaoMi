package cn.biuaxia.code.sport.components.xiaomi.reverse;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 *
 * @author biuaxia
 * @date 2020-11-08 00:02:32
 */
@NoArgsConstructor
@Data
public class ResponseAppTokenReverse {

    private TokenInfoDTO tokenInfo;
    private String result;
    private List<DomainsDTO> domains;

    @NoArgsConstructor
    @Data
    public static class TokenInfoDTO {

        private String appToken;
        private String userId;
        private Integer appTtl;

    }

    @NoArgsConstructor
    @Data
    public static class DomainsDTO {

        private String host;
        private List<String> cnames;

    }

}
