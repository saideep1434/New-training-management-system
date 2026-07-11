package com.saideep.trainingmanagementsystem.practiceexceptionhandlingwithoutspring;

public class MyFieldError {

    // here when validation is failed first i need to store the field and the message i need to send back and what i received
    private String field;
    private String message;

    // now we need to store the field and message
    public MyFieldError(String field,String message)
    {
        this.field = field;
        this.message = message;
    }

    public String getField()
    {
        return field;
    }

    public String getMessage()
    {
        return message;
    }

}