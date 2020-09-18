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

import cn.hutool.core.date.DateUtil;
import lombok.Builder;
import lombok.Data;

/**
 * 提交步数DTO
 *
 * @author biuaxia
 * @date 2020-09-19 03:33:51
 */
@Builder
@Data
public class SubmitStepDTO {

    @Builder.Default
    private Long updated = System.currentTimeMillis();

    @Builder.Default
    private String measurementTime = DateUtil.formatDateTime(DateUtil.date());

    @Builder.Default
    private String deviceId = "M_NULL";

    @Builder.Default
    private Integer isUpload = 0;

    @Builder.Default
    private Integer type = 2;

    @Builder.Default
    private Integer exerciseTime = 0;

    @Builder.Default
    private Integer DataSource = 2;

    private Long userId;
    private Integer step;
    private Integer calories;
    private Integer distance;

}
