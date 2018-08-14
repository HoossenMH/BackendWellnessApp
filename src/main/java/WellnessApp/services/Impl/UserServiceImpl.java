package WellnessApp.services.Impl;

import WellnessApp.domain.User;
import WellnessApp.repositories.Impl.UserRepositoryImpl;
import WellnessApp.repositories.UserRepository;
import WellnessApp.services.UserService;
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
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public User create(User user) {
        return userRepository.save(user);
    }
    @Override
    public User readById(String id) {
        return userRepository.findOne(id);
    }
    @Override
    public Set<User> readAll() {
        Set<User> result = new HashSet<User>();
        while (userRepository.findAll().iterator().hasNext()) {
            result.add(userRepository.findAll().iterator().next());
        }
        return result;
    }
    @Override
    public Iterable<User> readAllList() {
//        List<User> result = new ArrayList<User>();
//        while (userRepository.findAll().iterator().hasNext()) {
//            result.add(userRepository.findAll().iterator().next());
//        }
        return userRepository.findAll();
    }
    @Override
    public User update(User user) {
        return userRepository.save(user);
    }
    @Override
    public void delete(User id) { userRepository.delete(id); }
}