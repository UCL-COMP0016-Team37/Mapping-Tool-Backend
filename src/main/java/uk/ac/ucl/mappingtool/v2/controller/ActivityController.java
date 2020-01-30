package uk.ac.ucl.mappingtool.v2.controller;


import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uk.ac.ucl.mappingtool.v2.constant.PropertyConst;
import uk.ac.ucl.mappingtool.v2.domain.Activity;
import uk.ac.ucl.mappingtool.v2.service.ActivityService;

@RestController
@RequestMapping(value = PropertyConst.root + "/activities")
public class ActivityController {

    @Autowired
    private ActivityService activityService;

    @GetMapping("/{id}")
    @ApiOperation(value = "Obtain the information of one activity", notes = "Get the activity detail information by the {id} param in the url")
    public Activity getSingleActivity(@PathVariable String id){
        return activityService.getActivityById(id);
    }
}
