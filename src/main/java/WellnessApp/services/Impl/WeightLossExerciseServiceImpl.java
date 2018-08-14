package WellnessApp.services.Impl;

import WellnessApp.domain.WeightLossExercise;
import WellnessApp.repositories.Impl.WeightLossExerciseRepositoryImpl;
import WellnessApp.repositories.WeightLossExerciseRepository;
import WellnessApp.services.WeightLossExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Hasan on 8/13/2017.
 */
@Component
public class WeightLossExerciseServiceImpl implements WeightLossExerciseService {

    @Autowired
    private  WeightLossExerciseRepository weightLossExerciseRepository;
    @Override
    public  WeightLossExercise create( WeightLossExercise weightLossExercise) {
        return weightLossExerciseRepository.save(weightLossExercise);
    }
    @Override
    public  WeightLossExercise readById(String id) {
        return weightLossExerciseRepository.findOne(id);
    }
    @Override
    public Set< WeightLossExercise> readAll() {
        Set< WeightLossExercise> result = new HashSet< WeightLossExercise>();
        while (weightLossExerciseRepository.findAll().iterator().hasNext()) {
            result.add(weightLossExerciseRepository.findAll().iterator().next());
        }
        return result;
    }
    @Override
    public Iterable<WeightLossExercise> readAllList() {
//        List<WeightLossExercise> result = new ArrayList<WeightLossExercise>();
//        while (weightLossExerciseRepository.findAll().iterator().hasNext()) {
//            result.add(weightLossExerciseRepository.findAll().iterator().next());
//        }
        return weightLossExerciseRepository.findAll();
    }
    @Override
    public  WeightLossExercise update( WeightLossExercise weightLossExercise) {
        return weightLossExerciseRepository.save(weightLossExercise);
    }
    @Override
    public void delete( WeightLossExercise id) { weightLossExerciseRepository.delete(id); }
}