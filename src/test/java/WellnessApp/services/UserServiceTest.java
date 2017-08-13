package WellnessApp.services;

import WellnessApp.domain.User;
import WellnessApp.factories.UserFactory;
import WellnessApp.services.Impl.UserServiceImpl;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNull;

/**
 * Created by Hasan on 8/13/2017.
 */
public class UserServiceTest {
    UserService service;
    Map<String,String> values;

    @BeforeMethod
    public void setUp() throws Exception {
        service = new UserServiceImpl();
        values = new HashMap<String, String>();
        values.put("id","1");
        values.put("firstname","Hasan");
        values.put("lastname","Hoossen");
    }

    @Test
    public void testCreate() throws Exception {
        User user = UserFactory.getUser(values,25);
        service.create(user);
        assertEquals(25,user.getAge());
    }

    @Test(dependsOnMethods = "testCreate")
    public void testRead() throws Exception {
        User readuser = service.read("1");
        assertEquals(25,readuser.getAge());
    }

    @Test(dependsOnMethods = "testRead")
    public void testUpdate() throws Exception {
        User user = service.read("1");
        User newUser = new User.Builder()
                .age(22)
                .firstname(values.get("firstname"))
                .lastname(values.get("lastname"))
                .id(values.get("id"))
                .build();
        service.update(newUser);
        User UpdateUser = service.read("1");
        assertEquals(22,UpdateUser.getAge());
    }

    @Test(dependsOnMethods = "testUpdate")
    public void testDelete() throws Exception {
        service.delete("1");
        User user = service.read("1");
        assertNull(user);
    }

}