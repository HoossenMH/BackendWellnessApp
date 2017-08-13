package WellnessApp.factories;

import WellnessApp.domain.User;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static junit.framework.Assert.assertEquals;

/**
 * Created by Hasan on 8/13/2017.
 */
public class UserFactoryTest {
    Map<String, String> values;

    @BeforeMethod
    public void setUp() throws Exception {
        values = new HashMap<String, String>();
        values.put("id", "1");
        values.put("firstname", "Hasan");
        values.put("lastname", "Hoossen");
    }

    @Test
    public void getUser() throws Exception {
        User user = UserFactory.getUser(values, 25);
        assertEquals("Hoossen", user.getLastname());
    }
}
