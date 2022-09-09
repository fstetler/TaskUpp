package se.uu.ucr.interview.jpa;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Task {
    private String id;
    private String description;
    private String fieldStatus;

    protected Task() {};

    public Task(@JsonProperty("id") String id,
                @JsonProperty("description") String description,
                @JsonProperty("fieldStatus") String fieldStatus) {
        this.id = id;
        this.description = description;
        this.fieldStatus = fieldStatus;
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getFieldStatus() { return fieldStatus; }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", fieldStatus='" + fieldStatus + '\'' +
                '}';
    }
}
