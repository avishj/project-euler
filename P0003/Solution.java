package P0003;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    private static long getNextSmallestPrimeFactor(long number) {
        for (long i = 2; i < number; ++i) {
            if (number % i == 0) {
                return i;
            }
        }
        return number;
    }

    public static void main(String[] args) {
        long number = 600851475143L, currentNumber = number;
        List<Long> factors = new ArrayList<>();
        while (true) {
            long smallestFactor = getNextSmallestPrimeFactor(currentNumber);
            factors.add(smallestFactor);
            if (smallestFactor == currentNumber) {
                break;
            }
            currentNumber = currentNumber / smallestFactor;
        }
        System.out.println("The largest prime factor is: " + factors.getLast());
    }
}
