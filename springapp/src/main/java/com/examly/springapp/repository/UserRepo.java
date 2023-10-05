package com.examly.springapp.repository;

import org.springframework.data.repository.CrudRepository;

import com.examly.springapp.model.User;


public interface UserRepo extends CrudRepository<User,Integer> {
    
}
