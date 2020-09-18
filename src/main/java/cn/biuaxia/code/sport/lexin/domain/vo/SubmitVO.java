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

package cn.biuaxia.code.sport.lexin.domain.vo;

import lombok.Builder;
import org.springframework.http.HttpStatus;

/**
 * @author biuaxia
 * @date 2020-09-19 03:53:50
 */
@Builder
@lombok.Data
public class SubmitVO implements IVO {

    @Builder.Default
    private Integer code = HttpStatus.OK.value();

    @Builder.Default
    private String msg = SUBMIT + SUCCESS;

    private Data data;

    @Builder
    @lombok.Data
    public static class Data {

        private String userId;

        private String username;

        private Integer step;

    }

}
