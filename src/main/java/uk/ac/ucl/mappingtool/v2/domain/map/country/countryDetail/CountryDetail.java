package uk.ac.ucl.mappingtool.v2.domain.map.country.countryDetail;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
public class CountryDetail {
    private String code;
//    private String language;
    private String activities;
    private CountryLocation location;
//    private CountryPolygon polygon;

}
