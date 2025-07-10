import java.util.ArrayList;
import java.util.List;

public class Problem007 {

    /**
     * Find the first x prime numbers.
     */
    public static List<Long> findPrimes(int x) {
        List<Long> primes = new ArrayList<>();
        long y = 2;
        while (primes.size() < x) {
            boolean isPrime = true;
            for (long prime : primes) {
                if (y % prime == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                System.out.println("Prime found: " + y);
                primes.add(y);
            }
            y++;
        }
        return primes;
    }

    public static void main(String[] args) {
        int x = 10001;
        List<Long> primes = findPrimes(x);
        System.out.println(x + "st prime: " + primes.get(x - 1));
    }
}
