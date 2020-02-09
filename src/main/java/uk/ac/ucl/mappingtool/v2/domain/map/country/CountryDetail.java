package uk.ac.ucl.mappingtool.v2.domain.map.country;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CountryDetail {
    private String code;
    private String language;
    private String activities;
    private Location location;
    private Polygon polygon;


    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    private class Location{
        private String type;
        private List<Double> coordinates;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    private class Polygon {
        private String type;
        private List<List<List<Double>>> coordinates;
    }
}
