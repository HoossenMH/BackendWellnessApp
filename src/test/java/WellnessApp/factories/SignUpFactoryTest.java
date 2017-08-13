package WellnessApp.factories;

import WellnessApp.domain.SignUp;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static junit.framework.Assert.assertEquals;

/**
 * Created by Hasan on 8/13/2017.
 */
public class SignUpFactoryTest {
    Map<String,String> values;
    Date date = new Date();

    @BeforeMethod
    public void setUp() throws Exception {
        values = new HashMap<String, String>();
        values.put("id","1");
        values.put("dob", "19 March 1993");
        values.put("email", "ghasan16@gmail.com");
        values.put("gender", "male");
        values.put("password", "test");
        values.put("username", "Hasan");

    }

    @Test
    public void getSignUp() throws Exception {
        SignUp signUp = SignUpFactory.getSignUp(values, date);
        assertEquals("Hasan",signUp.getUsername());
    }
}
