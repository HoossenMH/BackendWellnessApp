package WellnessApp.factories;

import WellnessApp.domain.FitnessBio;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static junit.framework.Assert.assertEquals;

/**
 * Created by Hasan on 8/13/2017.
 */
public class FitnessBioFactoryTest {
    Map<String,String> values;

    @BeforeMethod
    public void setUp() throws Exception {
        values = new HashMap<String, String>();
        values.put("id","1");
        values.put("bloodPressure", "129/80");
        values.put("reasons", "I would like to loose weight");
    }

    @Test
    public void getFitnessBio() throws Exception {
        FitnessBio fitnessBio = FitnessBioFactory.getFitnessBio(values,25, 1.6,70);
        assertEquals(70,fitnessBio.getWeight());
    }

}
