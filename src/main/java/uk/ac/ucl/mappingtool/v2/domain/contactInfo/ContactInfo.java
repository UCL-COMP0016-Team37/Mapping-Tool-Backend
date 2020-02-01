package uk.ac.ucl.mappingtool.v2.domain.contactInfo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uk.ac.ucl.mappingtool.v2.domain.narrative.Narrative;
import uk.ac.ucl.mappingtool.v2.domain.script.Script;
import uk.ac.ucl.mappingtool.v2.domain.type.Type;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContactInfo {
    private Type type;
    private Organisation organisation;
    private Script department;
    private Script person_name;
    private Script job_title;
    private String telephone;
    private String email;
    private String website;
    private Script mailing_address;
}
