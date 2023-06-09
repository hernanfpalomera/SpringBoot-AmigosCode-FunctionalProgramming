package com.amigoscode.SpringBootAmigosCodeFunctionalProgramming.functionalinterface;

import java.util.function.BiFunction;
import java.util.function.Function;

public class _Function {

    public static void main(String[] args) {

        // Function takes 1 argument and produces 1 result
        int increment = incrementByOne(1);
        System.out.println("incrementByOne: "+ increment);

        Integer increment2 = incrementByOneFunction.apply(1);

        System.out.println("incrementByOneFunction: "+increment2);

        Integer multiply = multiplyBy10Function.apply(increment2);

        System.out.println("multipluBy10Function: " + multiply);

        Function<Integer, Integer> addBy1AndThenMultiplyBy10 =
                incrementByOneFunction.andThen(multiplyBy10Function);

        System.out.println("addBy1AndThenMultiplyBy10: "+ addBy1AndThenMultiplyBy10.apply(1));


        // BiFunction takes 2 argument and produces 1 result

        System.out.println("incrementByOneAndMultiply: "+ incrementByOneAndMultiply(4,100));


        System.out.println("incrementByOneAndMultiplyBiFunction: "+ incrementByOneAndMultiplyBiFunction.apply(4,100));

    }




    static Function<Integer,Integer> incrementByOneFunction =
            number -> number +1;

    static Function<Integer,Integer> multiplyBy10Function =
            number -> number *10;

    static int incrementByOne(int number){
        return number + 1;
    }

    static BiFunction<Integer, Integer, Integer> incrementByOneAndMultiplyBiFunction = (numberToIncrementByOne, numberToMultiplyBy)
            -> (numberToIncrementByOne + 1) * numberToMultiplyBy;

    static int incrementByOneAndMultiply(int number, int numToMultiply){
        return (number+1) * numToMultiply;
    }
}
