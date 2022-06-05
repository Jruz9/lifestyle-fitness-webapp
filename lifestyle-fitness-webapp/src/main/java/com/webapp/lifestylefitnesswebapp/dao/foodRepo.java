package com.webapp.lifestylefitnesswebapp.dao;

import com.webapp.lifestylefitnesswebapp.entities.Food;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface foodRepo extends PagingAndSortingRepository<Food,Long> {

    @Override
    public List<Food> findAll();

    public Food findByFoodName(String foodName);



    Food findByFoodId(long foodId);
}
