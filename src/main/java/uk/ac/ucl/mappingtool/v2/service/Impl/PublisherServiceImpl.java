package uk.ac.ucl.mappingtool.v2.service.Impl;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.ac.ucl.mappingtool.util.Download;
import uk.ac.ucl.mappingtool.util.Reader;
import uk.ac.ucl.mappingtool.v2.domain.publisher.Publisher;
import uk.ac.ucl.mappingtool.v2.domain.publisher.PublisherReq;
import uk.ac.ucl.mappingtool.v2.repository.PublisherRepository;
import uk.ac.ucl.mappingtool.v2.service.PublisherService;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.*;

@Service
public class PublisherServiceImpl implements PublisherService {

    @Autowired
    PublisherRepository publisherRepository;

    @Override
    public void insert(Publisher publisher) {
        publisherRepository.save(publisher);
    }

    @Override
    public void delete(String id) {
        publisherRepository.deleteById(id);
    }

    @Override
    public List<Publisher> getAll() {
        return publisherRepository.findAll();
    }

    @Override
    public Publisher getOne(String id) {
        Optional<Publisher> optional = publisherRepository.findById(id);
        Publisher publisher = optional.get();
        return publisher;
    }

    @Override
    public void insertAll() throws IOException{
        // download from iati-registry
        String url = "https://www.iatiregistry.org/publisher/download_list/json";
        String dir = "/src/main/resources/static/";
        String fileName = "orgList.json";
        Download.downloadHttpUrl(url, dir, fileName);

        // read file from local
        String json = Reader.readFileContent("/src/main/resources/static/orgList.json");

        // serialize
        Gson gson = new Gson();
        Type founderListType = new TypeToken<ArrayList<PublisherReq>>(){}.getType();
        List<PublisherReq> publisherList = gson.fromJson(json, founderListType);

        // get ISO HashMap
        Map<String, String> countries = new HashMap<>();  // iso code to name map
        for (String iso : Locale.getISOCountries()) {
            Locale l = new Locale("", iso);
            countries.put(l.getDisplayCountry(), iso);
        }

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

        for(Publisher publisher : jpaPublishers){
            publisherRepository.save(publisher);
        }
    }
}
