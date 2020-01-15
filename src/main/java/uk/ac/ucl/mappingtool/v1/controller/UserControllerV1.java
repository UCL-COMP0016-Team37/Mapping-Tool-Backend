package uk.ac.ucl.mappingtool.v1.controller;


import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uk.ac.ucl.mappingtool.v1.constant.PropertyConst;
import uk.ac.ucl.mappingtool.v1.domain.UserV1;
import uk.ac.ucl.mappingtool.v1.service.UserServiceV1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping(value = PropertyConst.root + "/users")
public class UserControllerV1 {

    @Autowired
    private UserServiceV1 userServiceV1;

    @GetMapping("/")
    @ApiOperation(value = "Get the list of all available user")
    public List<UserV1> getAllUser(){
        return userServiceV1.getAll();
    }

    @GetMapping("/{pageNum}/{pageSize}")
    public List<UserV1> getPartUser(@PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize){
        Iterator<UserV1> userIterator = userServiceV1.selectAll(pageNum, pageSize);
        List<UserV1> list = new ArrayList<>();
        while(userIterator.hasNext()){
            list.add(userIterator.next());
        }
        return list;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Obtain the information of one user", notes = "Get the user detail information by the {id} param in the url")
    public UserV1 getSingleUser(@PathVariable("id")int id){
        return userServiceV1.selectById(id);
    }

    @PostMapping("/")
    @ApiOperation(value = "Create a new UserV1", notes = "Create a UserV1 object according to the constructor")
    public void postUser(UserV1 userV1){
        userServiceV1.insert(userV1);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Update the information of one user",
            notes =  "Update the specific user object by the {id} param in the url, and change the info according to the PUT param")
    public void putUser(@RequestParam UserV1 userV1){
        userServiceV1.update(userV1);
    }


    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete a UserV1 object", notes = "Delete the specific user object by the {id} param in the url")
    public void deleteUser(@PathVariable("id")int id){
        userServiceV1.delete(id);
    }







}
