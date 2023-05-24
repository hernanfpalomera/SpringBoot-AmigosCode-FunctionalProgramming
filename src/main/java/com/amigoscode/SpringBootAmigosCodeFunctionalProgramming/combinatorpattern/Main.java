package com.amigoscode.SpringBootAmigosCodeFunctionalProgramming.combinatorpattern;

import java.time.LocalDate;

public class Main {


    public static void main(String[] args) throws IllegalAccessException {
        Customer customer = new Customer(
                "Alice",
                "alicegmail.com",
                "+023412434234",
                LocalDate.of(2000,1,1));

        System.out.println(new CustomerValidatorService().isValid(customer));

        //TODO If is valid we can store id on DB

        //Using combinator pattern
        CustomerRegistrationValidator.ValidationResult result =
                CustomerRegistrationValidator
                        .isEmailValid()
                        .and(CustomerRegistrationValidator.isPhoneNumberValid())
                        .and(CustomerRegistrationValidator.isAnAdult()).apply(customer);

        //System.out.println(result);

        if (result != CustomerRegistrationValidator.ValidationResult.SUCCESS){
                throw  new IllegalAccessException(result.name());
        }

    }
}
