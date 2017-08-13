package WellnessApp.repositories;

import WellnessApp.domain.UserExperience;
import WellnessApp.factories.UserExperienceFactory;
import WellnessApp.repositories.Impl.UserExperienceRepositoryImpl;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNull;

/**
 * Created by Hasan on 8/14/2017.
 */
public class UserExperienceRepositoryTest {
    Map<String,String> values;
    UserExperienceRepository repository;

    @BeforeMethod
    public void setUp() throws Exception {
        repository = UserExperienceRepositoryImpl.getInstance();
        values = new HashMap<String, String>();
        values.put("id","1");
        values.put("comments", "This is a great application");
    }

    @Test
    public void create() throws Exception {
        UserExperience userExperience = UserExperienceFactory.getUserExperience(values);
        repository.create(userExperience);
        assertEquals("This is a great application",userExperience.getComments());
    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception {
        UserExperience readuserExperience = repository.read("1");
        assertEquals("This is a great application",readuserExperience.getComments());
    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception {
        UserExperience userExperience = repository.read("1");
        UserExperience newUserExperience = new UserExperience.Builder()
                .comments(values.get("comments"))
                .id(values.get("id"))
                .build();
        repository.update(newUserExperience);
        UserExperience UpdateUserExperience = repository.read("1");
        assertEquals("Thats great",UpdateUserExperience.getComments());
    }

    @Test (dependsOnMethods = "update")
    public void delete() throws Exception {
        repository.delete("1");
        UserExperience userExperience = repository.read("1");
        assertNull(userExperience);
    }

}
