package cn.biuaxia.code.sport.components.lexin.reverse;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 *
 * @author biuaxia
 * @date 2020-11-07 21:23:24
 */
@Data
@NoArgsConstructor
public class ResponseUpdateStepsReverse {

    private Integer code;
    private String msg;
    private DataReverse data;

    @Data
    @NoArgsConstructor
    public static class DataReverse {

        private List<PedometerRecordHourlyListDTO> pedometerRecordHourlyList;

        @NoArgsConstructor
        @Data
        public static class PedometerRecordHourlyListDTO {

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
