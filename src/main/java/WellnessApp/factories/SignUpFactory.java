package WellnessApp.factories;

import WellnessApp.domain.SignUp;

import java.util.Date;
import java.util.Map;

/**
 * Created by Hasan on 8/13/2017.
 */
public class SignUpFactory {

    public static SignUp getSignUp(Map<String, String> values, Date signUp_Date){
        SignUp signUp = new SignUp.Builder()
                .signUp_Date(signUp_Date)
                .dob(values.get("dob"))
                .email(values.get("email"))
                .gender(values.get("gender"))
                .password(values.get("password"))
                .username(values.get("username"))
                .id(values.get("id"))
                .build();
        return signUp;

    }

}
