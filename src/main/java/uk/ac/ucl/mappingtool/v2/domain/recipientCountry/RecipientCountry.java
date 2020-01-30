package uk.ac.ucl.mappingtool.v2.domain.recipientCountry;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecipientCountry {
    private Country country;
    private Integer percentage;
    private List<String> narratives;
}
