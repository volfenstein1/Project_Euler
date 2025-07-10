import java.util.Arrays;

public class Problem010 {

    /**
     * Use the Sieve of Eratosthenes to produce all prime numbers from 2 through n.
     * Adapted from the wikipedia pseudocode.
     */
    public static long primeSieve(int n) {
        boolean[] sieve = new boolean[n];
        Arrays.fill(sieve, true);

        for (int i = 2; i * i < n; i++) {
            if (sieve[i]) {
                for (int j = i * i; j < n; j += i) {
                    sieve[j] = false;
                }
            }
        }

        long sum = 0;
        for (int i = 2; i < n; i++) {
            if (sieve[i]) {
                sum += i;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int bound = 2_000_000;
        long sum = primeSieve(bound);
        System.out.println("Sum of primes below two million: " + sum);
    }
}
