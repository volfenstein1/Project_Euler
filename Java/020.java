import java.math.BigInteger;

public class Problem020 {

    public static int sumDigits(BigInteger num) {
        String s = num.toString();
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            res += Character.getNumericValue(s.charAt(i));
        }
        return res;
    }

    public static void main(String[] args) {
        BigInteger product = BigInteger.ONE;
        for (int n = 1; n <= 100; n++) {
            product = product.multiply(BigInteger.valueOf(n));
        }
        System.out.println(sumDigits(product));
    }
}
