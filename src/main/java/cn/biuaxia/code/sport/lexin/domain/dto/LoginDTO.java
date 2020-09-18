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

package cn.biuaxia.code.sport.lexin.domain.dto;

import lombok.Builder;
import lombok.Data;

/**
 * 登录DTO
 *
 * @author biuaxia
 * @date 2020-09-19 02:56:45
 */
@Builder
@Data
public class LoginDTO {


    /**
     * loginName : 17608348340
     * password : b69f0c9743c84b1e04fbefd2129abedc
     * clientId : 8e844e28db7245eb81823132464835eb
     * appType : 6
     * roleType : 0
     */

    private String loginName;
    private String password;

    @Builder.Default
    private String clientId = "8e844e28db7245eb81823132464835eb";

    @Builder.Default
    private Integer appType = 6;

    @Builder.Default
    private Integer roleType = 0;

}
