package WellnessApp.repositories;

import WellnessApp.domain.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Hasan on 8/13/2017.
 */
public interface UserRepository extends CrudRepository<User, String> {
//    User create(User user);
//
//    User read(String id);
//
//    User update(User user);
//
//    void delete(String id);
}
