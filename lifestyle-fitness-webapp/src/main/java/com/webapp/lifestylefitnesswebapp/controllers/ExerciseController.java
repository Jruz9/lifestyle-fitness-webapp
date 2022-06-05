package com.webapp.lifestylefitnesswebapp.controllers;


import com.webapp.lifestylefitnesswebapp.entities.Exercise;
import com.webapp.lifestylefitnesswebapp.services.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/exercise")
public class ExerciseController {

    @Autowired
    ExerciseService exerciseService;

    @GetMapping
    public String displayExercise(Model model) {
        List<Exercise> exerciseList = exerciseService.getAllExercise();
        model.addAttribute("exercise", exerciseList);
        return "exercise/exercise-home";
    }

    @GetMapping("/exercise")
    public String addNewExercise(Model model) {
        Exercise newExercise = new Exercise();
        model.addAttribute("exercise", newExercise);
        return "exercise/new-exercise";
    }



    @PostMapping("/new")
    public String saveNewExercise(Model model, Exercise exercise, Errors errors){
        if(errors.hasErrors()){
            return "exercise/new-exercise";
        }
        exerciseService.saveExercise(exercise);

        return "redirect:/exercise/new";
    }

    public String updateExercise(@RequestParam("id") Long exerciseId,Model model){
        Exercise exercise =exerciseService.findByExerciseId(exerciseId);
        model.addAttribute("exercise",exercise);
        return "exercise/new-exercise";
    }

public  String  deleteExercise(@RequestParam("id") Long exerciseId,Model model){
        Exercise exercise= exerciseService.findByExerciseId(exerciseId);
        exerciseService.deleteExercise(exercise);
        return "redirect:/exercise/new";
}



}
