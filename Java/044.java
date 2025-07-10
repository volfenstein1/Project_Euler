import java.util.HashSet;
import java.util.Set;

public class Problem044 {

    // Function to check if a number is pentagonal
    public static boolean isPentagonal(long n) {
        // P_n = n(3n-1)/2
        // 2P_n = 3n^2 - n
        // 3n^2 - n - 2P_n = 0
        // Using quadratic formula: n = (1 +/- sqrt(1 - 4*3*(-2P_n))) / (2*3)
        // n = (1 +/- sqrt(1 + 24P_n)) / 6
        // For n to be an integer, (1 + 24P_n) must be a perfect square, and (1 + sqrt(1 + 24P_n)) must be divisible by 6.
        long discriminant = 1 + 24 * n;
        long sqrtDiscriminant = (long) Math.sqrt(discriminant);

        if (sqrtDiscriminant * sqrtDiscriminant != discriminant) {
            return false; // Not a perfect square
        }

        return (1 + sqrtDiscriminant) % 6 == 0;
    }

    public static void main(String[] args) {
        Set<Long> pentagonalNumbers = new HashSet<>();
        long minD = Long.MAX_VALUE;

        // Generate a sufficient number of pentagonal numbers
        // The problem implies that the numbers are not excessively large.
        // We can iterate and add pentagonal numbers to a set.
        // The upper limit for 'k' can be determined empirically or by analysis.
        // For this problem, a limit of around 3000-4000 for 'k' should be sufficient.
        for (int k = 1; k < 4000; k++) {
            pentagonalNumbers.add((long) k * (3 * k - 1) / 2);
        }

        for (long pj : pentagonalNumbers) {
            for (long pk : pentagonalNumbers) {
                if (pk <= pj) continue; // Ensure Pk > Pj

                long sum = pj + pk;
                long diff = pk - pj;

                if (pentagonalNumbers.contains(sum) && pentagonalNumbers.contains(diff)) {
                    if (diff < minD) {
                        minD = diff;
                    }
                }
            }
        }
        System.out.println(minD);
    }
}
