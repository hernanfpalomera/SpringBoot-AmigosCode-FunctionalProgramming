package com.amigoscode.SpringBootAmigosCodeFunctionalProgramming.functionalinterface;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class _Consumer {

    public static void main(String[] args) {

        //Normal Java Function
      Customer maria  = new Customer("Maria", "99999");
      greetCostumer(maria);
      greetCostumerV2(maria, true);
      greetCostumerConsumer.accept(maria);
        greetCostumerBiConsumer.accept(maria,false);

    }

    //Consumer Funtional Interface
    static Consumer<Customer> greetCostumerConsumer  = customer ->
            System.out.println("Hello "+ customer.customerName
            + ", thanks for registering phone number "
            + customer.customerphoneNumber);


    static BiConsumer<Customer,Boolean> greetCostumerBiConsumer  = (customer, showPhoneNumber) ->
            System.out.println("Hello "+ customer.customerName
            + ", thanks for registering phone number "
            + (showPhoneNumber ? customer.customerphoneNumber : "*******"));

    static void greetCostumer(Customer customer){
        System.out.println("Hello "+ customer.customerName
                + ", thanks for registering phone number "
                + customer.customerphoneNumber);
    }
    static void greetCostumerV2(Customer customer, Boolean showPhoneNumber){
        System.out.println("Hello "+ customer.customerName
                + ", thanks for registering phone number "
                + (showPhoneNumber ? customer.customerphoneNumber : "*******"));
    }


    static class Customer{

        private final String customerName;
        private final String customerphoneNumber;

        public Customer(String customerName, String customerphoneNumber) {
            this.customerName = customerName;
            this.customerphoneNumber = customerphoneNumber;
        }
    }
}
