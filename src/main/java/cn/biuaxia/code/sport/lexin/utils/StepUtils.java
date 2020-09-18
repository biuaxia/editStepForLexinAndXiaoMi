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
import cn.biuaxia.code.sport.lexin.domain.bo.SubmitStepBO;
import cn.biuaxia.code.sport.lexin.domain.dto.SubmitStepDTO;
import cn.hutool.core.map.MapUtil;
import cn.hutool.http.Header;
import cn.hutool.http.HttpRequest;
import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 步数工具类
 *
 * @author biuaxia
 * @date 2020-09-19 03:30:44
 */
@Slf4j
@Component
public class StepUtils {

    public static final String LIST = "list";

    @Autowired
    private ProjectConfig projectConfig;

    /**
     * 提交步数
     *
     * @param userId 用户唯一标识
     * @param step   步数
     * @return 是否提交成功
     */
    public Boolean submit(String userId, int step) {
        int calories = step / 4;
        int distance = step / 3;
        final SubmitStepDTO submitStepDTO = SubmitStepDTO.builder()
                .userId(Long.parseLong(userId))
                .step(step)
                .calories(calories)
                .distance(distance)
                .build();

        final HashMap<String, List<SubmitStepDTO>> map = new HashMap<>(MapUtil.DEFAULT_INITIAL_CAPACITY);
        final ArrayList<SubmitStepDTO> submitStepDTOS = new ArrayList<>();
        submitStepDTOS.add(submitStepDTO);
        map.put(LIST, submitStepDTOS);
        log.info("map: [{}]", JSONUtil.toJsonPrettyStr(map));

        final String stepUrl = projectConfig.getStepUrl();
        final String body = HttpRequest.post(stepUrl)
                .header(Header.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(JSONUtil.toJsonStr(map))
                .timeout(20000)
                .execute().body();
        final SubmitStepBO submitStepBO = JSONUtil.toBean(body, SubmitStepBO.class);
        log.info("submitStepBO: [{}]", JSONUtil.toJsonPrettyStr(submitStepBO));
        if (!Integer.valueOf(HttpStatus.OK.value()).equals(submitStepBO.getCode())) {
            log.warn("Try submit step to lexin, failed!");
            return false;
        }
        return true;
    }

}
