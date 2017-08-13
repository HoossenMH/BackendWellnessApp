package WellnessApp.factories;

import WellnessApp.domain.WeightLossExercise;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static junit.framework.Assert.assertEquals;

/**
 * Created by Hasan on 8/14/2017.
 */
public class WeightLossExerciseFactoryTest {

    Map<String,String> values;
    Date date = new Date();

    @BeforeMethod
    public void setUp() throws Exception {
        values = new HashMap<String, String>();
        values.put("id","1");
        values.put("weightLossExercise_Name","Push_Ups");
    }

    @Test
    public void getWeightLossExercise() throws Exception {
        WeightLossExercise weightLossExercise = WeightLossExerciseFactory
                .getWeightLossExercise(values,20, date, 3);
        assertEquals(15,weightLossExercise.getWeightLossExercise_Amount());
    }
}
