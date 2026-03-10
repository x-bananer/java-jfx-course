package module_8_3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PersonDemo {
    public static void main(String[] args) {

        List<Person> people = new ArrayList<>();

        people.add(new Person("Anna", 25, "New York"));
        people.add(new Person("Maria", 30, "London"));

        Collections.sort(people, (p1, p2) -> p1.age - p2.age);

        people.removeIf(p -> !p.city.equals("New York"));

        for (Person p : people) {
            System.out.println(p);
        }
    }
}