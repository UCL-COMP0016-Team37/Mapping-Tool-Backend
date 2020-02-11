package uk.ac.ucl.mappingtool.v2.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uk.ac.ucl.mappingtool.v2.constant.PropertyConst;
import uk.ac.ucl.mappingtool.v2.domain.publisher.Publisher;
import uk.ac.ucl.mappingtool.v2.service.PublisherService;

import java.io.IOException;
import java.util.List;

@RestController
@Api(value = "Publisher/Organisation Controller" , tags = {"Publisher/Organisation Controller"})
@RequestMapping(value = PropertyConst.root + "/publishers")
public class PublisherController {
    @Autowired
    private PublisherService publisherService;

    @GetMapping("/")
    @ApiOperation(value = "Get the list of all available publishers/orgnisations")
    public List<Publisher> getAllPublisher(){
        return publisherService.getAll();
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Obtain the information of one publisher")
    public Publisher getSinglePublisher(@PathVariable("id") String id){
        return publisherService.getOne(id);
    }

    @PostMapping("/")
    @ApiOperation(
            value = "Create a new publisher",
            notes = "Test Only, it is banned by using from frontend"
    )
    public void createPublisher(Publisher publisher){
        publisherService.insert(publisher);
    }

    @PostMapping("/remote")
    @ApiOperation(
            value = "Download the newest data from IATI Registry and upload to the real database",
            notes = "DANGEROUS, It will actually modify the database; only do it when permitted"
    )
    public void updateAll() throws IOException {
        publisherService.insertAll();
    }

    @DeleteMapping("/{id}")
    @ApiOperation(
            value = "Delete one publisher object",
            notes = "DANGEROUS, It will actually modify the database; only do it when permitted"
    )
    public void deleteUser(@PathVariable("id")String id){
        publisherService.delete(id);
    }
}
