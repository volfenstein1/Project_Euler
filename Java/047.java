import java.util.HashSet;
import java.util.Set;

public class Problem047 {

    public static int countDistinctPrimeFactors(int n) {
        Set<Integer> factors = new HashSet<>();
        int temp = n;

        for (int i = 2; i * i <= temp; i++) {
            if (temp % i == 0) {
                factors.add(i);
                while (temp % i == 0) {
                    temp /= i;
                }
            }
        }
        if (temp > 1) {
            factors.add(temp);
        }
        return factors.size();
    }

    public static void main(String[] args) {
        int consecutiveCount = 0;
        int i = 2;

        while (true) {
            if (countDistinctPrimeFactors(i) == 4) {
                consecutiveCount++;
            } else {
                consecutiveCount = 0;
            }

            if (consecutiveCount == 4) {
                System.out.println(i - 3);
                break;
            }
            i++;
        }
    }
}
