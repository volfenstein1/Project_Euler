import java.math.BigDecimal;
import java.math.MathContext;

public class Problem080 {

    // Function to calculate the square root of a BigDecimal to a given precision
    public static BigDecimal sqrt(BigDecimal A, int scale) {
        BigDecimal x0 = new BigDecimal("5"); // Initial guess
        MathContext mc = new MathContext(scale + 5); // Use higher precision for intermediate calculations

        for (int i = 0; i < 100; i++) { // Iterate to converge
            BigDecimal x1 = A.divide(x0, mc).add(x0).divide(new BigDecimal("2"), mc);
            if (x1.equals(x0)) {
                break;
            }
            x0 = x1;
        }
        return x0.round(new MathContext(scale)); // Round to desired scale
    }

    public static int getDigitalSum(BigDecimal number, int numDigits) {
        String s = number.toPlainString();
        int sum = 0;
        int count = 0;
        boolean decimalPointFound = false;

        for (char c : s.toCharArray()) {
            if (c == '.') {
                decimalPointFound = true;
                continue;
            }
            if (decimalPointFound) {
                sum += Character.getNumericValue(c);
                count++;
                if (count == numDigits) {
                    break;
                }
            }
        }
        return sum;
    }

    public static boolean isPerfectSquare(int n) {
        int sqrt = (int) Math.sqrt(n);
        return sqrt * sqrt == n;
    }

    public static void main(String[] args) {
        long totalDigitalSum = 0;
        int precision = 100; // Number of decimal digits required

        for (int i = 1; i <= 100; i++) {
            if (!isPerfectSquare(i)) {
                BigDecimal num = new BigDecimal(i);
                BigDecimal sqrtValue = sqrt(num, precision + 2); // Calculate with extra precision
                totalDigitalSum += getDigitalSum(sqrtValue, precision);
            }
        }
        System.out.println(totalDigitalSum);
    }
}
