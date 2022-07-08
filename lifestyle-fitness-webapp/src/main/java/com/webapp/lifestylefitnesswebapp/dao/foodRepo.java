package com.webapp.lifestylefitnesswebapp.dao;

import com.webapp.lifestylefitnesswebapp.entities.Food;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
// keep the paging and sorting due to jpa repo causing you to manually put ids.
public interface foodRepo extends PagingAndSortingRepository<Food,Long> {

    @Override
    public List<Food> findAll();

    public Food findByFoodName(String foodName);



    Optional<Food> findByFoodId(@Param("id") long foodId);
}
