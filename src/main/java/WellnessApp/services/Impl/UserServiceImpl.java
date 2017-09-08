package WellnessApp.services.Impl;

import WellnessApp.domain.User;
import WellnessApp.repositories.Impl.UserRepositoryImpl;
import WellnessApp.repositories.UserRepository;
import WellnessApp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Hasan on 8/13/2017.
 */
@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private static UserServiceImpl service = null;

    UserRepository repository = UserRepositoryImpl.getInstance();

    public static UserServiceImpl getInstance(){
        if(service == null)
            service = new UserServiceImpl();
        return service;
    }

    public User create(User user) {
        return repository.create(user);
    }

    public User read(String id) {
        return repository.read(id);
    }

    public User update(User user) {
        return repository.update(user);
    }

    public void delete(String id) {
        repository.delete(id);

    }
}