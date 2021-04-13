package streams;

import imperative.Main;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static streams._Stream.Gender.*;
import static streams._Stream.Gender.MALE;


public class _Stream {
    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("John", MALE),
                new Person("MAria", FEMALE),
                new Person("Aisha", FEMALE),
                new Person("Alex", MALE),
                new Person("Alice", FEMALE),
                new Person("John", PREFER_NOT_TO_SAY)
        );
        people.stream()
                .map(person -> person.name)
                .collect(Collectors.toSet())
                .forEach(name -> System.out.println(name));

        people.stream()
                .map(person -> person.name)
                .mapToInt(String::length)
                .forEach(name -> System.out.println(name));

        Predicate<Person> personPredicate = person -> FEMALE.equals(person.gender);
        boolean containsOnlyFemales = people.stream().anyMatch(personPredicate);
        System.out.println(containsOnlyFemales);

    }
    static class Person {
        private final String name;
        private final Gender gender;

        Person(String name, Gender gender) {
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
