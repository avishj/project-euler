package P0002;

public class Solution {
    public static void main(String[] args) {
        long sum = 2; // Starts at 2 accounting for the first 2 fibonacci values: 1, 2
        int currentFirst = 1, currentSecond = 2, next = 0;
        while (next <= 4000000) {
            next = currentFirst + currentSecond;
            currentFirst = currentSecond;
            currentSecond = next;
            sum += (next % 2 == 0) ? next : 0;
        }
        System.out.println("The sum is: " + sum);
    }
}
