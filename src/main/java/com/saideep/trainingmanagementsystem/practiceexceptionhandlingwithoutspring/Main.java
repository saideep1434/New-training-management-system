package com.saideep.trainingmanagementsystem.practiceexceptionhandlingwithoutspring;

public class Main {

    public static void main(String[] args) {

        //create objects for MyFieldError class

        MyFieldError error1 = new MyFieldError("email","invalid email");
        MyFieldError error2 = new MyFieldError("password","Invalid password");

        MyBindingResult result = new MyBindingResult(); // create object for MyBindingResult class

        result.addError(error1);
        result.addError(error2);

        MyValidationException valid  = new MyValidationException(result);

        for (MyFieldError error : valid.getBindingResult().getFieldErrors()) {

            System.out.println("Field   : " + error.getField());
            System.out.println("Message : " + error.getMessage());
            System.out.println();

        }

        //valid
        // │
        // ▼
        //MyValidationException
        // │
        // ▼
        //bindingResult
        // │
        // ▼
        //MyBindingResult
        // │
        // ▼
        //fieldErrors
        // │
        // ▼
        //ArrayList
        // │
        // ├──────────────┐
        // ▼              ▼
        //
        //error1        error2
        // │              │
        // ▼              ▼
        //
        //field         field
        //
        //message       message








    }
}