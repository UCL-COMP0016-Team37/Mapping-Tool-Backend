package uk.ac.ucl.mappingtool.v2.domain.activity.recipientCountry;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Country {
    private String url;
    private String code;
    private String name;
}
