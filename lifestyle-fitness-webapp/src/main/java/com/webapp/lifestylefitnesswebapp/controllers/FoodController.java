package com.webapp.lifestylefitnesswebapp.controllers;


import com.webapp.lifestylefitnesswebapp.entities.Food;
import com.webapp.lifestylefitnesswebapp.services.FoodService;
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
@RequestMapping("/food")
public class FoodController {

    @Autowired
    FoodService foodService;

    @GetMapping
    //this method implementation will be just to list all of them. the next will be based on timeDate.
    public String displayFoods(Model model){
        List<Food> foodList= foodService.getAllFood();
        model.addAttribute("foods",foodList);
        return "food/food-home";
    }


    @GetMapping("/new")
    public String addNewFood(Model model){
        Food newFood= new Food();
        model.addAttribute("food",newFood);
        return "food/new-food";
    }

    @PostMapping("/new")
    public String saveNewFood(Model model, Food food, Errors errors){
        if(errors.hasErrors()){
            return "food/new-food";
        }
        foodService.saveFood(food);
        return "redirect:/food/new";
    }

    @GetMapping("/update")
    public String updateFood(@RequestParam("id") Long foodId,Model model){
        Food food=foodService.findByFoodId(foodId);
        model.addAttribute("food",food);
        return "food/new-food";
    }

    @GetMapping("delete")
    public String deleteFood(@RequestParam("id") Long foodId, Model model){
        Food food= foodService.findByFoodId(foodId);
        foodService.deleteFood(food);
        return "redirect:/food/new";
    }




    //for the get Total use a generic method so that the we can reduce the amount of things needed.


}
