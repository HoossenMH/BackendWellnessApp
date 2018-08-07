package WellnessApp.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by Hasan on 8/13/2017.
 */
@Entity
public class User implements Serializable, Comparable<User> {

    @Id
    private String id;
    private String firstname;
    private String lastname;
    private int age;

    public String getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public int getAge() {
        return age;
    }

    public User() {
    }

    public User(String id, String firstname, String lastname, int age) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
    }

    public User(Builder builder) {
        this.age = builder.age;
        this.id = builder.id;
        this.firstname = builder.firstname;
        this.lastname = builder.lastname;
    }

    public static class Builder{
        private String id;
        private String firstname;
        private String lastname;
        private int age;

        public Builder id(String value){
            this.id = value;
            return this;
        }

        public Builder firstname(String value){
            this.firstname = value;
            return this;
        }

        public Builder lastname(String value){
            this.lastname = value;
            return this;
        }

        public Builder age(int value){
            this.age = value;
            return this;
        }
        public Builder copy(User user) {
            this.age = user.age;
            this.id = user.id;
            this.firstname = user.firstname;
            this.lastname = user.lastname;
            return this;
        }
        public User build(){
            return new User(this);
        }

    }

    @Override
    public int compareTo(User user) {
        return id.compareTo(user.id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return id.equals(user.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}

