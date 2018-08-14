package WellnessApp.services.Impl;

import WellnessApp.domain.UserExperience;
import WellnessApp.repositories.Impl.UserExperienceRepositoryImpl;
import WellnessApp.repositories.UserExperienceRepository;
import WellnessApp.services.UserExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Hasan on 8/13/2017.
 */
@Component
public class UserExperienceServiceImpl implements UserExperienceService {

    @Autowired
    private UserExperienceRepository userExperienceRepository;
    @Override
    public UserExperience create(UserExperience userExperience) {
        return userExperienceRepository.save(userExperience);
    }
    @Override
    public UserExperience readById(String id) {
        return userExperienceRepository.findOne(id);
    }
    @Override
    public Set<UserExperience> readAll() {
        Set<UserExperience> result = new HashSet<UserExperience>();
        while (userExperienceRepository.findAll().iterator().hasNext()) {
            result.add(userExperienceRepository.findAll().iterator().next());
        }
        return result;
    }
    @Override
    public Iterable<UserExperience> readAllList() {
//        List<UserExperience> result = new ArrayList<UserExperience>();
//        while (userExperienceRepository.findAll().iterator().hasNext()) {
//            result.add(userExperienceRepository.findAll().iterator().next());
//        }
        return userExperienceRepository.findAll();
    }
    @Override
    public UserExperience update(UserExperience userExperience) {
        return userExperienceRepository.save(userExperience);
    }
    @Override
    public void delete(UserExperience id) { userExperienceRepository.delete(id); }
}