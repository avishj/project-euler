package P0001;

import java.util.stream.IntStream;

public class Solution {
    public static void main(String[] args) {
        int sum = IntStream.range(1, 1000).filter(v -> v % 3 == 0 || v % 5 == 0).sum();
        System.out.println("The sum is: " + sum);
    }
}
