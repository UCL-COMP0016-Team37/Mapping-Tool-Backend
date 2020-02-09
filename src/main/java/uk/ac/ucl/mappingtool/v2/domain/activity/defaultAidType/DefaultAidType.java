package uk.ac.ucl.mappingtool.v2.domain.activity.defaultAidType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uk.ac.ucl.mappingtool.v2.domain.abstractAttributes.vocabulary.Vocabulary;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DefaultAidType {
    private AidType aid_type;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    private class AidType{
        private String code;
        private String name;
        private Vocabulary vocabulary;
    }
}
