package uk.ac.ucl.mappingtool.functionTests;

import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import uk.ac.ucl.mappingtool.v2.domain.Activity;

public class GsonTest {
    private String res;

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
}
