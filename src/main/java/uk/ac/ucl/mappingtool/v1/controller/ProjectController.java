package uk.ac.ucl.mappingtool.v1.controller;


import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uk.ac.ucl.mappingtool.v1.constant.PropertyConst;
import uk.ac.ucl.mappingtool.v1.domain.Project;
import uk.ac.ucl.mappingtool.v1.service.ProjectService;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping(value = PropertyConst.root + "/projects")
public class ProjectController {

    @Autowired
    private ProjectService projectService;


    @GetMapping("/")
    @ApiOperation(value = "Get the list of all available projects", notes =  "Very long list, try to not use it !!!")
    public List<Project> getAllProject(){
        return projectService.getAllProject();
    }

    @GetMapping("/{pageNum}/{pageSize}")
    @ApiOperation(value = "Get the list of part available projects", notes = "you need to declare how many pages do you want and the size of these pages")
    public List<Project> getPartProject(@PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize){
        Iterator<Project> projectIterator = projectService.getPartProject(pageNum, pageSize);
        List<Project> list = new ArrayList<>();
        while (projectIterator.hasNext()){
            list.add(projectIterator.next());
        }

        return list;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Obtain the information of one project", notes = "Get the project detail information by the {id} param in the url")
    public Project getSingleProject(@PathVariable String id){
        return projectService.selectById(id);
    }


}
