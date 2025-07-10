import java.util.HashSet;
import java.util.Set;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem032 {

    // Helper function to check if a string contains unique digits from 1 to 9
    public static boolean containsUniqueDigits1to9(String s) {
        if (s.length() != 9) {
            return false;
        }
        Set<Character> digits = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (c == '0' || digits.contains(c)) {
                return false; // Contains 0 or duplicate digit
            }
            digits.add(c);
        }
        return digits.size() == 9;
    }

    // Helper function to get divisor pairs of a number
    public static List<int[]> getDivisorPairs(int n) {
        List<int[]> pairs = new ArrayList<>();
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                pairs.add(new int[]{i, n / i});
            }
        }
        return pairs;
    }

    public static void main(String[] args) {
        Set<Integer> pandigitalProducts = new HashSet<>();

        // The problem states that the multiplicand, multiplier, and product
        // together form a 1-9 pandigital number. This means the total number of digits must be 9.
        // The only combination of digit counts that works is (2-digit * 3-digit = 4-digit product)
        // or (1-digit * 4-digit = 4-digit product). In both cases, the product is a 4-digit number.

        // Iterate through possible products (n) that are 4-digit numbers.
        // The smallest 4-digit number using unique digits 1-9 is 1234.
        // The largest 4-digit number using unique digits 1-9 is 9876.
        for (int n = 1234; n <= 9876; n++) {
            // Check if the digits of 'n' itself are unique and from 1-9 (no '0')
            String s_n = String.valueOf(n);
            Set<Character> n_digits = new HashSet<>();
            boolean n_has_zero_or_duplicate = false;
            for (char c : s_n.toCharArray()) {
                if (c == '0' || n_digits.contains(c)) {
                    n_has_zero_or_duplicate = true;
                    break;
                }
                n_digits.add(c);
            }
            if (n_has_zero_or_duplicate) {
                continue;
            }

            // Find divisor pairs (a, b) for n
            List<int[]> divisorPairs = getDivisorPairs(n);

            for (int[] pair : divisorPairs) {
                int a = pair[0];
                int b = pair[1];

                // Check if a, b, and n together form a 1-9 pandigital number
                if (containsUniqueDigits1to9(String.valueOf(a) + String.valueOf(b) + String.valueOf(n))) {
                    pandigitalProducts.add(n);
                }
            }
        }

        long sum = 0;
        for (int product : pandigitalProducts) {
            sum += product;
        }
        System.out.println(sum);
    }
}
