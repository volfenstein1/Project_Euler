import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Problem041 {

    // Sieve for primality testing up to a certain limit
    private static boolean[] isPrimeSieve;
    private static int SIEVE_LIMIT = 7654321; // Max 7-digit pandigital number

    public static void sievePrimes() {
        isPrimeSieve = new boolean[SIEVE_LIMIT + 1];
        Arrays.fill(isPrimeSieve, true);
        isPrimeSieve[0] = false;
        isPrimeSieve[1] = false;
        for (int p = 2; p * p <= SIEVE_LIMIT; p++) {
            if (isPrimeSieve[p]) {
                for (int i = p * p; i <= SIEVE_LIMIT; i += p) {
                    isPrimeSieve[i] = false;
                }
            }
        }
    }

    public static boolean isPrime(int n) {
        if (n < 0 || n > SIEVE_LIMIT) {
            // Fallback for numbers outside sieve range, though not expected for this problem
            if (n <= 1) return false;
            if (n <= 3) return true;
            if (n % 2 == 0 || n % 3 == 0) return false;
            for (int i = 5; i * i <= n; i = i + 6) {
                if (n % i == 0 || n % (i + 2) == 0) {
                    return false;
                }
            }
            return true;
        }
        return isPrimeSieve[n];
    }

    public static boolean isPandigital(int n) {
        String s = String.valueOf(n);
        int length = s.length();
        Set<Character> digits = new HashSet<>();

        for (char c : s.toCharArray()) {
            if (c == '0') return false; // Pandigital numbers don't contain 0
            digits.add(c);
        }

        if (digits.size() != length) return false; // Check for unique digits

        for (int i = 1; i <= length; i++) {
            if (!digits.contains(Character.forDigit(i, 10))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        sievePrimes();

        // We only need to check 7-digit pandigital numbers.
        // 9-digit pandigital numbers (1-9) sum of digits is 45, divisible by 3.
        // 8-digit pandigital numbers (1-8) sum of digits is 36, divisible by 3.
        // So, no 9-digit or 8-digit pandigital numbers can be prime.
        // The largest possible pandigital prime must be 7-digit or less.
        // The largest 7-digit pandigital number is 7654321.
        for (int i = 7654321; i >= 1; i--) {
            if (isPandigital(i) && isPrime(i)) {
                System.out.println(i);
                break;
            }
        }
    }
}
