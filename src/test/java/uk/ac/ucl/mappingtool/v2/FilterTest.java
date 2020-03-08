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
        String filterUrl = "https://iatidatastore.iatistandard.org/search/activity?q=recipient_country_code:AF";
        String json = HttpRequest.requestJson(filterUrl);

        System.out.println(json);
//        Type responseType = new TypeToken<ResponseView>(){}.getType();
//
//        Gson gson = new Gson();
//        ResponseView responseView = gson.fromJson(json, responseType);
//
//        System.out.println(responseView);
    }
}
