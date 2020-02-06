package uk.ac.ucl.mappingtool.v2.domain.transaction;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uk.ac.ucl.mappingtool.v2.domain.abstractAttributes.script.Script;
import uk.ac.ucl.mappingtool.v2.domain.abstractAttributes.type.Type;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {
    private String url;
    private Type transaction_type;
    private String transaction_date;
    private String value;
    private Type currency;
    private Script description;
    private Organisation provider_organisation;
    private Organisation receiver_organisation;
    private Type disbursement_channel;
    private Type flow_type;
    private Type finance_type;
    private Type aid_type;
    private Type tied_status;
}
