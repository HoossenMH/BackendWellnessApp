package WellnessApp.factories;

import WellnessApp.domain.FitnessBio;

import java.util.Map;

/**
 * Created by Hasan on 8/13/2017.
 */
public class FitnessBioFactory {

    public static FitnessBio getFitnessBio(Map<String, String> values, double BMI, double height, double weight){
        FitnessBio fitnessBio = new FitnessBio.Builder()
                .BMI(BMI)
                .height(height)
                .weight(weight)
                .bloodPressure(values.get("bloodPressure"))
                .reasons(values.get("reasons"))
                .id(values.get("id"))
                .build();
        return fitnessBio;
    }
}
