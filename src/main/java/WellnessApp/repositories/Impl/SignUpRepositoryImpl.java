package WellnessApp.repositories.Impl;

import WellnessApp.domain.SignUp;
import WellnessApp.repositories.SignUpRepository;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Hasan on 8/13/2017.
 */
public class SignUpRepositoryImpl implements SignUpRepository {

    private static SignUpRepositoryImpl respository = null;

    private Map<String,SignUp> signUpTable;

    private SignUpRepositoryImpl() {
        signUpTable = new HashMap<String, SignUp>();
    }

    public static SignUpRepositoryImpl getInstance(){
        if(respository==null)
            respository = new SignUpRepositoryImpl();
        return respository;
    }

    public SignUp create(SignUp signUp) {
        signUpTable.put(signUp.getId(),signUp);
        SignUp savedSignUp = signUpTable.get(signUp.getId());
        return savedSignUp;
    }

    public SignUp read(String id) {
        SignUp signUp = signUpTable.get(id);
        return signUp;
    }

    public SignUp update(SignUp signUp) {
        signUpTable.put(signUp.getId(),signUp);
        SignUp savedSignUp = signUpTable.get(signUp.getId());
        return savedSignUp;
    }

    public void delete(String id) {
        signUpTable.remove(id);

    }
}

