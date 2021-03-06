package WellnessApp.client;

import WellnessApp.domain.WeightLossExercise;
import WellnessApp.services.WeightLossExerciseService;
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
@RequestMapping("/weightLossExercises")
public class WeightLossExerciseController {

    // Inject Service
    @Autowired
    private WeightLossExerciseService weightLossExerciseService;

    //-------------------Create a WeightLossExercise--------------------------------------------------------

    @CrossOrigin(origins = "http://localhost:53830")
    @RequestMapping(value = "/AddWeightLossExercise", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<WeightLossExercise> createWeightLossExercise(@RequestBody WeightLossExercise weightLossExercise, UriComponentsBuilder ucBuilder) {
        weightLossExerciseService.create(weightLossExercise);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/weightLossExercises/weightLossExercise/{id}").buildAndExpand(weightLossExercise.getId()).toUri());
        return new ResponseEntity<WeightLossExercise>(headers, HttpStatus.CREATED);
    }

    //-------------------Retrieve Single WeightLossExercise--------------------------------------------------------

    @CrossOrigin(origins = "http://localhost:53830")
    @RequestMapping(value = "/weightLossExercise/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<WeightLossExercise> getWeightLossExercise(@PathVariable("id") String id) {
        WeightLossExercise weightLossExercise = weightLossExerciseService.readById(id);
        if (weightLossExercise == null) {
            return new ResponseEntity<WeightLossExercise>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<WeightLossExercise>(weightLossExercise, HttpStatus.OK);
    }


    //-------------------Retrieve All WeightLossExercise--------------------------------------------------------

    @CrossOrigin(origins = "http://localhost:53830")
    @RequestMapping(value = "/weightLossExercise/AllWeightLossExercise", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Iterable<WeightLossExercise>> getWeightLossExercise() {
        Iterable<WeightLossExercise> weightLossExercises = weightLossExerciseService.readAllList();
        if(!weightLossExercises.iterator().hasNext()){
            return new ResponseEntity<Iterable<WeightLossExercise>>(HttpStatus.NO_CONTENT);// OR HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<Iterable<WeightLossExercise>>(weightLossExercises, HttpStatus.OK);
    }

    //------------------- Update a WeightLossExercise --------------------------------------------------------

    @CrossOrigin(origins = "http://localhost:53830")
    @RequestMapping(value = "/weightLossExercise/{id}", method = RequestMethod.PUT)
    public ResponseEntity<WeightLossExercise> updateWeightLossExercise(@PathVariable("id") String id, @RequestBody WeightLossExercise weightLossExercise) {

        WeightLossExercise currentWeightLossExercise = weightLossExerciseService.readById(id);

        if (currentWeightLossExercise==null) {
            return new ResponseEntity<WeightLossExercise>(HttpStatus.NOT_FOUND);
        }
        WeightLossExercise updatedWeightLossExercise = new WeightLossExercise.Builder().copy(currentWeightLossExercise)
                .weightLossExercise_Name(weightLossExercise.getWeightLossExercise_Name())
                .weightLossExercise_Amount(weightLossExercise.getWeightLossExercise_Amount())
                .weightLossExercise_Reps(weightLossExercise.getWeightLossExercise_Reps())
                .weightLossExercise_Date(weightLossExercise.getWeightLossExercise_Date())
                .build();
        weightLossExerciseService.update(updatedWeightLossExercise);
        return new ResponseEntity<WeightLossExercise>(updatedWeightLossExercise, HttpStatus.OK);
    }

    //------------------- Delete a WeightLossExercise --------------------------------------------------------

    @CrossOrigin(origins = "http://localhost:53830")
    @RequestMapping(value = "/weightLossExercise/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<WeightLossExercise> deleteWeightLossExercise(@PathVariable("id") String id) {
        WeightLossExercise weightLossExercise = weightLossExerciseService.readById(id);
        if (weightLossExercise == null) {
            return new ResponseEntity<WeightLossExercise>(HttpStatus.NOT_FOUND);
        }
        weightLossExerciseService.delete(weightLossExercise);
        return new ResponseEntity<WeightLossExercise>(HttpStatus.NO_CONTENT);
    }
}
