import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem049 {

    private static boolean[] isPrimeSieve;
    private static int SIEVE_LIMIT = 10000; // Max 4-digit number is 9999

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
            // Should not happen for this problem's constraints
            return false;
        }
        return isPrimeSieve[n];
    }

    // Generates all unique permutations of the digits of a number
    public static Set<Integer> getPermutations(int num) {
        Set<Integer> permutations = new HashSet<>();
        char[] digits = String.valueOf(num).toCharArray();
        permute(digits, 0, permutations);
        return permutations;
    }

    private static void permute(char[] arr, int k, Set<Integer> permutations) {
        if (k == arr.length) {
            permutations.add(Integer.parseInt(new String(arr)));
            return;
        }
        for (int i = k; i < arr.length; i++) {
            swap(arr, k, i);
            permute(arr, k + 1, permutations);
            swap(arr, k, i); // backtrack
        }
    }

    private static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        sievePrimes();

        Set<Integer> fourDigitPrimes = new HashSet<>();
        for (int i = 1000; i < 10000; i++) {
            if (isPrime(i)) {
                fourDigitPrimes.add(i);
            }
        }

        // Store results as strings to concatenate later
        List<String> results = new ArrayList<>();

        for (int p1 : fourDigitPrimes) {
            Set<Integer> p1Permutations = getPermutations(p1);
            List<Integer> primePermutations = new ArrayList<>();

            for (int perm : p1Permutations) {
                if (perm >= 1000 && isPrime(perm)) { // Ensure it's a 4-digit prime
                    primePermutations.add(perm);
                }
            }
            Collections.sort(primePermutations);

            // Check for arithmetic sequences
            for (int i = 0; i < primePermutations.size(); i++) {
                for (int j = i + 1; j < primePermutations.size(); j++) {
                    int p_i = primePermutations.get(i);
                    int p_j = primePermutations.get(j);
                    int diff = p_j - p_i;
                    int p_k = p_j + diff;

                    if (p_k < 10000 && isPrime(p_k) && p1Permutations.contains(p_k)) {
                        // Found an arithmetic sequence of 3 primes that are permutations of each other
                        // And ensure it's not the example given in the problem (1487, 4817, 8147)
                        if (p_i != 1487) {
                            results.add(String.valueOf(p_i) + String.valueOf(p_j) + String.valueOf(p_k));
                        }
                    }
                }
            }
        }

        // Print the concatenated 12-digit number
        for (String res : results) {
            System.out.println(res);
        }
    }
}
