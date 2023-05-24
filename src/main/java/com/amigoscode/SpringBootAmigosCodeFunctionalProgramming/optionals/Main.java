package com.amigoscode.SpringBootAmigosCodeFunctionalProgramming.optionals;

import java.util.Optional;

public class Main {

    public static void main(String[] args) {
        Object value = Optional.ofNullable("Hello").orElseGet(() -> "default value");
        Object value2 = Optional.ofNullable("Hello").orElseThrow(() -> new IllegalStateException("Exception"));
        Optional.ofNullable("john@gmail.com").ifPresent(System.out::println);
        Optional.ofNullable("john@gmail.com").ifPresent(email -> System.out.println("Sending email to " + email));
        Optional.ofNullable(null)
                .ifPresentOrElse(email -> System.out.println("Sending email to " + email),
                        () -> System.out.println("Cannot send email"));

        System.out.println(value);
    }
}
