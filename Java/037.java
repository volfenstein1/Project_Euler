import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Problem037 {

    private static boolean[] isPrimeSieve;
    private static int SIEVE_LIMIT = 1000000; // Sufficient for this problem

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

    public static boolean isTruncatablePrime(int n) {
        String s = String.valueOf(n);
        int length = s.length();

        // Check left truncations
        for (int i = 1; i < length; i++) {
            if (!isPrime(Integer.parseInt(s.substring(i)))) {
                return false;
            }
        }

        // Check right truncations
        for (int i = 1; i < length; i++) {
            if (!isPrime(Integer.parseInt(s.substring(0, length - i)))) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        sievePrimes();

        long sumOfTruncatablePrimes = 0;
        int count = 0;

        // Start checking from 10, as single-digit primes are not considered truncatable
        for (int i = 10; i < SIEVE_LIMIT; i++) {
            if (isPrime(i) && isTruncatablePrime(i)) {
                sumOfTruncatablePrimes += i;
                count++;
                if (count == 11) {
                    break;
                }
            }
        }
        System.out.println(sumOfTruncatablePrimes);
    }
}
