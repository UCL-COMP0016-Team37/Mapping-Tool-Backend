package uk.ac.ucl.mappingtool.controller;


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
    public String deleteUser(@PathVariable Long id) {
        users.remove(id);
        return "success";
    }



}
