package uk.ac.ucl.mappingtool.v2.domain.map.mainMap;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uk.ac.ucl.mappingtool.v2.domain.abstractAttributes.coordinate.Coordinate;

/**
 * This is a pin item for each activity/project
 * which includes Coordinate, Country Code and Total Activity Count
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectPin {
    private String code;
    private String countryName;
    private Coordinate coordinate;
    private Integer activityCount;
}
