package com.saideep.trainingmanagementsystem.practiceexceptionhandlingwithoutspring;

public class MyValidationException extends Exception {

   private MyBindingResult bindingResult;


   public MyValidationException(MyBindingResult bindingResult)
   {
       this.bindingResult = bindingResult;
   }

   public MyBindingResult getBindingResult()
   {
       return bindingResult;
   }

}