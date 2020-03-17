package uk.ac.ucl.mappingtool.v2.service.Impl;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.stereotype.Service;
import uk.ac.ucl.mappingtool.util.HttpRequest;
import uk.ac.ucl.mappingtool.v2.domain.analysis.request.budget.BudgetQuery;
import uk.ac.ucl.mappingtool.v2.domain.analysis.request.budget.BudgetQueryItem;
import uk.ac.ucl.mappingtool.v2.domain.analysis.request.budget.RecipientCountry;
import uk.ac.ucl.mappingtool.v2.domain.analysis.response.CountryItem;
import uk.ac.ucl.mappingtool.v2.domain.analysis.response.budgetToGraph.BudgetToCountry;
import uk.ac.ucl.mappingtool.v2.domain.analysis.response.transactionFromGraph.TransactionFromOrg;
import uk.ac.ucl.mappingtool.v2.domain.analysis.response.transactionToGraph.TransactionToOrg;
import uk.ac.ucl.mappingtool.v2.service.AnalysisService;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class AnalysisServiceImpl implements AnalysisService {
    @Override
    public BudgetToCountry plotBudgetToCountryGraph(int sectorCode) {
        String url = "https://iatidatastore.iatistandard.org/api/budgets/aggregations/?group_by=recipient_country&aggregations=value,activity_count&format=json&sector=" + sectorCode;
        String json = HttpRequest.requestJson(url);

        Type queryType = new TypeToken<BudgetQuery<RecipientCountry>>(){} .getType();

        Gson gson = new Gson();
        BudgetQuery budgetQueryObject = gson.fromJson(json, queryType);

        // get list
        List<BudgetQueryItem<RecipientCountry>> results = budgetQueryObject.getResults();
        // get value
        Integer count = budgetQueryObject.getCount();

        // compare the list by value in usd (max to min)
        Collections.sort(results, new ValueComparator());

        // sum up the total
        double total = 0;
        for(BudgetQueryItem item : results){
            total += item.getValue();
        }

        double rest = total;

        /* determined by the count */
        if(count == 0){
            return null;  // cannot produce graph
        }else if(count > 0 && count <= 5){
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

            BudgetToCountry graph = new BudgetToCountry(count, tops, new CountryItem());
            return graph;

        }else{
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

            return graph;
        }
    }

    @Override
    public TransactionToOrg plotTransactionToOrgGraph(int sectorCode) {
        String url = "https://iatidatastore.iatistandard.org/api/transactions/aggregations/?group_by=receiver_org&aggregations=activity_count,value&format=json&sector_category=" + sectorCode;
        String json = HttpRequest.requestJson(url);
//        System.out.println(json);

        Type queryType = new TypeToken<BudgetQuery<String>>(){}.getType();

        Gson gson = new Gson();
        BudgetQuery budgetQueryObject = gson.fromJson(json, queryType);

        // get list
        List<BudgetQueryItem<String>> results = budgetQueryObject.getResults();
        // get value
        Integer count = budgetQueryObject.getCount();

        // compare the list by value in usd (max to min)
        Collections.sort(results, new ValueComparator());

        // sum up the total
        double total = 0;
        for(BudgetQueryItem item : results){
            total += item.getValue();
        }

        double rest = total;

        /* determined by the count */
        if(count == 0){
            return null; // no graphs will return
        }else if(count > 0 && count <= 5){
            List<CountryItem> tops = new ArrayList<>();

            for(int i = 0; i < count; i++){
                String name = results.get(i).getGroup(); // receiver Org Name
                Double value = results.get(i).getValue();

                Double percentage = value * 100 / total;

                // make the object
                CountryItem item = new CountryItem(name, Math.round(value), percentage);
                tops.add(item);
            }

            TransactionToOrg graph = new TransactionToOrg(count, tops, new CountryItem());
            return graph;
        }else{
            // get the top 4 and rest
            List<CountryItem> tops = new ArrayList<>();

            for(int i = 0; i < 4; i++){
                String name = results.get(i).getGroup(); // receiver Org Name
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
            TransactionToOrg graph = new TransactionToOrg(count, tops, restItem);

            return graph;
        }

    }

    @Override
    public TransactionFromOrg plotTransactionFromOrgGraph(int sectorCode) {
        String url = "https://iatidatastore.iatistandard.org/api/transactions/aggregations/?group_by=provider_org&aggregations=activity_count,value&format=json&sector_category=" + sectorCode;
        String json = HttpRequest.requestJson(url);
//        System.out.println(json);

        Type queryType = new TypeToken<BudgetQuery<String>>(){}.getType();

        Gson gson = new Gson();
        BudgetQuery budgetQueryObject = gson.fromJson(json, queryType);

        // get list
        List<BudgetQueryItem<String>> results = budgetQueryObject.getResults();
        // get value
        Integer count = budgetQueryObject.getCount();

        // compare the list by value in usd (max to min)
        Collections.sort(results, new ValueComparator());

        // sum up the total
        double total = 0;
        for(BudgetQueryItem item : results){
            total += item.getValue();
        }

        double rest = total;

        /* determined by the count */
        if(count == 0){
            return null; // no graphs will return
        }else if(count > 0 && count <= 5){
            List<CountryItem> tops = new ArrayList<>();

            for(int i = 0; i < count; i++){
                String name = results.get(i).getGroup(); // receiver Org Name
                Double value = results.get(i).getValue();

                Double percentage = value * 100 / total;

                // make the object
                CountryItem item = new CountryItem(name, Math.round(value), percentage);
                tops.add(item);
            }

            TransactionFromOrg graph = new TransactionFromOrg(count, tops, new CountryItem());
            return graph;
        }else{
            // get the top 4 and rest
            List<CountryItem> tops = new ArrayList<>();

            for(int i = 0; i < 4; i++){
                String name = results.get(i).getGroup(); // receiver Org Name
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
            TransactionFromOrg graph = new TransactionFromOrg(count, tops, restItem);

            return graph;
        }
    }

    private class ValueComparator implements Comparator<BudgetQueryItem> {
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
    }

}
