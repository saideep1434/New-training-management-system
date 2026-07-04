package com.saideep.trainingmanagementsystem.service;

import com.saideep.trainingmanagementsystem.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository UR;

    public UserService(UserRepository user)
    {
        this.UR = user;
    }




}
