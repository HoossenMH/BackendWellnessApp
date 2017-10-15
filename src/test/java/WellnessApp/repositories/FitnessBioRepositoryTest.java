package WellnessApp.repositories;

import WellnessApp.domain.FitnessBio;
import WellnessApp.factories.FitnessBioFactory;
import WellnessApp.repositories.Impl.FitnessBioRepositoryImpl;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNull;

/**
 * Created by Hasan on 8/13/2017.
 */
public class FitnessBioRepositoryTest {
//    Map<String,String> values;
//    FitnessBioRepository repository;
//
//    @BeforeMethod
//    public void setUp() throws Exception {
//        repository = FitnessBioRepositoryImpl.getInstance();
//        values = new HashMap<String, String>();
//        values.put("id","1");
//        values.put("bloodPressure", "129/80");
//        values.put("reasons", "I would like to loose weight");
//    }
//
//    @Test
//    public void create() throws Exception {
//        FitnessBio fitnessBio = FitnessBioFactory.getFitnessBio(values,25, 1.6,70);
//        repository.create(fitnessBio);
//        assertEquals(70,fitnessBio.getWeight());
//    }
//
//    @Test(dependsOnMethods = "create")
//    public void read() throws Exception {
//        FitnessBio readfitnessBio = repository.read("1");
//        assertEquals(70,readfitnessBio.getWeight());
//    }
//
//    @Test(dependsOnMethods = "read")
//    public void update() throws Exception {
//        FitnessBio fitnessBio = repository.read("1");
//        FitnessBio newFitnessBio = new FitnessBio.Builder()
//                .BMI(25)
//                .height(1.6)
//                .weight(65)
//                .bloodPressure(values.get("bloodPressure"))
//                .reasons(values.get("reasons"))
//                .id(values.get("id"))
//                .build();
//        repository.update(newFitnessBio);
//        FitnessBio UpdateFitnessBio = repository.read("1");
//        assertEquals(65,UpdateFitnessBio.getWeight());
//    }
//
//    @Test (dependsOnMethods = "update")
//    public void delete() throws Exception {
//        repository.delete("1");
//        FitnessBio fitnessBio = repository.read("1");
//        assertNull(fitnessBio);
//    }

}
