package uk.ac.ucl.mappingtool.v2.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uk.ac.ucl.mappingtool.v2.constant.PropertyConst;
import uk.ac.ucl.mappingtool.v2.domain.activity.Activity;
import uk.ac.ucl.mappingtool.v2.service.ActivityService;

@RestController
@Api(value = "IATI Activity Controller", tags = {"IATI Activity Controller"})
@RequestMapping(value = PropertyConst.root + "/activities")
public class ActivityController {

    @Autowired
    private ActivityService activityService;

    @GetMapping("/{id}")
    @ApiOperation(value = "Obtain the information of one activity", notes = "Get the activity detail information by the {id} param in the url")
    public Activity getSingleActivity(@PathVariable String id){
        return activityService.getActivityById(id);
    }

    @GetMapping("/{id}/{field}")
    @ApiOperation(value = "Obtain one specific field detail of the activity", notes = "Get the activity detail information of one {field} by the {id} param in the url")
    public String getSingleFieldActivity(@PathVariable String id, @PathVariable String field){
        return activityService.getActivityByIdAndField(id, field);
    }
}
