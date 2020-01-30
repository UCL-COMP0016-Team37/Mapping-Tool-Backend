package uk.ac.ucl.mappingtool.functionTests;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

public class RestTemplateTest {
    @Test
    public void testRestTemplate() throws URISyntaxException {
        RestTemplate restTemplate = new RestTemplate();

        final String url = "https://mapping-tool-api.azurewebsites.net/api/v1/users/";
        URI uri = new URI(url);

        ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
        Assert.assertEquals(200, result.getStatusCodeValue());

        System.out.println(result.getBody());

    }
}
