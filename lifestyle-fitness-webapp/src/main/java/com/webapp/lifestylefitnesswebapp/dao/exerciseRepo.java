package com.webapp.lifestylefitnesswebapp.dao;

import com.webapp.lifestylefitnesswebapp.entities.Exercise;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface exerciseRepo extends PagingAndSortingRepository<Exercise,Long> {


    @Override
    public List<Exercise> findAll();


//    Exercise findByExerciseId( long exerciseId);

    Optional<Exercise> findByExerciseId(@Param("id") long exerciseId);
}
