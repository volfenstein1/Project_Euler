public class Problem033 {

    // Function to calculate the greatest common divisor (GCD)
    private static long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // Function to check if a fraction is a "curious fraction"
    private static double getCancelledValue(int numerator, int denominator) {
        // Extract digits
        int num1 = numerator / 10;
        int num2 = numerator % 10;
        int den1 = denominator / 10;
        int den2 = denominator % 10;

        // Trivial cases (e.g., 30/50) are excluded by the problem statement (denominator % 10 != 0)
        // Also, if den2 is 0, it would lead to division by zero in some cases, so we handle it.
        if (num2 == 0 && den2 == 0) return -1.0; // Trivial case like 30/50

        if (num1 == den1 && den2 != 0) {
            return (double) num2 / den2;
        } else if (num2 == den2 && num2 != 0) {
            return (double) num1 / den1;
        } else if (num1 == den2 && den1 != 0) {
            return (double) num2 / den1;
        } else if (num2 == den1 && den2 != 0) {
            return (double) num1 / den2;
        }
        return -1.0; // Not a curious fraction or trivial case
    }

    public static void main(String[] args) {
        long resNumerator = 1;
        long resDenominator = 1;

        for (int numerator = 10; numerator < 100; numerator++) {
            for (int denominator = numerator + 1; denominator < 100; denominator++) {
                // Skip trivial cases where the last digit is 0 (e.g., 30/50)
                if (numerator % 10 == 0 && denominator % 10 == 0) {
                    continue;
                }

                double actualValue = (double) numerator / denominator;
                double cancelledValue = getCancelledValue(numerator, denominator);

                // Use a small epsilon for floating point comparison
                if (cancelledValue > 0 && Math.abs(actualValue - cancelledValue) < 1e-9) {
                    resNumerator *= numerator;
                    resDenominator *= denominator;
                }
            }
        }

        long commonDivisor = gcd(resNumerator, resDenominator);
        resDenominator /= commonDivisor;

        System.out.println(resDenominator);
    }
}
