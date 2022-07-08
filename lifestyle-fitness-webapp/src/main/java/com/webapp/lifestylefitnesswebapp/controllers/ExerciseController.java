package com.webapp.lifestylefitnesswebapp.controllers;


import com.webapp.lifestylefitnesswebapp.entities.Exercise;
import com.webapp.lifestylefitnesswebapp.services.ExerciseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1")
public class ExerciseController {

    @Autowired
    private ExerciseService exerciseService;

    private static final String EXERCISE_NOT_FOUND_ERROR_MESSAGE = "Could not find the exercise with ID %d";
    private final Logger log = LoggerFactory.getLogger(ExerciseController.class);


    //get all food on your list
    @GetMapping("/exercise")
    public List<Exercise> displayExercise() {
        return exerciseService.getAllExercise();
    }

    @PostMapping("/exercise")
    public Exercise addNewExercise(@RequestBody Exercise exercise) {
        log.info("Request to create new exercise : {}", exercise);
        return  exerciseService.saveExercise(exercise);
    }

    @GetMapping("/exercise/{id}")
    public ResponseEntity<Exercise> getExerciseById(@PathVariable("id") Long exerciseId){
        Exercise exercise= exerciseService.findByExerciseId(exerciseId)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,String.format(EXERCISE_NOT_FOUND_ERROR_MESSAGE,exerciseId)
                )
                );
        return ResponseEntity.ok(exercise);
    }

    @PutMapping("/exercise/{id}")
    public Exercise updateExercise(@PathVariable("id") Long exerciseId, @RequestBody Exercise exerciseUpdate){
        log.info("Request to  update existing exercise {}",exerciseUpdate);
        final Exercise exerciseToUpdate =
                exerciseService.findByExerciseId(exerciseId)
                .orElseThrow(() -> new ResponseStatusException
                        (HttpStatus.NOT_FOUND,String.format(EXERCISE_NOT_FOUND_ERROR_MESSAGE,exerciseId)));

        exerciseToUpdate.setExerciseName(exerciseUpdate.getExerciseName());
        exerciseToUpdate.setSets(exerciseUpdate.getSets());
        exerciseToUpdate.setReps(exerciseUpdate.getReps());
        exerciseToUpdate.setTime(exerciseUpdate.getTime());
        exerciseToUpdate.setSpeed(exerciseUpdate.getSpeed());
        exerciseToUpdate.setExerciseForm(exerciseUpdate.getExerciseForm());

        return exerciseService.saveExercise(exerciseToUpdate); //will need to be changed in the future since the update is not technically a update
    }
    @DeleteMapping("/exercise/{id}]")
    @ResponseStatus(HttpStatus.OK)
public  ResponseEntity<String>  deleteExercise(@PathVariable("id") Long exerciseId){
        log.info("Request to delete exercise : {}",exerciseId);
        Optional<Exercise> exerciseToDelete = exerciseService.findByExerciseId(exerciseId);
        if (!exerciseToDelete.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(String.format(EXERCISE_NOT_FOUND_ERROR_MESSAGE,exerciseId));
        }
        exerciseService.deleteExercise(exerciseToDelete.get());
        return ResponseEntity.status(HttpStatus.OK).body("Deleted");

    }



}
