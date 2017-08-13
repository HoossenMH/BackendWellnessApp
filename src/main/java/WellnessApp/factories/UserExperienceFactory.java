package WellnessApp.factories;

import WellnessApp.domain.UserExperience;

import java.util.Map;

/**
 * Created by Hasan on 8/13/2017.
 */
public class UserExperienceFactory {

    public static UserExperience getUserExperience(Map<String, String> values){
        UserExperience userExperience = new UserExperience.Builder()
                .comments(values.get("comments"))
                .id(values.get("id"))
                .build();
        return userExperience;

    }

}
