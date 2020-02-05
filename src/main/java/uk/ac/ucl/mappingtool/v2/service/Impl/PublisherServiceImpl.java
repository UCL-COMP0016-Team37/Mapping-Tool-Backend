package uk.ac.ucl.mappingtool.v2.service.Impl;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.ac.ucl.mappingtool.util.Reader;
import uk.ac.ucl.mappingtool.v2.domain.Publisher;
import uk.ac.ucl.mappingtool.v2.repository.PublisherRepository;
import uk.ac.ucl.mappingtool.v2.service.PublisherService;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        String json = Reader.readFileContent("/src/main/resources/static/orgList.json");
        Gson gson = new Gson();
        Type founderListType = new TypeToken<ArrayList<Publisher>>(){}.getType();

        List<Publisher> publisherList = gson.fromJson(json, founderListType);  // the Objects in orgList

        for(Publisher publisher : publisherList){
            publisherRepository.save(publisher);
        }
    }
}
