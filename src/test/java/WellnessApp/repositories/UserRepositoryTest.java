package WellnessApp.repositories;

import WellnessApp.domain.User;
import WellnessApp.factories.UserFactory;
import WellnessApp.repositories.Impl.UserRepositoryImpl;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNull;

/**
 * Created by Hasan on 8/13/2017.
 */
public class UserRepositoryTest {
    Map<String,String> values;
    UserRepository repository;

    @BeforeMethod
    public void setUp() throws Exception {
        repository = UserRepositoryImpl.getInstance();
        values = new HashMap<String, String>();
        values.put("id","1");
        values.put("firstname","Hasan");
        values.put("lastname","Hoossen");
    }

    @Test
    public void create() throws Exception {
        User user = UserFactory.getUser(values,25);
        repository.create(user);
        assertEquals(25,user.getAge());
    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception {
        User readuser = repository.read("1");
        assertEquals(25,readuser.getAge());
    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception {
        User user = repository.read("1");
        User newUser = new User.Builder()
                .age(22)
                .firstname(values.get("firstname"))
                .lastname(values.get("lastname"))
                .id(values.get("id"))
                .build();
        repository.update(newUser);
        User UpdateUser = repository.read("1");
        assertEquals(22,UpdateUser.getAge());
    }

    @Test (dependsOnMethods = "update")
    public void delete() throws Exception {
        repository.delete("1");
        User user = repository.read("1");
        assertNull(user);
    }

}