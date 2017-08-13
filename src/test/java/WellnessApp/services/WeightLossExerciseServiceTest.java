package WellnessApp.services;

import WellnessApp.domain.WeightLossExercise;
import WellnessApp.factories.WeightLossExerciseFactory;
import WellnessApp.services.Impl.WeightLossExerciseServiceImpl;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNull;

/**
 * Created by Hasan on 8/14/2017.
 */
public class WeightLossExerciseServiceTest {

    WeightLossExerciseService service;
    Map<String,String> values;
    Date date = new Date();

    @BeforeMethod
    public void setUp() throws Exception {
        service = new WeightLossExerciseServiceImpl();
        values = new HashMap<String, String>();
        values.put("id","1");
        values.put("weightLossExercise_Name","Push_Ups");
    }

    @Test
    public void testCreate() throws Exception {
        WeightLossExercise weightLossExercise = WeightLossExerciseFactory
                .getWeightLossExercise(values,20, date, 3);
        service.create(weightLossExercise);
        assertEquals(15,weightLossExercise.getWeightLossExercise_Amount());
    }

    @Test(dependsOnMethods = "testCreate")
    public void testRead() throws Exception {
        WeightLossExercise readweightLossExercise = service.read("1");
        assertEquals(15,readweightLossExercise.getWeightLossExercise_Amount());
    }

    @Test(dependsOnMethods = "testRead")
    public void testUpdate() throws Exception {
        WeightLossExercise weightLossExercise = service.read("1");
        WeightLossExercise newWeightLossExercise = new WeightLossExercise.Builder()
                .weightLossExercise_Reps(3)
                .weightLossExercise_Name("weightLossExercise_Name")
                .weightLossExercise_Date(date)
                .weightLossExercise_Amount(20)
                .id(values.get("id"))
                .build();
        service.update(newWeightLossExercise);
        WeightLossExercise UpdateWeightLossExercise = service.read("1");
        assertEquals(20,UpdateWeightLossExercise.getWeightLossExercise_Amount());
    }

    @Test(dependsOnMethods = "testUpdate")
    public void testDelete() throws Exception {
        service.delete("1");
        WeightLossExercise weightLossExercise = service.read("1");
        assertNull(weightLossExercise);
    }

}
