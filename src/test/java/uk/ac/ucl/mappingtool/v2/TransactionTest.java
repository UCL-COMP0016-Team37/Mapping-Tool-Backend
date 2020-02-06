package uk.ac.ucl.mappingtool.v2;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.junit.Test;
import uk.ac.ucl.mappingtool.util.HttpRequest;
import uk.ac.ucl.mappingtool.v2.domain.result.ListView;
import uk.ac.ucl.mappingtool.v2.domain.transaction.Transaction;

import java.lang.reflect.Type;

public class TransactionTest {

    @Test
    public void testSerializeOne(){
        String json = "{\"activity\":{\"url\":\"http://iatidatastore.iatistandard.org/api/activities/2839519/?format=json\",\"id\":\"2839519\",\"iati_identifier\":\"DAC-1601-OPP1122162\",\"title\":{\"narratives\":[{\"text\":\"Ebola: Emergency Response to Ebola Crisis in West Africa\",\"language\":{\"code\":\"en\",\"name\":\"English\"}}]}},\"url\":\"http://iatidatastore.iatistandard.org/api/transactions/16220072/?format=json\",\"ref\":null,\"humanitarian\":null,\"transaction_type\":{\"code\":\"2\",\"name\":\"Outgoing Commitment\"},\"transaction_date\":\"2014-10-13\",\"value\":\"3000000.00\",\"value_date\":\"2014-10-13\",\"currency\":{\"code\":\"USD\",\"name\":\"US Dollar\"},\"description\":null,\"provider_organisation\":{\"ref\":\"DAC-1601\",\"type\":{\"code\":\"60\",\"name\":\"Foundation\"},\"provider_activity\":null,\"provider_activity_id\":null,\"narratives\":[{\"text\":\"Bill and Melinda Gates Foundation\",\"language\":{\"code\":\"en\",\"name\":\"English\"}}]},\"receiver_organisation\":{\"ref\":\"\",\"type\":null,\"receiver_activity\":null,\"receiver_activity_id\":null,\"narratives\":[{\"text\":\"International Federation of Red Cross and Red Crescent Societies\",\"language\":{\"code\":\"en\",\"name\":\"English\"}}]},\"disbursement_channel\":{\"code\":\"4\",\"name\":\"Aid in kind: Donors manage funds themselves\"},\"sector\":null,\"recipient_country\":null,\"recipient_region\":null,\"flow_type\":{\"code\":\"30\",\"name\":\"Private Development Finance\"},\"finance_type\":{\"code\":\"110\",\"name\":\"Standard grant\"},\"aid_type\":null,\"tied_status\":{\"code\":\"5\",\"name\":\"Untied\"},\"sectors\":[],\"iati_identifier\":\"DAC-1601-OPP1122162\",\"recipient_countries\":[],\"recipient_regions\":[]}";

        String activityJson = json;
        Gson gson = new Gson();
        Transaction transactionObject = gson.fromJson(activityJson, Transaction.class);

        /* serialize it*/
        GsonBuilder gsonBuilder = new GsonBuilder();
        // serialize null value
        gsonBuilder.serializeNulls();

        gson = gsonBuilder.create();
        String result = gson.toJson(transactionObject);

        System.out.println(result);
    }

    @Test
    public void testSerializeListView() {
        String url = "https://iatidatastore.iatistandard.org/api/activities/2839519/transactions/?format=json";
        String json = HttpRequest.requestJson(url);

        Type transactionType = new TypeToken<ListView<Transaction>>() {}.getType();

        Gson gson = new Gson();
        ListView<Transaction> transactionList = gson.fromJson(json, transactionType);

        System.out.println(transactionList);
    }
}
