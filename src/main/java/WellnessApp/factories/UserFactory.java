package WellnessApp.factories;

import WellnessApp.domain.User;

import java.util.Map;

/**
 * Created by Hasan on 8/13/2017.
 */
public class UserFactory {

    public static User getUser(Map<String, String> values, int age){
        User user = new User.Builder()
                .age(age)
                .firstname(values.get("firstname"))
                .lastname(values.get("lastname"))
                .id(values.get("id"))
                .build();
        return user;

    }
}
