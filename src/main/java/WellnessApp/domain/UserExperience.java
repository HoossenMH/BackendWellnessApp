package WellnessApp.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by Hasan on 8/13/2017.
 */
@Entity
public class UserExperience implements Serializable, Comparable<UserExperience> {

    @Id
    private String id;
    private String comments;

    public String getId() {
        return id;
    }

    public String getComments() {
        return comments;
    }

    private UserExperience() {
    }

    public UserExperience(Builder builder) {
        this.id = id;
        this.comments = comments;
    }
    public static class Builder{
        private String id;
        private String comments;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder comments(String comments) {
            this.comments = comments;
            return this;
        }
        public Builder copy(UserExperience userExperience) {
            this.id = userExperience.id;
            this.comments = userExperience.comments;
            return this;
        }
        public UserExperience build(){
            return new UserExperience(this);
        }
    }

    @Override
    public int compareTo(UserExperience userExperience) {
        return id.compareTo(userExperience.id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserExperience that = (UserExperience) o;

        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "UserExperience{" +
                "id='" + id + '\'' +
                ", comments='" + comments + '\'' +
                '}';
    }
}
