package module_8_3;

import java.util.ArrayList;
import java.util.List;

public class CollectionOperations {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();

        numbers.add(10);
        numbers.add(5);
        numbers.add(8);
        numbers.add(20);
        numbers.add(15);
        numbers.add(3);
        numbers.add(12);

        System.out.println("Original list: " + numbers);

        numbers.removeIf(n -> n % 2 == 0);

        System.out.println("Only odd numbers: " + numbers);

        numbers.replaceAll(n -> n * 2);

        System.out.println("Doubled odd numbers: " + numbers);

        int sum = 0;

        for (Integer number : numbers) {
            sum += number;
        }

        System.out.println("Sum: " + sum);
    }
}