package WellnessApp.services.Impl;

import WellnessApp.domain.UserExperience;
import WellnessApp.repositories.Impl.UserExperienceRepositoryImpl;
import WellnessApp.repositories.UserExperienceRepository;
import WellnessApp.services.UserExperienceService;

/**
 * Created by Hasan on 8/13/2017.
 */
public class UserExperienceServiceImpl implements UserExperienceService {

    private static UserExperienceServiceImpl service = null;

    UserExperienceRepository repository = UserExperienceRepositoryImpl.getInstance();

    public static UserExperienceServiceImpl getInstance(){
        if(service == null)
            service = new UserExperienceServiceImpl();
        return service;
    }

    public UserExperience create(UserExperience userExperience) {
        return repository.create(userExperience);
    }

    public UserExperience read(String id) {
        return repository.read(id);
    }

    public UserExperience update(UserExperience userExperience) {
        return repository.update(userExperience);
    }

    public void delete(String id) {
        repository.delete(id);

    }
}