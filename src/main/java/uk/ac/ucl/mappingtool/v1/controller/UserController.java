package uk.ac.ucl.mappingtool.v1.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uk.ac.ucl.mappingtool.v1.constant.PropertyConst;
import uk.ac.ucl.mappingtool.v1.domain.User;
import uk.ac.ucl.mappingtool.v1.service.UserService;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
@Api(value = "User Controller", tags = {"User Controller"})
@RequestMapping(value = PropertyConst.root + "/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    @ApiOperation(value = "Get the list of all available user")
    public List<User> getAllUser(){
        return userService.getAll();
    }

    @GetMapping("/{pageNum}/{pageSize}")
    public List<User> getPartUser(@PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize){
        Iterator<User> userIterator = userService.selectAll(pageNum, pageSize);
        List<User> list = new ArrayList<>();
        while(userIterator.hasNext()){
            list.add(userIterator.next());
        }
        return list;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Obtain the information of one user", notes = "Get the user detail information by the {id} param in the url")
    public User getSingleUser(@PathVariable("id")int id){
        return userService.selectById(id);
    }

    @PostMapping("/")
    @ApiOperation(value = "Create a new User", notes = "Create a User object according to the constructor")
    public void postUser(User user){
        userService.insert(user);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Update the information of one user",
            notes =  "Update the specific user object by the {id} param in the url, and change the info according to the PUT param")
    public void putUser(@RequestParam User user){
        userService.update(user);
    }


    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete a User object", notes = "Delete the specific user object by the {id} param in the url")
    public void deleteUser(@PathVariable("id")int id){
        userService.delete(id);
    }


    @GetMapping("/query/name={name}")
    public User getSingleUserByName(@PathVariable("name") String name){
        return userService.getByName(name);
    }



}
