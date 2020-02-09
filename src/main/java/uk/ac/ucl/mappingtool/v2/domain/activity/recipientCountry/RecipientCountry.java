package uk.ac.ucl.mappingtool.v2.domain.activity.recipientCountry;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uk.ac.ucl.mappingtool.v2.domain.abstractAttributes.narrative.Narrative;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecipientCountry {
    private Country country;
    private Double percentage;
    private List<Narrative> narratives;
}
