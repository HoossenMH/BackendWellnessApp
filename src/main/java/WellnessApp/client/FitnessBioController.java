package WellnessApp.client;

import WellnessApp.domain.FitnessBio;
import WellnessApp.services.FitnessBioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Set;

/**
 * Created by Hasan on 9/6/2017.
 */
@RestController
@RequestMapping("/fitnessBios")
public class FitnessBioController {

    // Inject Service
    @Autowired
    private FitnessBioService fitnessBioService;

    //-------------------Create a FitnessBio--------------------------------------------------------

    @CrossOrigin(origins = "http://localhost:53830")
    @RequestMapping(value = "/AddFitnessBio", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FitnessBio> createFitnessBio(@RequestBody FitnessBio fitnessBio, UriComponentsBuilder ucBuilder) {
        fitnessBioService.create(fitnessBio);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/fitnessBios/fitnessBio/{id}").buildAndExpand(fitnessBio.getId()).toUri());
        return new ResponseEntity<FitnessBio>(headers, HttpStatus.CREATED);
    }

    //-------------------Retrieve Single FitnessBio--------------------------------------------------------

    @CrossOrigin(origins = "http://localhost:53830")
    @RequestMapping(value = "/fitnessBio/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FitnessBio> getFitnessBio(@PathVariable("id") String id) {
        FitnessBio fitnessBio = fitnessBioService.readById(id);
        if (fitnessBio == null) {
            return new ResponseEntity<FitnessBio>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<FitnessBio>(fitnessBio, HttpStatus.OK);
    }


    //-------------------Retrieve All FitnessBio--------------------------------------------------------

    @CrossOrigin(origins = "http://localhost:53830")
    @RequestMapping(value = "/fitnessBio/AllFitnessBio", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Iterable<FitnessBio>> getFitnessBio() {
        Iterable<FitnessBio> fitnessBios = fitnessBioService.readAllList();
        if(!fitnessBios.iterator().hasNext()){
            return new ResponseEntity<Iterable<FitnessBio>>(HttpStatus.NO_CONTENT);// OR HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<Iterable<FitnessBio>>(fitnessBios, HttpStatus.OK);
    }

    //------------------- Update a FitnessBio --------------------------------------------------------

    @CrossOrigin(origins = "http://localhost:53830")
    @RequestMapping(value = "/fitnessBio/{id}", method = RequestMethod.PUT)
    public ResponseEntity<FitnessBio> updateFitnessBio(@PathVariable("id") String id, @RequestBody FitnessBio fitnessBio) {

        FitnessBio currentFitnessBio = fitnessBioService.readById(id);

        if (currentFitnessBio==null) {
            return new ResponseEntity<FitnessBio>(HttpStatus.NOT_FOUND);
        }
        FitnessBio updatedFitnessBio = new FitnessBio.Builder().copy(currentFitnessBio)
                .bloodPressure(fitnessBio.getBloodPressure())
                .height(fitnessBio.getHeight())
                .weight(fitnessBio.getWeight())
                .reasons(fitnessBio.getReasons())
                .BMI(fitnessBio.getBMI())
                .build();
        fitnessBioService.update(updatedFitnessBio);
        return new ResponseEntity<FitnessBio>(updatedFitnessBio, HttpStatus.OK);
    }

    //------------------- Delete a FitnessBio --------------------------------------------------------

    @CrossOrigin(origins = "http://localhost:53830")
    @RequestMapping(value = "/fitnessBio/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<FitnessBio> deleteFitnessBio(@PathVariable("id") String id) {
        FitnessBio fitnessBio = fitnessBioService.readById(id);
        if (fitnessBio == null) {
            return new ResponseEntity<FitnessBio>(HttpStatus.NOT_FOUND);
        }
        fitnessBioService.delete(fitnessBio);
        return new ResponseEntity<FitnessBio>(HttpStatus.NO_CONTENT);
    }
}
