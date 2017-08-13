package WellnessApp.services;

import WellnessApp.domain.UserExperience;

/**
 * Created by Hasan on 8/13/2017.
 */
public interface UserExperienceService {
    UserExperience create(UserExperience userExperience);

    UserExperience read(String id);

    UserExperience update(UserExperience userExperience);

    void delete(String id);
}
