package org.example;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;
import org.example.StreamUtilsNoExample.*;

public class Main {
    public static void main(String[] args) {
        List<Person> people = createPeople();
        // people = StreamUtils.filterAndTransform
        Function<Person, Person> grantBonus = person -> {
            person.addBalance(1000.0);
            return person;
        };

        people = StreamUtilsNoExample.filterAndTransform(people.stream(),
                                                         new Person("A", 20, 100),
                                                         new Person("B", 40, 100),
                                                         grantBonus);
        printPeople(people);
    }

    public static List<Person> createPeople() {
        return List.of(new Person("Alex", 5, 10),
                       new Person("John", 10, 20),
                       new Person("Nina", 21, 200),
                       new Person("Justin", 24, 150),
                       new Person("Jasmin", 34, 550),
                       new Person("Jack", 43, 700),
                       new Person("Kay", 60, 1000));
    }

    public static void printPeople(List<Person> people) {
        for(Person p: people) {
            System.out.println(p.getName() + " is " + p.getAge() + " years old and has " + p.getAccount() + " euros.");
        }
    }
}
