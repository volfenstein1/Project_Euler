import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Problem035 {

    private static final Set<Integer> primeSet = new HashSet<>();

    public static boolean[] primeSieve(int n) {
        boolean[] sieve = new boolean[n];
        Arrays.fill(sieve, true);
        for (int i = 2; i * i < n; i++) {
            if (sieve[i]) {
                for (int j = i * i; j < n; j += i) {
                    sieve[j] = false;
                }
            }
        }
        return sieve;
    }

    public static boolean circularPrime(int n) {
        String s = String.valueOf(n);
        for (int i = 0; i < s.length(); i++) {
            if (!primeSet.contains(Integer.parseInt(s.substring(i) + s.substring(0, i)))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        boolean[] primes = primeSieve(1_000_000);
        for (int i = 2; i < primes.length; i++) {
            if (primes[i]) {
                primeSet.add(i);
            }
        }

        int res = 0;
        for (int prime : primeSet) {
            if (circularPrime(prime)) {
                res++;
            }
        }
        System.out.println(res);
    }
}
