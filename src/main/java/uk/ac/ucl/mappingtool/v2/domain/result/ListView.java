package uk.ac.ucl.mappingtool.v2.domain.result;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListView<T> {
    private Integer count;
    private String next;
    private String previous;
    private List<T> results;
}
