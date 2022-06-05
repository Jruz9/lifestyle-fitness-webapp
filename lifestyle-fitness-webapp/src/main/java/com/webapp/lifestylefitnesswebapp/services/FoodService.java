package com.webapp.lifestylefitnesswebapp.services;

import com.webapp.lifestylefitnesswebapp.dao.foodRepo;
import com.webapp.lifestylefitnesswebapp.entities.Food;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodService {

    //save,get all, find food by name or id, delete
    @Autowired
    foodRepo foodRepo;

    public Food saveFood(Food food) {
        return foodRepo.save(food);
    }

    public List<Food> getAllFood() {
        return (List<Food>) foodRepo.findAll();
    }

    public Food findByFoodId(long foodId) {
        //method comes from the dao interface.
        return foodRepo.findByFoodId(foodId);

    }

    public void deleteFood(Food food) {
        foodRepo.delete(food);
    }

}
