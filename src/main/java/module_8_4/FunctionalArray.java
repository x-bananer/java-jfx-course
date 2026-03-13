package module_8_4;

import java.util.Arrays;

public class FunctionalArray {
    public static void main(String[] args) {

        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        double mean = Arrays.stream(numbers).average().orElse(0);

        System.out.println(mean);
    }
}