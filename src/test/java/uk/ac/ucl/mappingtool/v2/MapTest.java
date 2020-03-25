package uk.ac.ucl.mappingtool.v2;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.junit.Test;
import uk.ac.ucl.mappingtool.util.HttpRequest;
import uk.ac.ucl.mappingtool.v2.domain.analysis.request.budget.BudgetQuery;
import uk.ac.ucl.mappingtool.v2.domain.analysis.request.budget.BudgetQueryItem;
import uk.ac.ucl.mappingtool.v2.domain.analysis.request.budget.Organisation;
import uk.ac.ucl.mappingtool.v2.domain.analysis.request.budget.RecipientCountry;
import uk.ac.ucl.mappingtool.v2.domain.country.countryRes.ActivityDisplayItem;
import uk.ac.ucl.mappingtool.v2.domain.result.ListView;

import java.lang.reflect.Type;
import java.util.List;

public class MapTest {
    @Test
    public void testRequestURL(){
        StringBuilder sb = new StringBuilder();
        sb.append("https://iatidatastore.iatistandard.org/api/activities/?"); // base url
        sb.append("format=json&");  // format
        sb.append("fields=title&"); // fields

        sb.append("recipient_country=");
        sb.append("AF");
        sb.append("&");
        sb.append("page=");
        sb.append("2");

        String url = sb.toString();

        String json = HttpRequest.requestJson(url);
        Type countryType = new TypeToken<ListView<ActivityDisplayItem>>(){}.getType();

        Gson gson = new Gson();
        ListView<ActivityDisplayItem> countryListView = gson.fromJson(json, countryType);

        System.out.println(countryListView.getResults());
    }

    @Test
    public void testFlowMap(){
        String url = "https://iatidatastore.iatistandard.org/api/transactions/aggregations/?group_by=reporting_organisation&aggregations=activity_count,value&format=json&recipient_country=AF";

        String json = HttpRequest.requestJson(url);

        Type queryType = new TypeToken<BudgetQuery<Organisation>>(){} .getType();

        Gson gson = new Gson();
        BudgetQuery budgetQueryObject = gson.fromJson(json, queryType);

        // get list
        List<BudgetQueryItem<Organisation>> results = budgetQueryObject.getResults();

        System.out.println(results);

    }
}
