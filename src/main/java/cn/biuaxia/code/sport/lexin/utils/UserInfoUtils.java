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

package cn.biuaxia.code.sport.lexin.utils;

import cn.biuaxia.code.sport.lexin.config.ProjectConfig;
import cn.biuaxia.code.sport.lexin.domain.bo.LoginBO;
import cn.biuaxia.code.sport.lexin.domain.dto.LoginDTO;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.http.Header;
import cn.hutool.http.HttpRequest;
import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

/**
 * 用户信息工具类
 *
 * @author biuaxia
 * @date 2020-09-19 02:54:47
 */
@Slf4j
@Component
public class UserInfoUtils {

    @Autowired
    private ProjectConfig projectConfig;

    /**
     * 通过登录接口获取用户信息
     *
     * @param username 用户名
     * @param password 密码
     * @return {@link LoginBO.DataDTO}
     */
    public LoginBO.DataDTO getUserInfo(String username, String password) {
        password = SecureUtil.md5(password);
        final LoginDTO loginDTO = LoginDTO.builder()
                .loginName(username)
                .password(password)
                .build();
        log.info("loginDTO: [{}]", JSONUtil.toJsonPrettyStr(loginDTO));

        final String loginUrl = projectConfig.getLoginUrl();
        final String body = HttpRequest.post(loginUrl)
                .header(Header.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(JSONUtil.toJsonStr(loginDTO))
                .timeout(20000)
                .execute().body();
        final LoginBO loginBO = JSONUtil.toBean(body, LoginBO.class);
        log.info("loginBO: [{}]", JSONUtil.toJsonPrettyStr(loginBO));
        if (!Integer.valueOf(HttpStatus.OK.value()).equals(loginBO.getCode())) {
            log.warn("Try login to lexin, failed!");
            return null;
        }
        return loginBO.getData();
    }

}
