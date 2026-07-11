package com.saideep.trainingmanagementsystem.practiceexceptionhandlingwithoutspring;

import java.util.ArrayList;
import java.util.List;

public class MyBindingResult {

    //now if we want to return all the MyFieldError objects we need to return through list so now we use this class to return all the MyFieldError objects

    List<MyFieldError>fieldErrors = new ArrayList<>();//list is an interface it can not create objects so to create an object we need a class which implements this interface which is ArrayList
    //fieldErrors is a List reference, but the actual object in memory is an ArrayList.

   public MyBindingResult()
   {

   }

   public void addError(MyFieldError error)
   {
        this.fieldErrors.add(error);
   }

    public List<MyFieldError> getFieldErrors()
    {
        return fieldErrors;
    }


}