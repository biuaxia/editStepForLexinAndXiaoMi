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

package cn.biuaxia.code.sport.engine.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 项目配置
 *
 * @author biuaxia
 * @date 2020-09-19 02:51:17
 */
@Data
@Component
public class ProjectConfig {

    /**
     * 登录地址
     */
    @Value("${project.lexin.login-url}")
    private String lexinLoginUrl;

    /**
     * 提交步数地址
     */
    @Value("${project.lexin.step-url}")
    private String lexinStepUrl;

    /**
     * 获取AccessCode地址
     */
    @Value("${project.xiaomi.access-code-url}")
    private String xiaomiAccessCodeUrl;

    /**
     * 获取AccessCode后重定向地址
     */
    @Value("${project.xiaomi.access-code-redirect-url}")
    private String xiaomiAccessCodeRedirectUrl;

    /**
     * 登录地址
     */
    @Value("${project.xiaomi.login-url}")
    private String xiaomiLoginUrl;

    /**
     * 获取AppToken地址
     */
    @Value("${project.xiaomi.app-token-url}")
    private String xiaomiAppTokenUrl;

    /**
     * 更新步数地址
     */
    @Value("${project.xiaomi.update-step-url}")
    private String xiaomiUpdateStepUrl;

}
