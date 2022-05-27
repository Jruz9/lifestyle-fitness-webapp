package com.webapp.lifestylefitnesswebapp.entities;

public class exercise {
    enum exerciseType {
        strength,aerobic
    }

    private Integer sets;
    private Integer reps;
    private Double time;
    private Double speed;

    private String exerciseForm; //just the type of exercise the person classifies it as.

    private String exerciseName;


}

