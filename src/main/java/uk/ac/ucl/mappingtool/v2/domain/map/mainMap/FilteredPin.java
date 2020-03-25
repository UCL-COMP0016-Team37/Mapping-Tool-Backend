package uk.ac.ucl.mappingtool.v2.domain.map.mainMap;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uk.ac.ucl.mappingtool.v2.domain.abstractAttributes.coordinate.Coordinate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FilteredPin {
    private String code;
    private String countryName;
    private Coordinate coordinate;
    private Integer activityCount;
    private Double value;
}
