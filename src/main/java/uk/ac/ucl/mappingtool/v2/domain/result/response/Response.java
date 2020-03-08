package uk.ac.ucl.mappingtool.v2.domain.result.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Response {
    private Integer numFound;
    private Integer start;
    private List<ResponseContent> docs;
}
