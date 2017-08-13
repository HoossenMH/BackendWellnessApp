package WellnessApp.repositories;

import WellnessApp.domain.SignUp;
import WellnessApp.factories.SignUpFactory;
import WellnessApp.repositories.Impl.SignUpRepositoryImpl;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNull;

/**
 * Created by Hasan on 8/13/2017.
 */
public class SignUpRepositoryTest {
    Map<String,String> values;
    SignUpRepository repository;
    Date date = new Date();

    @BeforeMethod
    public void setUp() throws Exception {
        repository = SignUpRepositoryImpl.getInstance();
        values = new HashMap<String, String>();
        values.put("id","1");
        values.put("dob", "19 March 1993");
        values.put("email", "ghasan16@gmail.com");
        values.put("gender", "male");
        values.put("password", "test");
        values.put("username", "Hasan");
    }

    @Test
    public void create() throws Exception {
        SignUp signUp = SignUpFactory.getSignUp(values, date);
        repository.create(signUp);
        assertEquals("male",signUp.getGender());
    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception {
        SignUp readsignUp = repository.read("1");
        assertEquals("male",readsignUp.getGender());
    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception {
        SignUp signUp = repository.read("1");
        SignUp newSignUp = new SignUp.Builder()
                .signUp_Date(date)
                .dob(values.get("dob"))
                .email(values.get("email"))
                .gender(values.get("gender"))
                .password(values.get("password"))
                .username(values.get("username"))
                .id(values.get("id"))
                .build();
        repository.update(newSignUp);
        SignUp UpdateSignUp = repository.read("1");
        assertEquals("male",UpdateSignUp.getGender());
    }

    @Test (dependsOnMethods = "update")
    public void delete() throws Exception {
        repository.delete("1");
        SignUp signUp = repository.read("1");
        assertNull(signUp);
    }

}