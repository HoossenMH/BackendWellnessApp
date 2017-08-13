package WellnessApp.repositories;

import WellnessApp.domain.WeightLossExercise;

/**
 * Created by Hasan on 8/13/2017.
 */
public interface WeightLossExerciseRepository {
    WeightLossExercise create(WeightLossExercise weightLossExercise);

    WeightLossExercise read(String id);

    WeightLossExercise update(WeightLossExercise weightLossExercise);

    void delete(String id);
}
