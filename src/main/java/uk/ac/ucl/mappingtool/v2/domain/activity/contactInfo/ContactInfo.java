package uk.ac.ucl.mappingtool.v2.domain.activity.contactInfo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uk.ac.ucl.mappingtool.v2.domain.abstractAttributes.script.Script;
import uk.ac.ucl.mappingtool.v2.domain.abstractAttributes.type.Type;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContactInfo {
    private Type type;
    private Script organisation;
    private Script department;
    private Script person_name;
    private Script job_title;
    private String telephone;
    private String email;
    private String website;
    private Script mailing_address;
}
