package com.saideep.trainingmanagementsystem.service;

import com.saideep.trainingmanagementsystem.entity.Users;
import com.saideep.trainingmanagementsystem.repository.UserRepository;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class UserService {
    ObjectMapper mapper = new ObjectMapper();

    private final UserRepository UR;

    public UserService(UserRepository user)
    {
        this.UR = user;
    }

    public Users CreateUser(Users user)
    {
        return UR.save(user);
    }
    
}
