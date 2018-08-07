package WellnessApp.client;

import WellnessApp.domain.User;
import WellnessApp.services.UserService;
import org.hibernate.validator.internal.util.Contracts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Set;

/**
 * Created by Hasan on 10/15/2017.
 */
@RestController
@RequestMapping("/users")
public class UserController {

//    @RequestMapping(value = "/{age}", method = RequestMethod.GET)
//    public User getUserByAge(@PathVariable("age") int age)
//    {
//        User user = new User("001", "Hasan", "Hoossen", age);
//        return user;
//    }
    // Inject Service
    @Autowired
    private UserService userService;
//
//    //-------------------Create a User--------------------------------------------------------
//
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createUser(@RequestBody User user, UriComponentsBuilder ucBuilder) {
        userService.create(user);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/users/user/{id}").buildAndExpand(user.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
//
//    //-------------------Retrieve Single User--------------------------------------------------------
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> getUser(@PathVariable("id") String id) {
        User user = userService.readById(id);
        if (user == null) {
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }
//
//
//    //-------------------Retrieve All User--------------------------------------------------------
//
    @RequestMapping(value = "/user/AllUser", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Set<User>> getUser() {
        Set<User> users = userService.readAll();
        if(users.isEmpty()){
            return new ResponseEntity<Set<User>>(HttpStatus.NO_CONTENT);// OR HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<Set<User>>(users, HttpStatus.OK);
    }
//
//    //------------------- Update a User --------------------------------------------------------
//
    @RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
    public ResponseEntity<User> updateUser(@PathVariable("id") String id, @RequestBody User user) {

        User currentUser = userService.readById(id);

        if (currentUser==null) {
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
        User updatedUser = new User.Builder().copy(currentUser)
                .firstname(user.getFirstname())
                .lastname(user.getLastname())
                .age(user.getAge())
                .build();
        userService.update(updatedUser);
        return new ResponseEntity<User>(updatedUser, HttpStatus.OK);
    }
//
//    //------------------- Delete a User --------------------------------------------------------
//
    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<User> deleteUser(@PathVariable("id") String id) {
        User user = userService.readById(id);
        if (user == null) {
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
        userService.delete(user);
        return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
    }
}
