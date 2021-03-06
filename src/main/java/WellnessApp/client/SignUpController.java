package WellnessApp.client;

import WellnessApp.domain.SignUp;
import WellnessApp.services.SignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Set;

/**
 * Created by Hasan on 9/25/2017.
 */
@RestController
@RequestMapping("/signUps")
public class SignUpController {

    // Inject Service
    @Autowired
    private SignUpService signUpService;

    //-------------------Create a SignUp--------------------------------------------------------

    @CrossOrigin(origins = "http://localhost:53830")
    @RequestMapping(value = "/AddSignUp", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SignUp> createSignUp(@RequestBody SignUp signUp, UriComponentsBuilder ucBuilder) {
        signUpService.create(signUp);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/signUps/signUp/{id}").buildAndExpand(signUp.getId()).toUri());
        return new ResponseEntity<SignUp>(headers, HttpStatus.CREATED);
    }

    //-------------------Retrieve Single SignUp--------------------------------------------------------

    @CrossOrigin(origins = "http://localhost:53830")
    @RequestMapping(value = "/signUp/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SignUp> getSignUp(@PathVariable("id") String id) {
        SignUp signUp = signUpService.readById(id);
        if (signUp == null) {
            return new ResponseEntity<SignUp>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<SignUp>(signUp, HttpStatus.OK);
    }


    //-------------------Retrieve All SignUp--------------------------------------------------------

    @CrossOrigin(origins = "http://localhost:53830")
    @RequestMapping(value = "/signUp/AllSignUp", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Iterable<SignUp>> getSignUp() {
        Iterable<SignUp> signUps = signUpService.readAllList();
        if(!signUps.iterator().hasNext()){
            return new ResponseEntity<Iterable<SignUp>>(HttpStatus.NO_CONTENT);// OR HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<Iterable<SignUp>>(signUps, HttpStatus.OK);
    }

    //------------------- Update a SignUp --------------------------------------------------------

    @CrossOrigin(origins = "http://localhost:53830")
    @RequestMapping(value = "/signUp/{id}", method = RequestMethod.PUT)
    public ResponseEntity<SignUp> updateSignUp(@PathVariable("id") String id, @RequestBody SignUp signUp) {

        SignUp currentSignUp = signUpService.readById(id);

        if (currentSignUp==null) {
            return new ResponseEntity<SignUp>(HttpStatus.NOT_FOUND);
        }
        SignUp updatedSignUp = new SignUp.Builder().copy(currentSignUp)
                .username(signUp.getUsername())
                .password(signUp.getPassword())
                .email(signUp.getEmail())
                .gender(signUp.getGender())
                .dob(signUp.getDob())
                .signUp_Date(signUp.getSignUp_Date())
                .build();
        signUpService.update(updatedSignUp);
        return new ResponseEntity<SignUp>(updatedSignUp, HttpStatus.OK);
    }

    //------------------- Delete a SignUp --------------------------------------------------------

    @CrossOrigin(origins = "http://localhost:53830")
    @RequestMapping(value = "/signUp/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<SignUp> deleteSignUp(@PathVariable("id") String id) {
        SignUp signUp = signUpService.readById(id);
        if (signUp == null) {
            return new ResponseEntity<SignUp>(HttpStatus.NOT_FOUND);
        }
        signUpService.delete(signUp);
        return new ResponseEntity<SignUp>(HttpStatus.NO_CONTENT);
    }
}
