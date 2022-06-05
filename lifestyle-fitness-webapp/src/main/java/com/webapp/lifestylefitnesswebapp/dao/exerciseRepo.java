package com.webapp.lifestylefitnesswebapp.dao;

import com.webapp.lifestylefitnesswebapp.entities.Exercise;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface exerciseRepo extends PagingAndSortingRepository<Exercise,Long> {


    @Override
    public List<Exercise> findAll();


    Exercise findByExerciseId( long exerciseId);
}
