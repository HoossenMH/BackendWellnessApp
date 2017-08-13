package WellnessApp.factories;

import WellnessApp.domain.UserExperience;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static junit.framework.Assert.assertEquals;

/**
 * Created by Hasan on 8/14/2017.
 */
public class UserExperienceFactoryTest {

    Map<String,String> values;

    @BeforeMethod
    public void setUp() throws Exception {
        values = new HashMap<String, String>();
        values.put("id","1");
        values.put("comments", "This is a great application");
    }

    @Test
    public void getUserExperience() throws Exception {
        UserExperience userExperience = UserExperienceFactory.getUserExperience(values);
        assertEquals("This is a great application",userExperience.getComments());
    }
}
