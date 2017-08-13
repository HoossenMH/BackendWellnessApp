package WellnessApp.services.Impl;

import WellnessApp.domain.SignUp;
import WellnessApp.repositories.Impl.SignUpRepositoryImpl;
import WellnessApp.repositories.SignUpRepository;
import WellnessApp.services.SignUpService;

/**
 * Created by Hasan on 8/13/2017.
 */
public class SignUpServiceImpl implements SignUpService {

    private static SignUpServiceImpl service = null;

    SignUpRepository repository = SignUpRepositoryImpl.getInstance();

    public static SignUpServiceImpl getInstance(){
        if(service == null)
            service = new SignUpServiceImpl();
        return service;
    }

    public SignUp create(SignUp signUp) {
        return repository.create(signUp);
    }

    public SignUp read(String id) {
        return repository.read(id);
    }

    public SignUp update(SignUp signUp) {
        return repository.update(signUp);
    }

    public void delete(String id) {
        repository.delete(id);

    }
}