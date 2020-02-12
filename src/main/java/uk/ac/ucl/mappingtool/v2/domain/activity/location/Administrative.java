package uk.ac.ucl.mappingtool.v2.domain.activity.location;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uk.ac.ucl.mappingtool.v2.domain.abstractAttributes.vocabulary.Vocabulary;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Administrative {
    private Integer id;
    private String code;
    private Vocabulary vocabulary;
    private Integer level;
}
