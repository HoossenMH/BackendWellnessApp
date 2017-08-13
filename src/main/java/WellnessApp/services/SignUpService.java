package WellnessApp.services;

import WellnessApp.domain.SignUp;

/**
 * Created by Hasan on 8/13/2017.
 */
public interface SignUpService {
    SignUp create(SignUp signUp);

    SignUp read(String id);

    SignUp update(SignUp signUp);

    void delete(String id);
}
