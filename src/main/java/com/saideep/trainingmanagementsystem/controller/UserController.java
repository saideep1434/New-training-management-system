package com.saideep.trainingmanagementsystem.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.saideep.trainingmanagementsystem.dto.CreateUserRequest;
import com.saideep.trainingmanagementsystem.dto.CreateUserResponse;
import com.saideep.trainingmanagementsystem.entity.Users;
import com.saideep.trainingmanagementsystem.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.apache.catalina.connector.Request;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLOutput;


@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService US;

    public UserController(UserService user)
    {
        this.US = user;
    }

//    @PostMapping("/add-user")
//    public Users CreateUser(@RequestBody Users user)
//    {
//       return US.CreateUser(user);
//    }
//    @PostMapping("/add-user")
//    public Users CreateUser(@RequestBody CreateUserRequest request)
//    {
//        return US.CreateUser(request);
//    }

    @PostMapping("/add-user")
    public CreateUserResponse CreateUser( @Valid @RequestBody CreateUserRequest request)
    {
        return US.CreateUser(request);
    }

    @GetMapping("/{id}")
    public CreateUserResponse finduserbyid(@PathVariable long id)
    {
        return US.finduserbyid(id);
    }



}
