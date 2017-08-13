package WellnessApp.services.Impl;

import WellnessApp.domain.WeightLossExercise;
import WellnessApp.repositories.Impl.WeightLossExerciseRepositoryImpl;
import WellnessApp.repositories.WeightLossExerciseRepository;
import WellnessApp.services.WeightLossExerciseService;

/**
 * Created by Hasan on 8/13/2017.
 */
public class WeightLossExerciseServiceImpl implements WeightLossExerciseService {

    private static WeightLossExerciseServiceImpl service = null;

    WeightLossExerciseRepository repository = WeightLossExerciseRepositoryImpl.getInstance();

    public static WeightLossExerciseServiceImpl getInstance(){
        if(service == null)
            service = new WeightLossExerciseServiceImpl();
        return service;
    }

    public WeightLossExercise create(WeightLossExercise weightLossExercise) {
        return repository.create(weightLossExercise);
    }

    public WeightLossExercise read(String id) {
        return repository.read(id);
    }

    public WeightLossExercise update(WeightLossExercise weightLossExercise) {
        return repository.update(weightLossExercise);
    }

    public void delete(String id) {
        repository.delete(id);

    }
}