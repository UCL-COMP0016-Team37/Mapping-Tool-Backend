package uk.ac.ucl.mappingtool.v2.domain.analysis.request.budget;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecipientCountry {
    private String url;
    private String code;
    private String name;
    private String region;
}
