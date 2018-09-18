package WellnessApp.client;

import WellnessApp.domain.UserExperience;
import WellnessApp.services.UserExperienceService;
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
@RequestMapping("/userExperiences")
public class UserExperienceController {


    // Inject Service
    @Autowired
    private UserExperienceService userExperienceService;

    //-------------------Create a UserExperience--------------------------------------------------------

    @CrossOrigin(origins = "http://localhost:53830")
    @RequestMapping(value = "/AddUserExperience",method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserExperience> createUserExperience(@RequestBody UserExperience userExperience, UriComponentsBuilder ucBuilder) {
        userExperienceService.create(userExperience);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/userExperiences/userExperience/{id}").buildAndExpand(userExperience.getId()).toUri());
        return new ResponseEntity<UserExperience>(headers, HttpStatus.CREATED);
    }

    //-------------------Retrieve Single UserExperience--------------------------------------------------------

    @CrossOrigin(origins = "http://localhost:53830")
    @RequestMapping(value = "/userExperience/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserExperience> getUserExperience(@PathVariable("id") String id) {
        UserExperience userExperience = userExperienceService.readById(id);
        if (userExperience == null) {
            return new ResponseEntity<UserExperience>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<UserExperience>(userExperience, HttpStatus.OK);
    }


    //-------------------Retrieve All UserExperience--------------------------------------------------------

    @CrossOrigin(origins = "http://localhost:53830")
    @RequestMapping(value = "/userExperience/AllUserExperience", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Iterable<UserExperience>> getUserExperience() {
        Iterable<UserExperience> userExperiences = userExperienceService.readAllList();
        if(!userExperiences.iterator().hasNext()){
            return new ResponseEntity<Iterable<UserExperience>>(HttpStatus.NO_CONTENT);// OR HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<Iterable<UserExperience>>(userExperiences, HttpStatus.OK);
    }

    //------------------- Update a UserExperience --------------------------------------------------------

    @CrossOrigin(origins = "http://localhost:53830")
    @RequestMapping(value = "/userExperience/{id}", method = RequestMethod.PUT)
    public ResponseEntity<UserExperience> updateUserExperience(@PathVariable("id") String id, @RequestBody UserExperience userExperience) {

        UserExperience currentUserExperience = userExperienceService.readById(id);

        if (currentUserExperience==null) {
            return new ResponseEntity<UserExperience>(HttpStatus.NOT_FOUND);
        }
        UserExperience updatedUserExperience = new UserExperience.Builder().copy(currentUserExperience)
                .comments(userExperience.getComments())
                .build();
        userExperienceService.update(updatedUserExperience);
        return new ResponseEntity<UserExperience>(updatedUserExperience, HttpStatus.OK);
    }

    //------------------- Delete a UserExperience --------------------------------------------------------

    @CrossOrigin(origins = "http://localhost:53830")
    @RequestMapping(value = "/userExperience/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<UserExperience> deleteUserExperience(@PathVariable("id") String id) {
        UserExperience userExperience = userExperienceService.readById(id);
        if (userExperience == null) {
            return new ResponseEntity<UserExperience>(HttpStatus.NOT_FOUND);
        }
        userExperienceService.delete(userExperience);
        return new ResponseEntity<UserExperience>(HttpStatus.NO_CONTENT);
    }
}
