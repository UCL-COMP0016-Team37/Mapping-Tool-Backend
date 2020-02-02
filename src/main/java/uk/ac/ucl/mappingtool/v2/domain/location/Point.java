package uk.ac.ucl.mappingtool.v2.domain.location;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Point {
    private Pos pos;
    private String srsName;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    private class Pos{
        private String latitude;
        private String longitude;
    }
}
