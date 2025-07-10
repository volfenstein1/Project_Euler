import java.util.ArrayList;
import java.util.List;

public class Problem003 {

    public static List<Long> primeFactor(long x) {
        List<Long> divisors = new ArrayList<>();
        long y = 2;
        while (y * y < x) {
            if (x % y == 0) {
                x /= y;
                divisors.add(y);
                System.out.println("Divisor found: " + y);
            } else {
                y++;
            }
        }
        divisors.add(x);
        System.out.println("Final divisor: " + x);
        return divisors;
    }

    public static void main(String[] args) {
        long x = 600851475143L;
        System.out.println(primeFactor(x));
    }
}
