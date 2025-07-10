import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem087 {

    public static List<Integer> sieveOfEratosthenes(int limit) {
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

        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= limit; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }
        return primes;
    }

    public static void main(String[] args) {
        int bound = 50_000_000;
        List<Integer> primes = sieveOfEratosthenes(7100); // Sieve up to sqrt(50,000,000)

        Set<Long> expressableNumbers = new HashSet<>();

        for (int prime4 : primes) {
            long term4 = (long) prime4 * prime4 * prime4 * prime4;
            if (term4 >= bound) {
                break;
            }
            for (int prime3 : primes) {
                long term3 = (long) prime3 * prime3 * prime3;
                if (term3 >= bound) {
                    break;
                }
                for (int prime2 : primes) {
                    long term2 = (long) prime2 * prime2;
                    if (term2 >= bound) {
                        break;
                    }

                    long n = term2 + term3 + term4;
                    if (n < bound) {
                        expressableNumbers.add(n);
                    }
                }
            }
        }
        System.out.println(expressableNumbers.size());
    }
}
