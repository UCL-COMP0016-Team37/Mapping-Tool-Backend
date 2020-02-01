package uk.ac.ucl.mappingtool.v2.domain.narrative;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Language {
    private String code;
    private String name;
}
