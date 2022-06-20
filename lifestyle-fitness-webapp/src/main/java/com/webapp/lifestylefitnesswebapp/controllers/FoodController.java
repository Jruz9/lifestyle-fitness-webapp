package com.webapp.lifestylefitnesswebapp.controllers;


import com.webapp.lifestylefitnesswebapp.entities.Food;
import com.webapp.lifestylefitnesswebapp.services.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1")
public class FoodController {

    private static final String FOOD_NOT_FOUND_ERROR_MESSAGE = "Could not find the food with ID %d";

    @Autowired
    FoodService foodService;


    //change the whole system to use the react way of handling the data with the api.


    @GetMapping("/foods")
    //this method implementation will be just to list all of them. the next will be based on timeDate.
    public List<Food> displayFoods(){
        return foodService.getAllFood();
    }


    @PostMapping("/foods")
    public Food addNewFood(@RequestBody Food food){
        return foodService.saveFood(food);
    }


    @GetMapping("/foods/{id}")
    public ResponseEntity<Food> getFoodById(@PathVariable("id") Long foodId){
        Food food= foodService.findByFoodId(foodId)
                .orElseThrow(
                        () -> new ResponseStatusException(
                                HttpStatus.NOT_FOUND,String.format(FOOD_NOT_FOUND_ERROR_MESSAGE,foodId)
                        )
                );
        return ResponseEntity.ok(food);

    }




    @PutMapping("/foods/{id}")
    public Food updateFood(@PathVariable("id") Long foodId, @RequestBody Food foodDetails){
        final Food foodToUpdate=
                foodService.findByFoodId(foodId)
                .orElseThrow(()->new ResponseStatusException
                        (HttpStatus.NOT_FOUND,String.format(FOOD_NOT_FOUND_ERROR_MESSAGE,foodId)));

        foodToUpdate.setFoodName(foodDetails.getFoodName());
        foodToUpdate.setCalorie(foodDetails.getCalorie());
        foodToUpdate.setProtein(foodDetails.getProtein());
        foodToUpdate.setCarbs(foodDetails.getCarbs());
        foodToUpdate.setSugar(foodDetails.getSugar());
        foodToUpdate.setFat(foodDetails.getFat());

        return foodService.updateFoodInformation(foodToUpdate);
    }

    @DeleteMapping("/foods/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> deleteFood(@PathVariable("id") Long foodId){
        Optional<Food> foodToDelete= foodService.findByFoodId(foodId);
        //is empty is a java 11 feature so the opposite of present is put here.
        if(!foodToDelete.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(String.format(FOOD_NOT_FOUND_ERROR_MESSAGE,foodId));
        }

        foodService.deleteFood(foodToDelete.get());
        return ResponseEntity.status(HttpStatus.OK).body("Deleted");
    }




    //for the get Total use a generic method so that the we can reduce the amount of things needed.


}
