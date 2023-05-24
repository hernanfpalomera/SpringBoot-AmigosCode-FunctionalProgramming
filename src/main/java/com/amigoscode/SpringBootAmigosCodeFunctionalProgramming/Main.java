package com.amigoscode.SpringBootAmigosCodeFunctionalProgramming;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Person> people = List.of(
                new Person("John", Gener.MALE),
                new Person("Maria",Gener.FEMALE),
                new Person("Aisha",Gener.FEMALE),
                new Person("Alex",Gener.MALE),
                new Person("Alice",Gener.FEMALE)
        );

        //Imperative Approach

        System.out.println("//Imperative Approach");
        List<Person> females = new ArrayList<>();

        for (Person person: people){
            if(Gener.FEMALE.equals(person.gender)){
                females.add(person);
            }
        }

        for (Person female: females){
            System.out.println(female);
        }

        //Declarative approach
        System.out.println("//Declarative approach");
//        people.stream()
//                .filter(person -> Gener.FEMALE.equals(person.gender))
//                .collect(Collectors.toList())
//                .forEach(System.out::println);

        Predicate<Person> personPredicate = person -> Gener.FEMALE.equals(person.gender);

        List<Person> females2 = people.stream()
                .filter(personPredicate)
                .collect(Collectors.toList());

        females2.forEach(System.out::println);


    }


    static class Person {
        private final String name;
        private final Gener gender;

        public Person(String name, Gener gender) {
            this.name = name;
            this.gender = gender;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", gender=" + gender +
                    '}';
        }
    }

    enum Gener {
        MALE, FEMALE
    }
}
