package com.examly.springapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.springapp.model.User;
import com.examly.springapp.model.Workout;
import com.examly.springapp.repository.UserRepo;
import com.examly.springapp.repository.WorkoutRepo;

@Service
public class UserService {
    
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private WorkoutRepo workoutRepo;

    public boolean createUser(User user){
       this.userRepo.save(user);
       return true;
    }

    public boolean createWorkout(Workout workout){
        this.workoutRepo.save(workout);
        return true;
    }
    
    public User getUserWithWorkoutById(int id) {
        User user = userRepo.findById(id).orElse(null);
        if (user != null) {
            user.getWorkout();
        }
        return user;
    }
    
    public List<Workout> getAllWorkout(){
       List<Workout> list=(List<Workout>) this.workoutRepo.findAll();
       return list;
    }
    

}
