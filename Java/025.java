import java.math.BigInteger;

public class Problem025 {

    public static void main(String[] args) {
        int digits = 1000;
        BigInteger f1 = BigInteger.ONE;
        BigInteger f2 = BigInteger.ONE;
        int index = 2;

        while (f2.toString().length() < digits) {
            BigInteger temp = f2;
            f2 = f2.add(f1);
            f1 = temp;
            index++;
        }

        System.out.println(index);
    }
}
