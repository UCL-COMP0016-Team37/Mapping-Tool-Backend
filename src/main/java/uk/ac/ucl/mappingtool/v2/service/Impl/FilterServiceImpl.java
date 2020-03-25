package uk.ac.ucl.mappingtool.v2.service.Impl;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.stereotype.Service;
import uk.ac.ucl.mappingtool.util.HttpRequest;
import uk.ac.ucl.mappingtool.v2.domain.result.response.Response;
import uk.ac.ucl.mappingtool.v2.domain.result.response.ResponseView;
import uk.ac.ucl.mappingtool.v2.service.FilterService;

import java.lang.reflect.Type;

@Service
public class FilterServiceImpl implements FilterService {

    private static final int ITEMS_PER_PAGE = 10;

    @Override
    public Response getFilterResult(String query, Integer page) {

        StringBuilder sb = new StringBuilder();
        sb.append("https://iati.cloud/search/activity?");
        sb.append("q=");
        sb.append(query); // query
        sb.append("&wt=json&rows=");
        sb.append(ITEMS_PER_PAGE);
        sb.append("&start="); // page
        sb.append(page * ITEMS_PER_PAGE);

        String url = sb.toString();
        String json = HttpRequest.requestJson(url);

        Type responseType = new TypeToken<ResponseView>(){}.getType();

        Gson gson = new Gson();
        ResponseView responseView = gson.fromJson(json, responseType);

        Response response = responseView.getResponse();

        return response;
    }


}
