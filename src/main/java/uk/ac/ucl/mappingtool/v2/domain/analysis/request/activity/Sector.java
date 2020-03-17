package uk.ac.ucl.mappingtool.v2.domain.analysis.request.activity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sector {
    private String url;
    private String name;
    private String code;
}

