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

    // Inject Service
    @Autowired
    private UserService userService;
//    //-------------------Create a User--------------------------------------------------------

    @CrossOrigin(origins = "http://localhost:53830")
    @RequestMapping(value = "/AddUser",method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> createUser(@RequestBody User user, UriComponentsBuilder ucBuilder) {
        userService.create(user);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/users/user/{id}").buildAndExpand(user.getId()).toUri());
        return new ResponseEntity<User>(headers, HttpStatus.CREATED);
    }

//    //-------------------Retrieve Single User--------------------------------------------------------

    @CrossOrigin(origins = "http://localhost:53830")
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

    @CrossOrigin(origins = "http://localhost:53830")
    @RequestMapping(value = "/user/AllUser", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Iterable<User>> getUser() {
        Iterable<User> users = userService.readAllList();
        if(!users.iterator().hasNext()){
            return new ResponseEntity<Iterable<User>>(HttpStatus.NO_CONTENT);// OR HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<Iterable<User>>(users, HttpStatus.OK);
    }
//
//    //------------------- Update a User --------------------------------------------------------
//
    @CrossOrigin(origins = "http://localhost:53830")
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
    @CrossOrigin(origins = "http://localhost:53830")
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
