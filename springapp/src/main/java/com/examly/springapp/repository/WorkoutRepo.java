package com.examly.springapp.repository;

import org.springframework.data.repository.CrudRepository;

import com.examly.springapp.model.Workout;


public interface WorkoutRepo extends CrudRepository<Workout,Integer>{
    
}
