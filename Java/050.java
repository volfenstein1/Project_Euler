import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem050 {

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

    public static int findConsecutive(List<Integer> primes, int bound) {
        Set<Integer> primeSet = new HashSet<>(primes);
        long[] runningSum = new long[primes.size() + 1];
        runningSum[0] = 0;
        for (int i = 0; i < primes.size(); i++) {
            runningSum[i + 1] = runningSum[i] + primes.get(i);
        }

        int maxLen = 0;
        int resultPrime = 0;

        for (int i = 0; i < runningSum.length; i++) {
            for (int j = i + 1; j < runningSum.length; j++) {
                long sum = runningSum[j] - runningSum[i];
                int len = j - i;

                if (sum > bound) {
                    break; // Sum exceeds bound, no need to check further for this i
                }

                if (len > maxLen && primeSet.contains((int) sum)) {
                    maxLen = len;
                    resultPrime = (int) sum;
                }
            }
        }
        return resultPrime;
    }

    public static void main(String[] args) {
        int bound = 1_000_000;
        List<Integer> primes = sieveOfEratosthenes(bound);
        int primeSum = findConsecutive(primes, bound);
        System.out.println("Prime which is the sum of the most consecutive primes: " + primeSum);
    }
}
