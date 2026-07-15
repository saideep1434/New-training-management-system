package com.saideep.trainingmanagementsystem.exception;

public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException(String message)
    {
        super(message);
    }

}

//* lets understand what internally happening lest say now we have parent class RuntimeException

//public class RuntimeException()
//{
//    Private String message;
//
//    public RuntimeException()
//    {
//
//    }
//
//    public RuntimeException(String message)
//    {
//        this.message = message;
//    }
//
//    public String getmessage()
//    {
//        return message;
//    }

//so now usernotfoundexception no need to create message variable and constructor or getmessage() method
//already parent class has it just use those so now super(message) is used to call the parent constructor
//now parent constructor executes stores the message and returns through getmessage();


