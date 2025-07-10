import java.util.Arrays;

public class Problem027 {

    private static boolean[] isPrimeSieve;
    private static int SIEVE_LIMIT = 2000000;

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
            // For numbers outside the sieve range, perform individual primality test
            // This case should ideally not be hit if SIEVE_LIMIT is chosen appropriately
            // based on the problem constraints.
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

    public static int consecutivePrimes(int a, int b) {
        int n = 0;
        while (true) {
            long val = (long) n * n + (long) a * n + b;
            if (val < 0 || val > SIEVE_LIMIT || !isPrime((int) val)) {
                break;
            }
            n++;
        }
        return n;
    }

    public static void main(String[] args) {
        sievePrimes();

        int maxConsecutivePrimes = 0;
        int productAB = 0;

        for (int a = -999; a < 1000; a++) {
            for (int b = -1000; b <= 1000; b++) {
                // b must be prime (when n=0, n^2 + an + b = b)
                if (b < 0 || !isPrime(b)) {
                    continue;
                }

                int currentConsecutivePrimes = consecutivePrimes(a, b);
                if (currentConsecutivePrimes > maxConsecutivePrimes) {
                    maxConsecutivePrimes = currentConsecutivePrimes;
                    productAB = a * b;
                }
            }
        }
        System.out.println(productAB);
    }
}
