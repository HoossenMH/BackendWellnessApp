package WellnessApp.services.Impl;

import WellnessApp.domain.SignUp;
import WellnessApp.repositories.Impl.SignUpRepositoryImpl;
import WellnessApp.repositories.SignUpRepository;
import WellnessApp.services.SignUpService;
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
public class SignUpServiceImpl implements SignUpService {

    @Autowired
    private SignUpRepository signUpRepository;
    @Override
    public SignUp create(SignUp signUp) {
        return signUpRepository.save(signUp);
    }
    @Override
    public SignUp readById(String id) {
        return signUpRepository.findOne(id);
    }
    @Override
    public Set<SignUp> readAll() {
        Set<SignUp> result = new HashSet<SignUp>();
        while (signUpRepository.findAll().iterator().hasNext()) {
            result.add(signUpRepository.findAll().iterator().next());
        }
        return result;
    }
    @Override
    public Iterable<SignUp> readAllList() {
//        List<SignUp> result = new ArrayList<SignUp>();
//        while (signUpRepository.findAll().iterator().hasNext()) {
//            result.add(signUpRepository.findAll().iterator().next());
//        }
        return  signUpRepository.findAll();
    }
    @Override
    public SignUp update(SignUp signUp) {
        return signUpRepository.save(signUp);
    }
    @Override
    public void delete(SignUp id) { signUpRepository.delete(id); }
}