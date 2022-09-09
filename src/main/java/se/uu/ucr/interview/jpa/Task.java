package se.uu.ucr.interview.jpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String description;
    private String fieldStatus;

    protected Task() {};

    public Task(String description, String fieldStatus) {
        this.description = description;
        this.fieldStatus = fieldStatus;
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    // Add here a getter for fieldstatus
    public String getFieldStatus() { return fieldStatus; }
}
