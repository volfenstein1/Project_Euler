import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem051 {

    private static Set<Integer> primesSet;

    public static void sieveOfEratosthenes(int limit) {
        boolean[] isPrime = new boolean[limit + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        for (int p = 2; p * p <= limit; p++) {
            if (isPrime[p]) {
                for (int i = p * p; i <= limit; i += p) {
                    isPrime[i] = false;
                }
            }
        }

        primesSet = new HashSet<>();
        for (int i = 2; i <= limit; i++) {
            if (isPrime[i]) {
                primesSet.add(i);
            }
        }
    }

    public static boolean digitReplace(int n) {
        String s = String.valueOf(n);
        Set<Character> uniqueDigits = new HashSet<>();
        for (char c : s.toCharArray()) {
            uniqueDigits.add(c);
        }

        for (char digitToReplace : uniqueDigits) {
            int primeCount = 0;
            for (int i = 0; i <= 9; i++) {
                char replacementDigit = Character.forDigit(i, 10);
                String tempS = s.replace(digitToReplace, replacementDigit);

                // Check for leading zero and length change
                if (tempS.length() != s.length()) {
                    continue;
                }

                int num = Integer.parseInt(tempS);
                if (primesSet.contains(num)) {
                    primeCount++;
                }
            }
            if (primeCount == 8) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int limit = 10_000_000;
        sieveOfEratosthenes(limit);

        for (int prime : primesSet) {
            // Skip single-digit primes as they cannot form families by replacing digits
            if (prime < 10) {
                continue;
            }
            if (digitReplace(prime)) {
                System.out.println(prime);
                break; // Found the smallest
            }
        }
    }
}
