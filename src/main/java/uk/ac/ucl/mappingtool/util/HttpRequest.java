package uk.ac.ucl.mappingtool.util;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.LaxRedirectStrategy;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import uk.ac.ucl.mappingtool.v2.constant.PropertyConst;

public class HttpRequest {

    public static String requestJson(String url) throws HttpClientErrorException {
        /* add a header to pretend as a browser */
        HttpHeaders headers = new HttpHeaders();
        headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

        /* use exchange for request */
        RestTemplate restTemplate = new RestTemplate();

        // deal with redirection -- Response 301
//        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
//        HttpClient httpClient = HttpClientBuilder.create().setRedirectStrategy(new LaxRedirectStrategy()).build();
//        factory.setHttpClient(httpClient);
//        restTemplate.setRequestFactory(factory);

        ResponseEntity<String> result = restTemplate.exchange(url, HttpMethod.GET,entity,String.class);

        return result.getBody();
    }

    public static String redirectRequestJson(String url) throws HttpClientErrorException{
        /* add a header to pretend as a browser */
        HttpHeaders headers = new HttpHeaders();
        headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

        /* use exchange for request */
        RestTemplate restTemplate = new RestTemplate();

        // deal with redirection -- Response 301
        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
        HttpClient httpClient = HttpClientBuilder.create().setRedirectStrategy(new LaxRedirectStrategy()).build();
        factory.setHttpClient(httpClient);
        restTemplate.setRequestFactory(factory);

        ResponseEntity<String> result = restTemplate.exchange(url, HttpMethod.GET,entity,String.class);

        return result.getBody();
    }


    public static String changeToHttps(String httpUrl){
        String result = httpUrl.replaceAll("http", "https");

        return result;
    }
}
