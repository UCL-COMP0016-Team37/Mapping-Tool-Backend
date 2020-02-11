package uk.ac.ucl.mappingtool.v2.domain.map.fundingFlow;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uk.ac.ucl.mappingtool.v2.domain.abstractAttributes.coordinate.Coordinate;
import uk.ac.ucl.mappingtool.v2.domain.transaction.Transaction;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Funding {
    private Transaction transaction;
    private Coordinate from;
    private Coordinate to;
}
