package uk.ac.ucl.mappingtool.controller;


import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import uk.ac.ucl.mappingtool.domain.User;

import java.util.*;

@RestController
@RequestMapping(value = "/test/users")   // set all mapping under users
public class UserController {

    static Map<Long, User> users = Collections.synchronizedMap(new HashMap<Long, User>());


    /**
     * @method: GET
     * @url /test/users/
     * @return allUsers: get the list of all users
     */
    @GetMapping("/")
    @ApiOperation(value = "Get the list of all available user")
    public List<User> getUserList() {
        List<User> allUsers = new ArrayList<User>(users.values());

        return allUsers;
    }

    /**
     *
     * @method: POST
     * @url /test/users/
     * @param user
     * @return "success": result of status string
     */
    @PostMapping("/")
    @ApiOperation(value = "Create a new User", notes = "Create a User object according to the constructor")
    public String postUser(@RequestBody User user){
        users.put(user.getId(), user);
        return "success";
    }


    /**
     * get the information of one user
     * @method: GET
     * @url /test/users/{id}
     * @param id
     * @return one user's information
     */
    @GetMapping("/{id}")
    @ApiOperation(value = "Obtain the information of one user", notes = "Get the user detail information by the {id} param in the url")
    public User getUser(@PathVariable Long id) {
        return users.get(id);
    }

    /**
     * change the status of one user
     * @method: PUT
     * @url /test/users/{id}
     * @param id
     * @param user
     * @return "success": result of status string
     */
    @PutMapping("/{id}")
    @ApiOperation(value = "Update the information of one user",
            notes =  "Update the specific user object by the {id} param in the url, and change the info according to the PUT param")
    public String putUser(@PathVariable Long id, @RequestBody User user) {
        User u = users.get(id);
        u.setName(user.getName());
        u.setAge(user.getAge());
        users.put(id, u);
        return "success";
    }

    /**
     * delete one user object
     * @method: DELETE
     * @url /test/users/{id}
     * @param id
     * @return "success": result of status string
     */
    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete a User object", notes = "Delete the specific user object by the {id} param in the url")
    public String deleteUser(@PathVariable Long id) {
        users.remove(id);
        return "success";
    }



}
