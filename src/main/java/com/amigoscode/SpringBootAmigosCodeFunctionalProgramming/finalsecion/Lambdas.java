package com.amigoscode.SpringBootAmigosCodeFunctionalProgramming.finalsecion;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Lambdas {


    public static void main(String[] args) {

        System.out.println(upperCaseNameBiFunction.apply("Alex",19));
    }


    private static final Function<String, String> upperCaseNameFunction = name -> name.toUpperCase();
    private static final Function<String, String> upperCaseNameFunction2 = name -> {

        if (name.isBlank()) throw  new IllegalStateException("");
        return name.toUpperCase();
    };

    private static final BiFunction<String,Integer, String> upperCaseNameBiFunction =(name, age) -> {

        if (name.isBlank()) throw  new IllegalStateException("");
        System.out.println(age);
        return name.toUpperCase();
    };
}
