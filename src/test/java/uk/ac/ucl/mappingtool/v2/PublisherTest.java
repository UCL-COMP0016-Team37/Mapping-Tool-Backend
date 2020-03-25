package uk.ac.ucl.mappingtool.v2;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.junit.Before;
import org.junit.Test;
import uk.ac.ucl.mappingtool.util.Reader;
import uk.ac.ucl.mappingtool.v2.domain.publisher.Publisher;
import uk.ac.ucl.mappingtool.v2.domain.publisher.PublisherReq;

import java.awt.*;
import java.lang.reflect.Type;
import java.util.*;
import java.util.List;

public class PublisherTest {
    private Map<String, String> countries = new HashMap<>();

    @Before
    public void setup() throws InterruptedException{
        for (String iso : Locale.getISOCountries()) {
            Locale l = new Locale("", iso);
            countries.put(l.getDisplayCountry(), iso);
        }
    }

    @Test
    public void testFindCountryCode() throws Exception{
        String json = Reader.readFileContent("/src/main/resources/static/orgList.json");
//        System.out.println(json);

        Gson gson = new Gson();
        Type founderListType = new TypeToken<ArrayList<PublisherReq>>(){}.getType();
        List<PublisherReq> publisherList = gson.fromJson(json, founderListType);

//        System.out.println(publisherList);

        PublisherReq publisher = publisherList.get(0);  // test one publisher from the list

        String countryName = publisher.getHq();

        String countryCode = countries.get(countryName);

        System.out.println(countryCode);
    }

    @Test
    public void testGeneratePublisherList() throws Exception{
        String json = Reader.readFileContent("/src/main/resources/static/orgList.json");
//        System.out.println(json);

        Gson gson = new Gson();
        Type founderListType = new TypeToken<ArrayList<PublisherReq>>(){}.getType();
        List<PublisherReq> publisherList = gson.fromJson(json, founderListType);

        List<Publisher> jpaPublishers = new ArrayList<>();

        for(PublisherReq publisher : publisherList){
            // get country code
            String countryName = publisher.getHq();
            String countryCode = countries.get(countryName);

            if(countryCode == null){
                countryCode = "";
            }

//            System.out.println(countryCode);

            // other properties
            String id = publisher.getId();
            String name= publisher.getName();
            String type = publisher.getType();
            String datasetNum = publisher.getDatasetNum();
            String link = publisher.getLink();

            Publisher jpaPublisher = new Publisher(id, countryCode, countryName, name, type, datasetNum, link);

            jpaPublishers.add(jpaPublisher);
        }

        System.out.println(jpaPublishers);
    }



//    // hash it
//    private String countryNameToCode(String name) throws InterruptedException{
//        for (String iso : Locale.getISOCountries()) {
//            Locale l = new Locale("", iso);
//            countries.put(l.getDisplayCountry(), iso);
//        }
//
//        return countries.get(name);
//    }
}
