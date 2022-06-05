package com.webapp.lifestylefitnesswebapp.services;


import com.webapp.lifestylefitnesswebapp.dao.exerciseRepo;
import com.webapp.lifestylefitnesswebapp.entities.Exercise;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExerciseService {


    exerciseRepo exRepo;

    public Exercise saveExercise(Exercise exercise){
        return exRepo.save(exercise);
    }

    public List<Exercise> getAllExercise(){
        return (List<Exercise>) exRepo.findAll();
    }
    public Exercise findByExerciseId(Long exerciseId){
        return  exRepo.findByExerciseId(exerciseId);
    }

    public void  deleteExercise(Exercise exercise){
        exRepo.delete(exercise);
    }


}
