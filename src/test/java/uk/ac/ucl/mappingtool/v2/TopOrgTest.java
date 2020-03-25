package uk.ac.ucl.mappingtool.v2;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.junit.Test;
import uk.ac.ucl.mappingtool.util.HttpRequest;
import uk.ac.ucl.mappingtool.v2.domain.analysis.request.activity.ActivityQuery;
import uk.ac.ucl.mappingtool.v2.domain.analysis.request.activity.ActivityQueryItem;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TopOrgTest {

//    @Test
    public void testOrgAggregation(){
        String url = "https://iatidatastore.iatistandard.org/api/activities/aggregations/?format=json&group_by=reporting_organisation&aggregations=count";
        String json = HttpRequest.requestJson(url);
//        System.out.println(json);

        Type queryType = new TypeToken<ActivityQuery<String>>(){}.getType();

        Gson gson = new Gson();
        ActivityQuery budgetQueryObject = gson.fromJson(json, queryType);

        // get list
        List<ActivityQueryItem<String>> results = budgetQueryObject.getResults();

        // compare the list by value in usd (max to min)
        Collections.sort(results, new Comparator<ActivityQueryItem>() {
            @Override
            public int compare(ActivityQueryItem o1, ActivityQueryItem o2) {
                if (o1.getCount() > o2.getCount()){
                    return -1;
                } else if(o1.getCount() < o2.getCount()){
                    return 1;
                } else{
                    return 0;
                }
            }
        });

        System.out.println(results);
    }
}
