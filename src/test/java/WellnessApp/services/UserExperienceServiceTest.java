package WellnessApp.services;

import WellnessApp.domain.UserExperience;
import WellnessApp.factories.UserExperienceFactory;
import WellnessApp.services.Impl.UserExperienceServiceImpl;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNull;

/**
 * Created by Hasan on 8/14/2017.
 */
public class UserExperienceServiceTest {
//    UserExperienceService service;
//    Map<String,String> values;
//
//    @BeforeMethod
//    public void setUp() throws Exception {
//        service = new UserExperienceServiceImpl();
//        values = new HashMap<String, String>();
//        values.put("id","1");
//        values.put("comments", "This is a great application");
//    }
//
//    @Test
//    public void testCreate() throws Exception {
//        UserExperience userExperience = UserExperienceFactory.getUserExperience(values);
//        service.create(userExperience);
//        assertEquals("This is a great application",userExperience.getComments());
//    }
//
//    @Test(dependsOnMethods = "testCreate")
//    public void testRead() throws Exception {
//        UserExperience readuserExperience = service.read("1");
//        assertEquals("This is a great application",readuserExperience.getComments());
//    }
//
//    @Test(dependsOnMethods = "testRead")
//    public void testUpdate() throws Exception {
//        UserExperience userExperience = service.read("1");
//        UserExperience newUserExperience = new UserExperience.Builder()
//                .comments(values.get("comments"))
//                .id(values.get("id"))
//                .build();
//        service.update(newUserExperience);
//        UserExperience UpdateUserExperience = service.read("1");
//        assertEquals("Thats great",UpdateUserExperience.getComments());
//    }
//
//    @Test(dependsOnMethods = "testUpdate")
//    public void testDelete() throws Exception {
//        service.delete("1");
//        UserExperience userExperience = service.read("1");
//        assertNull(userExperience);
//    }

}
