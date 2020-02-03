package uk.ac.ucl.mappingtool.v2.domain.activity.narrative;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Narrative {
    private String text;
    private Language language;
}