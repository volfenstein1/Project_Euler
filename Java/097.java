import java.math.BigInteger;

public class Problem097 {

    public static void main(String[] args) {
        BigInteger base = BigInteger.valueOf(2);
        BigInteger exponent = BigInteger.valueOf(7830457);
        BigInteger multiplier = BigInteger.valueOf(28433);
        BigInteger modulus = BigInteger.valueOf(10_000_000_000L);

        // Calculate 2^7830457 % 10^10
        BigInteger powerOfTwoMod = base.modPow(exponent, modulus);

        // Calculate (28433 * (2^7830457 % 10^10)) % 10^10
        BigInteger term1 = multiplier.multiply(powerOfTwoMod).mod(modulus);

        // Add 1 and take modulus again
        BigInteger result = term1.add(BigInteger.ONE).mod(modulus);

        System.out.println(result);
    }
}
