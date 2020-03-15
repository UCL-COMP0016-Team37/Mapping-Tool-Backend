package uk.ac.ucl.mappingtool.v2;

import com.google.gson.Gson;
import io.swagger.models.auth.In;
import org.junit.Test;
import uk.ac.ucl.mappingtool.util.HttpRequest;
import uk.ac.ucl.mappingtool.v2.domain.analysis.request.Query;
import uk.ac.ucl.mappingtool.v2.domain.analysis.request.QueryItem;
import uk.ac.ucl.mappingtool.v2.domain.analysis.response.FundingToGraph.CountryItem;
import uk.ac.ucl.mappingtool.v2.domain.country.Country;

import java.util.*;

public class AnalysisTest {
    @Test
    public void testQueryAll(){
        String url = "https://iatidatastore.iatistandard.org/api/budgets/aggregations/?group_by=recipient_country&aggregations=value,activity_count&format=json";
        String json = HttpRequest.requestJson(url);
//        System.out.println(json);

        Gson gson = new Gson();
        Query queryObject = gson.fromJson(json, Query.class);

        System.out.println(queryObject);
    }

    @Test
    public void testSortQuery(){
        String url = "https://iatidatastore.iatistandard.org/api/budgets/aggregations/?group_by=recipient_country&aggregations=value,activity_count&format=json&sector=110";
        String json = HttpRequest.requestJson(url);
//        System.out.println(json);

        Gson gson = new Gson();
        Query queryObject = gson.fromJson(json, Query.class);

        // get list
        List<QueryItem> results = queryObject.getResults();

        // compare the list by value in usd (max to min)
        Collections.sort(results, new Comparator<QueryItem>() {
            @Override
            public int compare(QueryItem o1, QueryItem o2) {
                if (o1.getValue() > o2.getValue()){
                    return -1;
                } else if(o1.getValue() < o2.getValue()){
                    return 1;
                } else{
                    return 0;
                }
            }
        });
    }

    @Test
    public void testBuildGraph(){
        String url = "https://iatidatastore.iatistandard.org/api/budgets/aggregations/?group_by=recipient_country&aggregations=value,activity_count&format=json&sector=110";
        String json = HttpRequest.requestJson(url);
//        System.out.println(json);

        Gson gson = new Gson();
        Query queryObject = gson.fromJson(json, Query.class);

        // get list
        List<QueryItem> results = queryObject.getResults();

        // compare the list by value in usd (max to min)
        Collections.sort(results, new Comparator<QueryItem>() {
            @Override
            public int compare(QueryItem o1, QueryItem o2) {
                if (o1.getValue() > o2.getValue()){
                    return -1;
                } else if(o1.getValue() < o2.getValue()){
                    return 1;
                } else{
                    return 0;
                }
            }
        });

        // sum up the total
        double total = 0;
        for(QueryItem item : results){
            total += item.getValue();
        }

        // get the top 4 and rest
        List<CountryItem> tops = new ArrayList<>();
        for(int i = 0; i < 4; i++){
            String name = results.get(i).getRecipient_country().getName();
            Double value = results.get(i).getValue();
            Double percentage = value * 100 / total;

            // make the object
            CountryItem item = new CountryItem(name, Math.round(value), percentage);
            tops.add(item);
        }

        System.out.println(tops);

    }



}
