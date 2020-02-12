package uk.ac.ucl.mappingtool.v2;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.junit.Test;
import uk.ac.ucl.mappingtool.util.HttpRequest;
import uk.ac.ucl.mappingtool.v2.domain.country.countryRes.ActivityDisplayItem;
import uk.ac.ucl.mappingtool.v2.domain.result.ListView;

import java.lang.reflect.Type;

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
}
