package uk.ac.ucl.mappingtool.v2.domain.analysis.response.sectorInGraph;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uk.ac.ucl.mappingtool.v2.domain.analysis.response.ResponseItem;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SectorInCountry {
    private Integer totalSector; // total number of sectors
    private List<ResponseItem> tops;
    private ResponseItem rest;
}
