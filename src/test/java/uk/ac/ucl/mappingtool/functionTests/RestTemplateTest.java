package uk.ac.ucl.mappingtool.functionTests;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

public class RestTemplateTest {
    /**
     * Request mapping tool apis
     */
    @Test
    public void testRestTemplate() throws URISyntaxException {
        RestTemplate restTemplate = new RestTemplate();

        final String url = "https://mapping-tool-api.azurewebsites.net/api/v1/users/";
        URI uri = new URI(url);

        ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
        Assert.assertEquals(200, result.getStatusCodeValue());

        System.out.println(result.getBody());

    }

    /**
     * Request iati cloud apis
     * We need to fraud the server which has SSL protection as a browser
     *
     * This api only have 4 field:
     *  - id
     *  - recipient country
     *  - recipient region
     *  - sectors
     */
    @Test
    public void testRestTemplate1() throws URISyntaxException{
        // add a header to pretend as a browser
        HttpHeaders headers = new HttpHeaders();
        headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);


        // use exchange for request
        RestTemplate restTemplate = new RestTemplate();

        final String url = "https://iatidatastore.iatistandard.org/api/activities/GB-CHC-285776-DRC429/?format=json";

        ResponseEntity<String> result = restTemplate.exchange(url, HttpMethod.GET,entity,String.class);

        Assert.assertEquals(200, result.getStatusCodeValue());

        System.out.println(result.getBody());
    }
}
