package uk.ac.ucl.mappingtool.v2.domain.map.country;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Country {
    private String code;
    private String name;
    private String url;
    private String longitude;
    private String latitude;
}
