package uk.ac.ucl.mappingtool.v2.service;

import uk.ac.ucl.mappingtool.v2.domain.publisher.Publisher;

import java.io.IOException;
import java.util.List;

public interface PublisherService {
    public void insert(Publisher publisher);
    public void delete(String id);
    public List<Publisher> getAll();
    public Publisher getOne(String id);
    public void insertAll() throws IOException;
}
