package com.examly.springapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.examly.springapp.model.User;
import com.examly.springapp.model.Workout;
import com.examly.springapp.service.UserService;

@RestController
public class ApiController {
    

    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public boolean handler1(@RequestBody User user){
        return this.userService.createUser(user);
    }

    @PostMapping("/workout")
    public boolean handler2(@RequestBody Workout workout){
        return this.userService.createWorkout(workout);
    }


    @GetMapping("/user/{id}")
    public User handler3(@PathVariable("id")int id){
       return this.userService.getUserWithWorkoutById(id);
    }

    @GetMapping("/workout")
    public List<Workout> handler4(){
        return this.userService.getAllWorkout();
    }
}
