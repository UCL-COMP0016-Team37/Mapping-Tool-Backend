package uk.ac.ucl.mappingtool.v2.domain.analysis.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseItem {
    private String name;
    private Long number;
    private Double percentage;
}
