package com.webapp.lifestylefitnesswebapp.dao;

import com.webapp.lifestylefitnesswebapp.entities.Food;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface foodRepo extends PagingAndSortingRepository<Food,Long> {

    @Override
    public List<Food> findAll();

    public Food findByFoodName(String foodName);



    Optional<Food> findByFoodId(@Param("id") long foodId);
}
