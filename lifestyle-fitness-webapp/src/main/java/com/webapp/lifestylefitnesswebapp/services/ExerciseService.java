package com.webapp.lifestylefitnesswebapp.services;


import com.webapp.lifestylefitnesswebapp.dao.exerciseRepo;
import com.webapp.lifestylefitnesswebapp.entities.Exercise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExerciseService {
    @Autowired
    exerciseRepo exRepo;

    public Exercise saveExercise(Exercise exercise){
        return exRepo.save(exercise);
    }

    public List<Exercise> getAllExercise(){
        //create exception types for null and empty arrays.
        return exRepo.findAll();
    }
    public Optional<Exercise> findByExerciseId(@NonNull Long exerciseId){
        return  exRepo.findByExerciseId(exerciseId);
    }

    public void  deleteExercise(Exercise exercise){
        exRepo.delete(exercise);
    }


}
