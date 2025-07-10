import java.math.BigInteger;

public class Problem016 {

    public static int sumDigits(BigInteger num) {
        String s = num.toString();
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            res += Character.getNumericValue(s.charAt(i));
        }
        return res;
    }

    public static void main(String[] args) {
        BigInteger num = new BigInteger("2").pow(1000);
        System.out.println(sumDigits(num));
    }
}
