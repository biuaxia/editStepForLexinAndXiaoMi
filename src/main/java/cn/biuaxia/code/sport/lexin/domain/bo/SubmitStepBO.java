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

import java.util.List;

/**
 * 响应提交步数BO
 *
 * @author biuaxia
 * @date 2020-09-19 03:42:42
 */
@NoArgsConstructor
@Data
public class SubmitStepBO {


    /**
     * code : 200
     * msg : 成功
     * data : {"pedometerRecordHourlyList":[{"id":"3408e1a29e1a461cadbf7aa9f86ba5bf","userId":27186378,"deviceId":"M_NULL","measurementTime":"2020-09-19 00:00:00","step":"0,9990,30012,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0","calories":"0,2497.00,8211.00,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0","distance":"0,3330.00,8211.00,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0","dataSource":4,"created":"2020-09-19 01:42:29","active":0,"updated":1600458152500}]}
     */

    private Integer code;
    private String msg;
    private DataDTO data;

    @NoArgsConstructor
    @Data
    public static class DataDTO {
        private List<PedometerRecordHourlyListDTO> pedometerRecordHourlyList;

        @NoArgsConstructor
        @Data
        public static class PedometerRecordHourlyListDTO {
            /**
             * id : 3408e1a29e1a461cadbf7aa9f86ba5bf
             * userId : 27186378
             * deviceId : M_NULL
             * measurementTime : 2020-09-19 00:00:00
             * step : 0,9990,30012,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0
             * calories : 0,2497.00,8211.00,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0
             * distance : 0,3330.00,8211.00,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0
             * dataSource : 4
             * created : 2020-09-19 01:42:29
             * active : 0
             * updated : 1600458152500
             */

            private String id;
            private Integer userId;
            private String deviceId;
            private String measurementTime;
            private String step;
            private String calories;
            private String distance;
            private Integer dataSource;
            private String created;
            private Integer active;
            private Long updated;
        }
    }
}
