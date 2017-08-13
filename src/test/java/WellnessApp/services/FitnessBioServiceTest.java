package WellnessApp.services;

import WellnessApp.domain.FitnessBio;
import WellnessApp.factories.FitnessBioFactory;
import WellnessApp.services.Impl.FitnessBioServiceImpl;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNull;

/**
 * Created by Hasan on 8/13/2017.
 */
public class FitnessBioServiceTest {
    Map<String,String> values;
    FitnessBioService service;

    @BeforeMethod
    public void setUp() throws Exception {
        service = new FitnessBioServiceImpl();
        values = new HashMap<String, String>();
        values.put("id","1");
        values.put("bloodPressure", "129/80");
        values.put("reasons", "I would like to loose weight");
    }

    @Test
    public void create() throws Exception {
        FitnessBio fitnessBio = FitnessBioFactory.getFitnessBio(values,25, 1.6,70);
        service.create(fitnessBio);
        assertEquals(70,fitnessBio.getWeight());
    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception {
        FitnessBio readfitnessBio = service.read("1");
        assertEquals(70,readfitnessBio.getWeight());
    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception {
        FitnessBio fitnessBio = service.read("1");
        FitnessBio newFitnessBio = new FitnessBio.Builder()
                .BMI(25)
                .height(1.6)
                .weight(65)
                .bloodPressure(values.get("bloodPressure"))
                .reasons(values.get("reasons"))
                .id(values.get("id"))
                .build();
        service.update(newFitnessBio);
        FitnessBio UpdateFitnessBio = service.read("1");
        assertEquals(65,UpdateFitnessBio.getWeight());
    }

    @Test (dependsOnMethods = "update")
    public void delete() throws Exception {
        service.delete("1");
        FitnessBio fitnessBio = service.read("1");
        assertNull(fitnessBio);
    }

}
