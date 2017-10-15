package WellnessApp.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Hasan on 8/13/2017.
 */
@Entity
public class WeightLossExercise implements Serializable, Comparable<WeightLossExercise> {

    @Id
    private String id;
    private String weightLossExercise_Name;
    private int weightLossExercise_Amount;
    private int weightLossExercise_Reps;
    private Date weightLossExercise_Date;

    private WeightLossExercise() {
    }

    public String getId() {
        return id;
    }

    public String getWeightLossExercise_Name() {
        return weightLossExercise_Name;
    }

    public int getWeightLossExercise_Amount() {
        return weightLossExercise_Amount;
    }

    public int getWeightLossExercise_Reps() {
        return weightLossExercise_Reps;
    }

    public Date getWeightLossExercise_Date() {
        return weightLossExercise_Date;
    }

    public WeightLossExercise(Builder builder) {
        this.id = id;
        this.weightLossExercise_Name = weightLossExercise_Name;
        this.weightLossExercise_Amount = weightLossExercise_Amount;
        this.weightLossExercise_Reps = weightLossExercise_Reps;
        this.weightLossExercise_Date = weightLossExercise_Date;
    }

    public static class Builder{
        private String id;
        private String weightLossExercise_Name;
        private int weightLossExercise_Amount;
        private int weightLossExercise_Reps;
        private Date weightLossExercise_Date;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder weightLossExercise_Name(String weightLossExercise_Name) {
            this.weightLossExercise_Name = weightLossExercise_Name;
            return this;
        }

        public Builder weightLossExercise_Amount(int weightLossExercise_Amount) {
            this.weightLossExercise_Amount = weightLossExercise_Amount;
            return this;
        }

        public Builder weightLossExercise_Reps(int weightLossExercise_Reps) {
            this.weightLossExercise_Reps = weightLossExercise_Reps;
            return this;
        }

        public Builder weightLossExercise_Date(Date weightLossExercise_Date) {
            this.weightLossExercise_Date = weightLossExercise_Date;
            return this;
        }
        public Builder copy(WeightLossExercise weightLossExercise) {
            this.id = weightLossExercise.id;
            this.weightLossExercise_Name = weightLossExercise.weightLossExercise_Name;
            this.weightLossExercise_Amount = weightLossExercise.weightLossExercise_Amount;
            this.weightLossExercise_Reps = weightLossExercise.weightLossExercise_Reps;
            this.weightLossExercise_Date = weightLossExercise.weightLossExercise_Date;
            return this;
        }
        public WeightLossExercise build(){
            return new WeightLossExercise(this);
        }
    }

    @Override
    public int compareTo(WeightLossExercise weightLossExercise) {
        return id.compareTo(weightLossExercise.id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WeightLossExercise that = (WeightLossExercise) o;

        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "WeightLossExercise{" +
                "id='" + id + '\'' +
                ", weightLossExercise_Name='" + weightLossExercise_Name + '\'' +
                ", weightLossExercise_Amount='" + weightLossExercise_Amount + '\'' +
                ", weightLossExercise_Reps='" + weightLossExercise_Reps + '\'' +
                ", weightLossExercise_Date='" + weightLossExercise_Date + '\'' +
                '}';
    }
}
