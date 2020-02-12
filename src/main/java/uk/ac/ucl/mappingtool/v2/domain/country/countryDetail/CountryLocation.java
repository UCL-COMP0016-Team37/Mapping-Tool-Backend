package uk.ac.ucl.mappingtool.v2.domain.country.countryDetail;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CountryLocation{
    private String type;
    private List<Double> coordinates;
}
