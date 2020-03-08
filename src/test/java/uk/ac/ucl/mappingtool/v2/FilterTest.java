package uk.ac.ucl.mappingtool.v2;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.junit.Test;
import uk.ac.ucl.mappingtool.util.HttpRequest;
import uk.ac.ucl.mappingtool.v2.domain.result.response.Response;
import uk.ac.ucl.mappingtool.v2.domain.result.response.ResponseView;

import java.lang.reflect.Type;

public class FilterTest {
    @Test
    public void testFilterOne(){
        String filterUrl = "https://iati.cloud/search/activity?q=sector_code:(111)&fl=iati_identifier,title_*&wt=json&rows=5";
        String json = HttpRequest.requestJson(filterUrl);

//        System.out.println(json);
        Type responseType = new TypeToken<ResponseView>(){}.getType();

        Gson gson = new Gson();
        ResponseView responseView = gson.fromJson(json, responseType);

        System.out.println(responseView);
    }

    @Test
    public void testFilterMultiple(){
        String filterUrl = "https://iati.cloud/search/activity?q=reporting_org_type_code:(10) OR sector_code:(11130) AND recipient_country_code:(AF)&fl=iati_identifier,title_*&wt=json&rows=10";
        String json = HttpRequest.requestJson(filterUrl);

        Type responseType = new TypeToken<ResponseView>(){}.getType();

        Gson gson = new Gson();
        ResponseView responseView = gson.fromJson(json, responseType);

        System.out.println(responseView);
    }

    @Test
    public void testFilterInput(){
        String query = "sector_code:(111)";
        int page = 10;


        StringBuilder sb = new StringBuilder();
        sb.append("https://iati.cloud/search/activity?");
        sb.append("q=");
        sb.append(query); // query
        sb.append("&wt=json&rows=");
        sb.append(10);
        sb.append("&start="); // page
        sb.append(page * 10);

        String url = sb.toString();
        String json = HttpRequest.requestJson(url);

        Type responseType = new TypeToken<ResponseView>(){}.getType();

        Gson gson = new Gson();
        ResponseView responseView = gson.fromJson(json, responseType);

        System.out.println(responseView.getResponse());

    }
}
