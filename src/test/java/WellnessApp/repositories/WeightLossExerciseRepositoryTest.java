package WellnessApp.repositories;

import WellnessApp.domain.WeightLossExercise;
import WellnessApp.factories.WeightLossExerciseFactory;
import WellnessApp.repositories.Impl.WeightLossExerciseRepositoryImpl;
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
public class WeightLossExerciseRepositoryTest {

    Map<String,String> values;
    WeightLossExerciseRepository repository;
    Date date = new Date();

    @BeforeMethod
    public void setUp() throws Exception {
        repository = WeightLossExerciseRepositoryImpl.getInstance();
        values = new HashMap<String, String>();
        values.put("id","1");
        values.put("weightLossExercise_Name","Push_Ups");
    }

    @Test
    public void create() throws Exception {
        WeightLossExercise weightLossExercise = WeightLossExerciseFactory
                .getWeightLossExercise(values,20, date, 3);
        repository.create(weightLossExercise);
        assertEquals(15,weightLossExercise.getWeightLossExercise_Amount());
    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception {
        WeightLossExercise readweightLossExercise = repository.read("1");
        assertEquals(15,readweightLossExercise.getWeightLossExercise_Amount());
    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception {
        WeightLossExercise weightLossExercise = repository.read("1");
        WeightLossExercise newWeightLossExercise = new WeightLossExercise.Builder()
                .weightLossExercise_Reps(3)
                .weightLossExercise_Name("weightLossExercise_Name")
                .weightLossExercise_Date(date)
                .weightLossExercise_Amount(20)
                .id(values.get("id"))
                .build();
        repository.update(newWeightLossExercise);
        WeightLossExercise UpdateWeightLossExercise = repository.read("1");
        assertEquals(20,UpdateWeightLossExercise.getWeightLossExercise_Amount());
    }

    @Test (dependsOnMethods = "update")
    public void delete() throws Exception {
        repository.delete("1");
        WeightLossExercise weightLossExercise = repository.read("1");
        assertNull(weightLossExercise);
    }

}