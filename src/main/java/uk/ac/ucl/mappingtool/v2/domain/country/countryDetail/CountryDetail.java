package uk.ac.ucl.mappingtool.v2.domain.country.countryDetail;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CountryDetail {
    private String code;
//    private String language;
    private String activities;
    private CountryLocation location;
//    private CountryPolygon polygon;

}
