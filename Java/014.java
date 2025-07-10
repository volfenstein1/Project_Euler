import java.util.HashMap;
import java.util.Map;

public class Problem014 {

    private static final Map<Long, Integer> lengths = new HashMap<>();

    public static int collatzLength(long n) {
        if (lengths.containsKey(n)) {
            return lengths.get(n);
        }
        if (n % 2 == 0) {
            lengths.put(n, 1 + collatzLength(n / 2));
        } else {
            lengths.put(n, 1 + collatzLength(3 * n + 1));
        }
        return lengths.get(n);
    }

    public static void main(String[] args) {
        lengths.put(1L, 1);
        long numWithLongestLength = 0;
        int longestLength = 0;
        for (long n = 1; n < 1_000_000; n++) {
            int currentLength = collatzLength(n);
            if (currentLength > longestLength) {
                numWithLongestLength = n;
                longestLength = currentLength;
            }
        }
        System.out.println(numWithLongestLength);
    }
}
