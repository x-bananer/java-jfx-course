package module_8_4;

import java.util.Arrays;
import java.util.List;

public class ListOfNumbers {
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(3, 22, 76, 12, 35, 9, 37);

        int sum = numbers.stream()
                .filter(n -> n % 2 != 0)
                .map(n -> n * 2)
                .mapToInt(Integer::intValue)
                .sum();

        System.out.println(sum);
    }
}