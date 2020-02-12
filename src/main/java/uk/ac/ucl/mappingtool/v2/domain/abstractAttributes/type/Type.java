package uk.ac.ucl.mappingtool.v2.domain.abstractAttributes.type;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Type {
    private String code;
    private String name;
}
