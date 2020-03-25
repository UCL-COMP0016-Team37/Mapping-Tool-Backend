package uk.ac.ucl.mappingtool.v2;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.junit.Test;
import uk.ac.ucl.mappingtool.util.Reader;
import uk.ac.ucl.mappingtool.v2.domain.publisher.Publisher;
import uk.ac.ucl.mappingtool.v2.domain.publisher.PublisherReq;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class PublisherTest {

    @Test
    public void testFindCountryCode() throws Exception{
        String json = Reader.readFileContent("/src/main/resources/static/orgList.json");
//        System.out.println(json);

        Gson gson = new Gson();
        Type founderListType = new TypeToken<ArrayList<PublisherReq>>(){}.getType();
        List<PublisherReq> publisherList = gson.fromJson(json, founderListType);

//        System.out.println(publisherList);

        PublisherReq publisher = publisherList.get(0);  // test one publisher from the list



    }
}
