package com.webapp.lifestylefitnesswebapp.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "exercise")
public class Exercise {
    enum exerciseType {
        strength, aerobic
    }

    @Id
    @Column(name = "exercise_id")
    private Long exerciseId;
    @Column(name = "sets")
    private Integer sets;
    @Column(name = "reps")
    private Integer reps;
    @Column(name = "exercise_time")
    private Integer time;

    @Column(name = "speed")
    private Double speed;
    @Column(name = "exercise_name")
        private String exerciseName;

    @Column(name = "exercise_form")
    private String exerciseForm; //just the type of exercise the person classifies it as.


    public Long getExerciseId() {
        return exerciseId;
    }

    public void setExerciseId(Long exerciseId) {
        this.exerciseId = exerciseId;
    }

    public Integer getSets() {
        return sets;
    }

    public void setSets(Integer sets) {
        this.sets = sets;
    }

    public Integer getReps() {
        return reps;
    }

    public void setReps(Integer reps) {
        this.reps = reps;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public Double getSpeed() {
        return speed;
    }

    public void setSpeed(Double speed) {
        this.speed = speed;
    }

    public String getExerciseForm() {
        return exerciseForm;
    }

    public void setExerciseForm(String exerciseForm) {
        this.exerciseForm = exerciseForm;
    }

    public String getExerciseName() {
        return exerciseName;
    }

    public void setExerciseName(String exerciseName) {
        this.exerciseName = exerciseName;
    }
}

