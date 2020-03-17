package uk.ac.ucl.mappingtool.v2;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.junit.Test;
import uk.ac.ucl.mappingtool.util.HttpRequest;
import uk.ac.ucl.mappingtool.v2.domain.analysis.request.Query;
import uk.ac.ucl.mappingtool.v2.domain.analysis.request.budget.BudgetQueryItem;
import uk.ac.ucl.mappingtool.v2.domain.analysis.request.budget.RecipientCountry;
import uk.ac.ucl.mappingtool.v2.domain.analysis.response.CountryItem;
import uk.ac.ucl.mappingtool.v2.domain.analysis.response.budgetToGraph.BudgetToCountry;

import java.lang.reflect.Type;
import java.util.*;

public class AnalysisTest {
    @Test
    public void testQueryAll(){
        String url = "https://iatidatastore.iatistandard.org/api/budgets/aggregations/?group_by=recipient_country&aggregations=value,activity_count&format=json";
        String json = HttpRequest.requestJson(url);
//        System.out.println(json);

        Type queryType = new TypeToken<Query<RecipientCountry>>(){} .getType();

        Gson gson = new Gson();
        Query queryObject = gson.fromJson(json, queryType);

        System.out.println(queryObject);
    }

    @Test
    public void testSortQuery(){
        String url = "https://iatidatastore.iatistandard.org/api/budgets/aggregations/?group_by=recipient_country&aggregations=value,activity_count&format=json&sector=110";
        String json = HttpRequest.requestJson(url);
//        System.out.println(json);

        Type queryType = new TypeToken<Query<RecipientCountry>>(){}.getType();

        Gson gson = new Gson();
        Query queryObject = gson.fromJson(json, queryType);

        // get list
        List<BudgetQueryItem<RecipientCountry>> results = queryObject.getResults();

        // compare the list by value in usd (max to min)
        Collections.sort(results, new Comparator<BudgetQueryItem>() {
            @Override
            public int compare(BudgetQueryItem o1, BudgetQueryItem o2) {
                if (o1.getValue() > o2.getValue()){
                    return -1;
                } else if(o1.getValue() < o2.getValue()){
                    return 1;
                } else{
                    return 0;
                }
            }
        });

        System.out.println(results);
    }

    @Test
    public void testBuildGraph(){
        String url = "https://iatidatastore.iatistandard.org/api/budgets/aggregations/?group_by=recipient_country&aggregations=value,activity_count&format=json&sector=110";
        String json = HttpRequest.requestJson(url);
//        System.out.println(json);

        Type queryType = new TypeToken<Query<RecipientCountry>>(){} .getType();

        Gson gson = new Gson();
        Query queryObject = gson.fromJson(json, queryType);

        // get list
        List<BudgetQueryItem<RecipientCountry>> results = queryObject.getResults();
        // get value
        Integer count = queryObject.getCount();

        // compare the list by value in usd (max to min)
        Collections.sort(results, new Comparator<BudgetQueryItem>() {
            @Override
            public int compare(BudgetQueryItem o1, BudgetQueryItem o2) {
                if (o1.getValue() > o2.getValue()){
                    return -1;
                } else if(o1.getValue() < o2.getValue()){
                    return 1;
                } else{
                    return 0;
                }
            }
        });

//        System.out.println(results);

        // sum up the total
        double total = 0;
        for(BudgetQueryItem item : results){
            total += item.getValue();
        }

        double rest = total;

        // get the top 4 and rest
        List<CountryItem> tops = new ArrayList<>();


        for(int i = 0; i < 4; i++){
            RecipientCountry recipientCountry = (RecipientCountry)results.get(i).getGroup();

            String name = recipientCountry.getName();
            Double value = results.get(i).getValue();
            rest -= value;

            Double percentage = value * 100 / total;

            // make the object
            CountryItem item = new CountryItem(name, Math.round(value), percentage);
            tops.add(item);
        }
        // rest item
        Integer restCount = count - 4;
        String countryNarrative = restCount.toString() + " More";

        Double restPercentage = rest * 100 / total;

        CountryItem restItem = new CountryItem(countryNarrative, Math.round(rest), restPercentage);

        // build graph
        BudgetToCountry graph = new BudgetToCountry(count, tops, restItem);

        System.out.println(graph);
    }

    @Test
    public void testLessThanFive(){
        String url = "https://iatidatastore.iatistandard.org/api/budgets/aggregations/?group_by=recipient_country&aggregations=value,activity_count&format=json&sector=1121";
        String json = HttpRequest.requestJson(url);
//        System.out.println(json);

        Type queryType = new TypeToken<Query<RecipientCountry>>(){} .getType();

        Gson gson = new Gson();
        Query queryObject = gson.fromJson(json, queryType);

        // get list
        List<BudgetQueryItem<RecipientCountry>> results = queryObject.getResults();
        // get value
        Integer count = queryObject.getCount();

        // compare the list by value in usd (max to min)
        Collections.sort(results, new Comparator<BudgetQueryItem>() {
            @Override
            public int compare(BudgetQueryItem o1, BudgetQueryItem o2) {
                if (o1.getValue() > o2.getValue()){
                    return -1;
                } else if(o1.getValue() < o2.getValue()){
                    return 1;
                } else{
                    return 0;
                }
            }
        });

        if(count == 0){
           System.out.println("no graph");
        }else if(count > 0 && count <= 5){
            // calc total
            double total = 0;
            for(BudgetQueryItem item : results){
                total += item.getValue();
            }

            // get the top 4 and rest
            List<CountryItem> tops = new ArrayList<>();


            for(int i = 0; i < count; i++){
                RecipientCountry recipientCountry = (RecipientCountry)results.get(i).getGroup();

                String name = recipientCountry.getName();
                Double value = results.get(i).getValue();

                Double percentage = value * 100 / total;

                // make the object
                CountryItem item = new CountryItem(name, Math.round(value), percentage);
                tops.add(item);
            }

            System.out.println(tops);


        }else {
            System.out.println("produce graph");
        }
    }

    @Test
    public void testTransactionToCountry(){
        String url = "https://iatidatastore.iatistandard.org/api/transactions/aggregations/?group_by=recipient_country&aggregations=activity_count,value&format=json&sector=112";
        String json = HttpRequest.requestJson(url);
//        System.out.println(json);

        Type queryType = new TypeToken<Query<RecipientCountry>>(){}.getType();

        Gson gson = new Gson();
        Query queryObject = gson.fromJson(json, queryType);

        // get list
        List<BudgetQueryItem<RecipientCountry>> results = queryObject.getResults();

        // compare the list by value in usd (max to min)
        Collections.sort(results, new Comparator<BudgetQueryItem>() {
            @Override
            public int compare(BudgetQueryItem o1, BudgetQueryItem o2) {
                if (o1.getValue() > o2.getValue()){
                    return -1;
                } else if(o1.getValue() < o2.getValue()){
                    return 1;
                } else{
                    return 0;
                }
            }
        });

        System.out.println(results);
    }

    @Test
    public void testTransactionToOrg(){
        String url = "https://iatidatastore.iatistandard.org/api/transactions/aggregations/?group_by=receiver_org&aggregations=activity_count,value&format=json&sector_category=112";
        String json = HttpRequest.requestJson(url);
//        System.out.println(json);

        Type queryType = new TypeToken<Query<String>>(){}.getType();

        Gson gson = new Gson();
        Query queryObject = gson.fromJson(json, queryType);

        // get list
        List<BudgetQueryItem<String>> results = queryObject.getResults();

        // compare the list by value in usd (max to min)
        Collections.sort(results, new Comparator<BudgetQueryItem>() {
            @Override
            public int compare(BudgetQueryItem o1, BudgetQueryItem o2) {
                if (o1.getValue() > o2.getValue()){
                    return -1;
                } else if(o1.getValue() < o2.getValue()){
                    return 1;
                } else{
                    return 0;
                }
            }
        });

        System.out.println(results);
    }

    @Test
    public void testTransactionFromOrg(){
        String url = "https://iatidatastore.iatistandard.org/api/transactions/aggregations/?group_by=provider_org&aggregations=activity_count,value&format=json&sector_category=112";
        String json = HttpRequest.requestJson(url);
//        System.out.println(json);

        Type queryType = new TypeToken<Query<String>>(){}.getType();

        Gson gson = new Gson();
        Query queryObject = gson.fromJson(json, queryType);

        // get list
        List<BudgetQueryItem<String>> results = queryObject.getResults();

        // compare the list by value in usd (max to min)
        Collections.sort(results, new Comparator<BudgetQueryItem>() {
            @Override
            public int compare(BudgetQueryItem o1, BudgetQueryItem o2) {
                if (o1.getValue() > o2.getValue()){
                    return -1;
                } else if(o1.getValue() < o2.getValue()){
                    return 1;
                } else{
                    return 0;
                }
            }
        });

        System.out.println(results);
    }



}
