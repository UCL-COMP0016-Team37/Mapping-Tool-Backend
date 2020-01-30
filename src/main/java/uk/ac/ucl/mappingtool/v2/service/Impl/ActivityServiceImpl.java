package uk.ac.ucl.mappingtool.v2.service.Impl;

import com.google.gson.Gson;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import uk.ac.ucl.mappingtool.v2.domain.Activity;
import uk.ac.ucl.mappingtool.v2.service.ActivityService;

@Service
public class ActivityServiceImpl implements ActivityService {
    @Override
    public Activity getActivityById(String iatiId) {
        String activityJson = requestActivity(iatiId);
        Gson gson = new Gson();

        Activity activityObject = gson.fromJson(activityJson, Activity.class);

        return activityObject;
    }


    /**
     * Help Function
     * set request to get information from iati cloud api
     * @return json result of single activity information
     */
    private String requestActivity(String iatiId){
        // add a header to pretend as a browser
        HttpHeaders headers = new HttpHeaders();
        headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);


        // use exchange for request
        RestTemplate restTemplate = new RestTemplate();

        final String url = "https://iatidatastore.iatistandard.org/api/activities/" + iatiId + "/?format=json";

        ResponseEntity<String> result = restTemplate.exchange(url, HttpMethod.GET,entity,String.class);

        return result.getBody();
    }
}
