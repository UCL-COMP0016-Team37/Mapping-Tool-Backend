package uk.ac.ucl.mappingtool.v2.domain.analysis.response.topOrgGraph;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uk.ac.ucl.mappingtool.v2.domain.analysis.response.ResponseItem;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TopFilteredOrgs {
    private Integer totalOrgs; // total orgs
    private List<ResponseItem> tops;
    private ResponseItem rest;

}
