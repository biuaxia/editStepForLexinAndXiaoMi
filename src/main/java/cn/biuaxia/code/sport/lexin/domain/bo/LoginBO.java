/*
 *
 *  * Copyright 2020-2030 biuaxia(https://github.com/biuaxia)
 *  *
 *  * Licensed under the Apache License, Version 2.0 (the "License");
 *  * you may not use this file except in compliance with the License.
 *  * You may obtain a copy of the License at
 *  *
 *  *     http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  * Unless required by applicable law or agreed to in writing, software
 *  * distributed under the License is distributed on an "AS IS" BASIS,
 *  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  * See the License for the specific language governing permissions and
 *  * limitations under the License.
 *
 */

package cn.biuaxia.code.sport.lexin.domain.bo;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 响应登录BO
 *
 * @author biuaxia
 * @date 2020-09-19 03:13:04
 */
@NoArgsConstructor
@Data
public class LoginBO {

    /**
     * code : 200
     * msg : 成功
     * data : {"exist":false,"hasMobile":false,"hasEmail":false,"userId":"27186378","accessToken":"D2A6AFB93531605DBE56DC2EEE74C4C9BFEE0B551A27B212F169F58CE2BBAEE3689F2A8E3ECE2095AE34539166BC2CB40E96CCE9C907E4301A29E1A30F16F6EEC17D8D5A879EBB26D0123956A999B5A6BA63E1E3FA17D589BBDBAD86C52B083D.C46511D0F0E6BB7A058760AD313456F2BBCB530292E177E3DB9543C38DAE9EEB","expireAt":1603045732246,"userType":99,"needInfo":false}
     */

    private Integer code;
    private String msg;
    private DataDTO data;

    @NoArgsConstructor
    @Data
    public static class DataDTO {
        /**
         * exist : false
         * hasMobile : false
         * hasEmail : false
         * userId : 27186378
         * accessToken : D2A6AFB93531605DBE56DC2EEE74C4C9BFEE0B551A27B212F169F58CE2BBAEE3689F2A8E3ECE2095AE34539166BC2CB40E96CCE9C907E4301A29E1A30F16F6EEC17D8D5A879EBB26D0123956A999B5A6BA63E1E3FA17D589BBDBAD86C52B083D.C46511D0F0E6BB7A058760AD313456F2BBCB530292E177E3DB9543C38DAE9EEB
         * expireAt : 1603045732246
         * userType : 99
         * needInfo : false
         */

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
