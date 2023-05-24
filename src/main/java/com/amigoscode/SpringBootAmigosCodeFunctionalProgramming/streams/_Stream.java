package com.amigoscode.SpringBootAmigosCodeFunctionalProgramming.streams;

import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class _Stream {

    public static void main(String[] args) {

        List<Person> people = List.of(
                new Person("John", Gender.MALE),
                new Person("Maria", Gender.FEMALE),
                new Person("Aisha", Gender.FEMALE),
                new Person("Alex", Gender.MALE),
                new Person("Alice", Gender.FEMALE),
                new Person("Bod", Gender.PREFER_NOT_TO_SAY)
        );


        Set<Gender> genders = people
                .stream()
                .map(person -> person.gender)
                .collect(Collectors.toSet());

        people.stream()
                .map(person -> person.gender)
                .collect(Collectors.toSet())
                .forEach(gender -> System.out.println(gender));


        people.stream()
                .map(person -> person.gender)
                .collect(Collectors.toSet())
                .forEach(System.out::println);

        Predicate<Person> personPredicate = person -> Gender.FEMALE.equals(person.gender);

        boolean containsOnlyFemales = people
                .stream()
                .allMatch(personPredicate);

        boolean notContainsOnlyFemales = people
                .stream()
                .anyMatch(personPredicate);

        System.out.println(containsOnlyFemales);
        System.out.println(notContainsOnlyFemales);


    }


    static class Person {
        private final String name;
        private final Gender gender;

        public Person(String name, Gender gender) {
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

    enum Gender {
        MALE, FEMALE, PREFER_NOT_TO_SAY
    }

}
