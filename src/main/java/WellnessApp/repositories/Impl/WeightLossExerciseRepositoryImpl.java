package WellnessApp.repositories.Impl;

import WellnessApp.domain.WeightLossExercise;
import WellnessApp.repositories.WeightLossExerciseRepository;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Hasan on 8/13/2017.
 */
public class WeightLossExerciseRepositoryImpl //implements WeightLossExerciseRepository
{

    private static WeightLossExerciseRepositoryImpl respository = null;

    private Map<String,WeightLossExercise> weightLossExerciseTable;

    private WeightLossExerciseRepositoryImpl() {
        weightLossExerciseTable = new HashMap<String, WeightLossExercise>();
    }

    public static WeightLossExerciseRepositoryImpl getInstance(){
        if(respository==null)
            respository = new WeightLossExerciseRepositoryImpl();
        return respository;
    }

    public WeightLossExercise create(WeightLossExercise weightLossExercise) {
        weightLossExerciseTable.put(weightLossExercise.getId(),weightLossExercise);
        WeightLossExercise savedWeightLossExercise = weightLossExerciseTable.get(weightLossExercise.getId());
        return savedWeightLossExercise;
    }

    public WeightLossExercise read(String id) {
        WeightLossExercise weightLossExercise = weightLossExerciseTable.get(id);
        return weightLossExercise;
    }

    public WeightLossExercise update(WeightLossExercise weightLossExercise) {
        weightLossExerciseTable.put(weightLossExercise.getId(),weightLossExercise);
        WeightLossExercise savedWeightLossExercise = weightLossExerciseTable.get(weightLossExercise.getId());
        return savedWeightLossExercise;
    }

    public void delete(String id) {
        weightLossExerciseTable.remove(id);

    }
}
