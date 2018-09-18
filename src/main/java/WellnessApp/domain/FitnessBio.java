package WellnessApp.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by Hasan on 8/13/2017.
 */
@Entity
public class FitnessBio implements Serializable, Comparable<FitnessBio>  {

    @Id
    //@GeneratedValue(strategy= GenerationType.AUTO)
    private String id;
    private String reasons;
    private double weight;
    private double height;
    private double BMI;
    private String bloodPressure;

    private FitnessBio() {
    }

    public String getId() {
        return id;
    }

    public String getReasons() {
        return reasons;
    }

    public double getWeight() {
        return weight;
    }

    public double getHeight() {
        return height;
    }

    public double getBMI() {
        return BMI;
    }

    public String getBloodPressure() {
        return bloodPressure;
    }

    public FitnessBio(Builder builder) {
        this.id = builder.id;
        this.reasons = builder.reasons;
        this.weight = builder.weight;
        this.height = builder.height;
        this.BMI = builder.BMI;
        this.bloodPressure = builder.bloodPressure;
    }
    public static class Builder{
        private String id;
        private String reasons;
        private double weight;
        private double height;
        private double BMI;
        private String bloodPressure;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder reasons(String reasons) {
            this.reasons = reasons;
            return this;
        }

        public Builder weight(double weight) {
            this.weight = weight;
            return this;
        }

        public Builder height(double height) {
            this.height = height;
            return this;
        }

        public Builder BMI(double BMI) {
            this.BMI = BMI;
            return this;
        }

        public Builder bloodPressure(String bloodPressure) {
            this.bloodPressure = bloodPressure;
            return this;
        }

        public Builder copy(FitnessBio fitnessBio) {
            this.id = fitnessBio.id;
            this.reasons = fitnessBio.reasons;
            this.weight = fitnessBio.weight;
            this.height = fitnessBio.height;
            this.BMI = fitnessBio.BMI;
            this.bloodPressure = fitnessBio.bloodPressure;
            return  this;
        }

        public FitnessBio build(){
            return new FitnessBio(this);
        }
    }

    @Override
    public int compareTo(FitnessBio fitnessBio) {
        return id.compareTo(fitnessBio.id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FitnessBio that = (FitnessBio) o;

        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "FitnessBio{" +
                "id='" + id + '\'' +
                ", reasons='" + reasons + '\'' +
                ", weight='" + weight + '\'' +
                ", height='" + height + '\'' +
                ", BMI='" + BMI + '\'' +
                ", bloodPressure='" + bloodPressure + '\'' +
                '}';
    }
}
