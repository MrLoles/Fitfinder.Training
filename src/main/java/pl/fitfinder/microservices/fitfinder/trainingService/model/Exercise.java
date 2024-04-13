package pl.fitfinder.microservices.fitfinder.trainingService.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Exercise {
    @JsonIgnore
    @Id
    @GeneratedValue
    private int id;

    @Size(min = 3, message = "Exercise name should have at least 3 characters!")
    private String name;

    @Size(min = 1, message = "Sets name should have at least 1 character!")
    private String sets;

    @Size(min = 1, message = "reps should have at least 1 characters!")
    private String reps;

    @Size(min = 2, message = "weights should have at least 3 characters!")
    private String weights;

    private String rest;

    @ManyToOne
    @JoinColumn(name = "training_id")
    @JsonIgnore
    private Training training;
}
