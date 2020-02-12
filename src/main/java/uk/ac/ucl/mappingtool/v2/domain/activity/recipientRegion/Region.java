package uk.ac.ucl.mappingtool.v2.domain.activity.recipientRegion;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Region {
    private String url;
    private String code;
    private String name;
}
