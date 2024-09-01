package example2;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import org.example.Person;

public class Main {
    public static void main(String[] args) {
        List<Person> people = createPeople();
        // people = CollectionUtils.groupAndApplyFunction
        Function<Person, Boolean> groupkey = person -> {return person.getAge() <= 40;};
        Function<List<Person>, Integer> groupFunction = group -> {return group.stream().mapToInt(Person::getAccount).sum();};

        Map<Boolean, Integer> result = CollectionUtils.groupAndApplyFunction(people, groupkey, groupFunction);

        printResult(result);
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

    public static void printResult(Map<Boolean, Integer> map) {
        for(boolean e: map.keySet()) {
            if(e) {
                System.out.println("Die Gruppe <= 40 hat insgesamt " + map.get(e) + " Euro");
            } else {
                System.out.println("Die Gruppe > 40 hat insgesamt " + map.get(e) + " Euro");
            }
        }
    }
}
