package P0004;

public class Solution {

    private static boolean isPalindrome(int num) {
        int originalNum = num;
        int reversedNum = 0;
        while (num > 0) {
            int digit = num % 10;
            reversedNum = reversedNum * 10 + digit;
            num /= 10;
        }
        return originalNum == reversedNum;
    }

    public static void main(String[] args) {
        int maxProduct = 0;
        for (int first = 999; first >= 100; first--) {
            for (int second = first; second >= 100; second--) {
                int product = first * second;
                if (product <= maxProduct) {
                    break;
                }
                if (isPalindrome(product)) {
                    maxProduct = product;
                }
            }
        }
        System.out.println("The maximal product is: " + maxProduct);
    }
}
