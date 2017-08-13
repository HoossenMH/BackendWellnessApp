package WellnessApp.repositories;

import WellnessApp.domain.User;

/**
 * Created by Hasan on 8/13/2017.
 */
public interface UserRepository {
    User create(User user);

    User read(String id);

    User update(User user);

    void delete(String id);
}
