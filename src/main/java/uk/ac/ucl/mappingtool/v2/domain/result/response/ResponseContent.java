package uk.ac.ucl.mappingtool.v2.domain.result.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseContent {
    private String iati_identifier;
    private List<String> title_narrative;  // title
    private List<String> title_narrative_lang;  // language

}
