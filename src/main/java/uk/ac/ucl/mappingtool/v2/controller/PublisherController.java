package uk.ac.ucl.mappingtool.v2.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uk.ac.ucl.mappingtool.v2.constant.PropertyConst;
import uk.ac.ucl.mappingtool.v2.domain.Publisher;
import uk.ac.ucl.mappingtool.v2.service.PublisherService;

import java.util.List;

@RestController
@RequestMapping(value = PropertyConst.root + "/publisher")
public class PublisherController {
    @Autowired
    private PublisherService publisherService;

    @GetMapping("/")
    public List<Publisher> getAllPublisher(){
        return publisherService.getAll();
    }

    @GetMapping("/{id}")
    public Publisher getSinglePublisher(@PathVariable("id") String id){
        return publisherService.getOne(id);
    }

    @PostMapping("/")
    public void createPublisher(Publisher publisher){
        publisherService.insert(publisher);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id")String id){
        publisherService.delete(id);
    }
}
