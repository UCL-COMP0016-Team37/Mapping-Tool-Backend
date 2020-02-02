package uk.ac.ucl.mappingtool.v2.domain.otherIdentifier;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uk.ac.ucl.mappingtool.v2.domain.type.Type;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OtherIdentifier {
    private String ref;
    private Type type;
    private OwnerOrg owner_org;
}