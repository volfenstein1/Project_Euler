import java.math.BigInteger;

public class Problem048 {

    public static void main(String[] args) {
        BigInteger sum = BigInteger.ZERO;
        BigInteger modulus = BigInteger.TEN.pow(10);

        for (int i = 1; i <= 1000; i++) {
            BigInteger base = BigInteger.valueOf(i);
            BigInteger term = base.pow(i);
            sum = sum.add(term);
            sum = sum.mod(modulus); // Keep the sum within the last 10 digits
        }
        System.out.println(sum);
    }
}
