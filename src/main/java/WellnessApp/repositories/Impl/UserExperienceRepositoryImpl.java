package WellnessApp.repositories.Impl;

import WellnessApp.domain.UserExperience;
import WellnessApp.repositories.UserExperienceRepository;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Hasan on 8/13/2017.
 */
public class UserExperienceRepositoryImpl implements UserExperienceRepository {

    private static UserExperienceRepositoryImpl respository = null;

    private Map<String,UserExperience> userExperienceTable;

    private UserExperienceRepositoryImpl() {
        userExperienceTable = new HashMap<String, UserExperience>();
    }

    public static UserExperienceRepositoryImpl getInstance(){
        if(respository==null)
            respository = new UserExperienceRepositoryImpl();
        return respository;
    }

    public UserExperience create(UserExperience userExperience) {
        userExperienceTable.put(userExperience.getId(),userExperience);
        UserExperience savedUserExperience = userExperienceTable.get(userExperience.getId());
        return savedUserExperience;
    }

    public UserExperience read(String id) {
        UserExperience userExperience = userExperienceTable.get(id);
        return userExperience;
    }

    public UserExperience update(UserExperience userExperience) {
        userExperienceTable.put(userExperience.getId(),userExperience);
        UserExperience savedUserExperience = userExperienceTable.get(userExperience.getId());
        return savedUserExperience;
    }

    public void delete(String id) {
        userExperienceTable.remove(id);

    }
}

