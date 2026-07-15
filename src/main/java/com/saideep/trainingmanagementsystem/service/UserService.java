package com.saideep.trainingmanagementsystem.service;

import com.saideep.trainingmanagementsystem.dto.CreateUserRequest;
import com.saideep.trainingmanagementsystem.dto.CreateUserResponse;
import com.saideep.trainingmanagementsystem.entity.Users;
import com.saideep.trainingmanagementsystem.enums.Role;
import com.saideep.trainingmanagementsystem.exception.UserNotFoundException;
import com.saideep.trainingmanagementsystem.repository.UserRepository;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository UR;

    public UserService(UserRepository user)
    {
        this.UR = user;
    }

//    public Users CreateUser(Users user)
//    {
//        return UR.save(user);
//    }

//    public Users CreateUser(CreateUserRequest request)
//    {
//        Users user = new Users();
//
//        user.setFirstName(request.getFirstName());
//        user.setLastName(request.getLastName());
//        user.setEmail(request.getEmail());
//        user.setPassword(request.getPassword());
//        user.setPhoneNumber(request.getPhoneNumber());
//
//        user.setRole(Role.TRAINEE);
//        user.setActive(true);
//
//        return UR.save(user);
//
//
//    }

    public CreateUserResponse CreateUser(CreateUserRequest request)
    {
        Users user = new Users();

        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setPhoneNumber(request.getPhoneNumber());

        user.setRole(Role.TRAINEE);
        user.setActive(true);

        Users savedusers = UR.save(user);

        CreateUserResponse response = new CreateUserResponse();

        response.setId(savedusers.getId());
        response.setFirstname(savedusers.getFirstName());
        response.setLastname(savedusers.getLastName());
        response.setEmail(savedusers.getEmail());

        return  response;
    }

    public CreateUserResponse finduserbyid(long id)
    {
        Optional<Users> optionaluser = UR.findById(id);

        Users finduser;

        if(optionaluser.isPresent())
        {
            finduser = optionaluser.get(); // this line tells that okay optionaluser.get() means gives all the users inside optional box
            // and stored in finduser reference variable ;
        }
        else
        {
            throw new UserNotFoundException("User with id " + id + " not found");
        }



        CreateUserResponse response = new CreateUserResponse();

        response.setId(finduser.getId());
        response.setFirstname(finduser.getFirstName());
        response.setLastname(finduser.getLastName());
        response.setEmail(finduser.getEmail());

        return response;

    }

}
