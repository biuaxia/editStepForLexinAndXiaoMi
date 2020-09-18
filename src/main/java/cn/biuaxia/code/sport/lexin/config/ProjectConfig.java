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

package cn.biuaxia.code.sport.lexin.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author biuaxia
 * @date 2020-09-19 02:51:17
 */
@Data
@Component
@ConfigurationProperties(prefix = "lexin")
public class ProjectConfig {

    /**
     * 登录地址
     */
    private String loginUrl;

    /**
     * 提交步数地址
     */
    private String stepUrl;

}
