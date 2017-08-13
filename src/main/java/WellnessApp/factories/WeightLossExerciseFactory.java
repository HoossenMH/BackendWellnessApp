package WellnessApp.factories;

import WellnessApp.domain.WeightLossExercise;

import java.util.Date;
import java.util.Map;

/**
 * Created by Hasan on 8/13/2017.
 */
public class WeightLossExerciseFactory {

    public static WeightLossExercise getWeightLossExercise(Map<String, String> values, int weightLossExercise_Amount,
                                               Date weightLossExercise_Date, int weightLossExercise_Reps){
        WeightLossExercise weightLossExercise = new WeightLossExercise.Builder()
                .weightLossExercise_Amount(weightLossExercise_Amount)
                .weightLossExercise_Date(weightLossExercise_Date)
                .weightLossExercise_Name(values.get("weightLossExercise_Name"))
                .weightLossExercise_Reps(weightLossExercise_Reps)
                .id(values.get("id"))
                .build();
        return weightLossExercise;

    }
}
