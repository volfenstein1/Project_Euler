import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

public class Problem029 {

    public static int generateTerms(int a, int b) {
        Set<BigInteger> terms = new HashSet<>();
        for (int i = 2; i <= a; i++) {
            for (int j = 2; j <= b; j++) {
                terms.add(BigInteger.valueOf(i).pow(j));
            }
        }
        return terms.size();
    }

    public static void main(String[] args) {
        int res = generateTerms(100, 100);
        System.out.println(res);
    }
}
