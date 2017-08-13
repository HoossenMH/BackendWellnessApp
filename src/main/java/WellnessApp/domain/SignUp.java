package WellnessApp.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Hasan on 8/13/2017.
 */
public class SignUp implements Serializable {

    private String id;
    private String username;
    private String password;
    private String email;
    private String gender;
    private String dob;
    private Date signUp_Date;

    private SignUp() {
    }

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getGender() {
        return gender;
    }

    public String getDob() {
        return dob;
    }

    public Date getSignUp_Date() {
        return signUp_Date;
    }

    public SignUp(Builder builder) {
        this.id = builder.id;
        this.username = builder.username;
        this.password = builder.password;
        this.email = builder.email;
        this.gender = builder.gender;
        this.dob = builder.dob;
        this.signUp_Date = builder.signUp_Date;
    }

    public static class Builder{
        private String id;
        private String username;
        private String password;
        private String email;
        private String gender;
        private String dob;
        private Date signUp_Date;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder username(String username) {
            this.username = username;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder gender(String gender) {
            this.gender = gender;
            return this;
        }

        public Builder dob(String dob) {
            this.dob = dob;
            return this;
        }

        public Builder signUp_Date(Date signUp_Date) {
            this.signUp_Date = signUp_Date;
            return this;
        }

        public SignUp build(){
            return new SignUp(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SignUp signUp = (SignUp) o;

        return id.equals(signUp.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
