package uk.ac.ucl.mappingtool.v2.domain.activity.location;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uk.ac.ucl.mappingtool.v2.domain.activity.vocabulary.Vocabulary;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class LocationId {
    private Vocabulary vocabulary;
    private String code;
}
