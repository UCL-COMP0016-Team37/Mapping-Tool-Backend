package uk.ac.ucl.mappingtool.v2.domain.abstractAttributes.coordinate;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Coordinate {
    private String longitude;
    private String latitude;
}
