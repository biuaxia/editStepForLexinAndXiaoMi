package cn.biuaxia.code.sport.components.xiaomi.reverse;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author biuaxia
 * @date 2020-11-07 23:52:32
 */
@Data
@NoArgsConstructor
public class ResponseLoginReverse {

    @JsonProperty("token_info")
    private TokenInfoDTO tokenInfo;

    @JsonProperty("regist_info")
    private RegistInfoDTO registInfo;

    @JsonProperty("thirdparty_info")
    private ThirdpartyInfoDTO thirdpartyInfo;

    @JsonProperty("result")
    private String result;

    @JsonProperty("domain")
    private DomainDTO domain;

    @Data
    @NoArgsConstructor
    public static class TokenInfoDTO {

        @JsonProperty("login_token")
        private String loginToken;

        @JsonProperty("app_token")
        private String appToken;

        @JsonProperty("user_id")
        private String userId;

        @JsonProperty("ttl")
        private Integer ttl;

        @JsonProperty("app_ttl")
        private Integer appTtl;

    }

    @Data
    @NoArgsConstructor
    public static class RegistInfoDTO {

        @JsonProperty("is_new_user")
        private Integer isNewUser;

        @JsonProperty("regist_date")
        private Long registDate;

        @JsonProperty("region")
        private String region;

    }

    @Data
    @NoArgsConstructor
    public static class ThirdpartyInfoDTO {

        @JsonProperty("nickname")
        private String nickname;

        @JsonProperty("icon")
        private String icon;

        @JsonProperty("third_id")
        private String thirdId;

        @JsonProperty("email")
        private String email;

    }

    @Data
    @NoArgsConstructor
    public static class DomainDTO {

        @JsonProperty("id-dns")
        private String iddns;

    }
}
