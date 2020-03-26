package uk.ac.ucl.mappingtool.functionTests;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import uk.ac.ucl.mappingtool.util.Reader;
import uk.ac.ucl.mappingtool.v2.domain.publisher.Publisher;
import uk.ac.ucl.mappingtool.v2.domain.activity.Activity;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class GsonTest {
    private String res;
    private List<String> ignorance;

    @Before
    public void setup(){
        // add a header to pretend as a browser
        HttpHeaders headers = new HttpHeaders();
        headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);


        // use exchange for request
        RestTemplate restTemplate = new RestTemplate();

        final String url = "https://iatidatastore.iatistandard.org/api/activities/GB-CHC-285776-DRC429/?format=json";

        ResponseEntity<String> result = restTemplate.exchange(url, HttpMethod.GET,entity,String.class);

        res = result.getBody();
    }


    @Test
    public void testGsonSerialize(){
        String activityJson = res;
        Gson gson = new Gson();

        Activity activityObject = gson.fromJson(activityJson, Activity.class);

        System.out.println(activityObject.toString());
    }

    @Test
    public void testGsonSerialize1(){
        String activityJson = res;
        Gson gson = new Gson();
        Activity activityObject = gson.fromJson(activityJson, Activity.class);

        /* serialize it*/
        GsonBuilder gsonBuilder = new GsonBuilder();
        // serialize null value
        gsonBuilder.serializeNulls();

        gson = gsonBuilder.create();
        String result = gson.toJson(activityObject);

        System.out.println(result);
    }

    @Test
    public void testGsonSerializeIgnore(){
        String activityJson = res;
        Gson gson = new Gson();
        Activity activityObject = gson.fromJson(activityJson, Activity.class);


        /* set ignorance */
        ignorance = new ArrayList<>();
        ignorance.add("recipient_regions");
        ignorance.add("sectors");

        /* serialize it*/
        GsonBuilder gsonBuilder = new GsonBuilder();
        // serialize null value
        gsonBuilder.serializeNulls();

        gsonBuilder.addSerializationExclusionStrategy(new ExclusionStrategy() {
            @Override
            public boolean shouldSkipField(FieldAttributes f) {
                return ignorance.contains(f.getName());
            }

            @Override
            public boolean shouldSkipClass(Class<?> aClass) {
                return false;
            }
        });

        gson = gsonBuilder.create();
        String result = gson.toJson(activityObject);

        System.out.println(result);

    }

    @Test
    public void testGsonSerializePublisherList() throws IOException {
        String json = Reader.readFileContent("/src/main/resources/static/orgList.json");

        Gson gson = new Gson();

        Type founderListType = new TypeToken<ArrayList<Publisher>>(){}.getType();

        List<Publisher> publisherList = gson.fromJson(json, founderListType);

        System.out.println(publisherList);

    }


















}
