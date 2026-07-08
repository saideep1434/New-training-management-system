package com.saideep.trainingmanagementsystem.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CreateUserRequest{

    @NotBlank(message = " First Name is Required")
    private String firstName;
    @NotBlank(message = " Last Name is Required")
    private String lastName;
    @NotBlank(message = "email is Required")
    @Email(message = "Enter a valid email")
    private String email;
    @NotBlank(message = "Password is Required")
    @Size(min = 6 , message = "Password must contain at least 6 characters")
    private String password;
    @NotBlank(message = "Phonenumber is Required")
    private String phoneNumber;

    public CreateUserRequest()
    {
        //default constructor
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
