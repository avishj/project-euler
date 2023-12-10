package P0005;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {

    private static int getNextSmallestPrimeFactor(int number) {
        for (int i = 2; i < number; ++i) {
            if (number % i == 0) {
                return i;
            }
        }
        return number;
    }

    private static Map<Integer, Integer> findPrimeFactors(int number) {
        Map<Integer, Integer> factors = new HashMap<>();
        while (true) {
            int smallestFactor = getNextSmallestPrimeFactor(number);
            factors.put(smallestFactor, factors.getOrDefault(smallestFactor, 0) + 1);
            if (smallestFactor == number) {
                break;
            }
            number = number / smallestFactor;
        }
        return factors;
    }

    public static void main(String[] args) {
        Map<Integer, Integer> maximalPrimeFactors = IntStream.range(1, 21)
                .mapToObj(P0005.Solution::findPrimeFactors)
                .flatMap(map -> map.entrySet().stream())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (prev, curr) -> curr > prev ? curr : prev));
        maximalPrimeFactors.entrySet().stream().forEach(System.out::println);
        int smallestEvenlyDivisbleNumber = (int) maximalPrimeFactors.entrySet()
                .stream()
                .mapToDouble(entry -> Math.pow(entry.getKey(), entry.getValue()))
                .reduce(1, (a, b) -> a * b);
        System.out.println("The smallest evenly divisible number is: " + smallestEvenlyDivisbleNumber);
    }
}
