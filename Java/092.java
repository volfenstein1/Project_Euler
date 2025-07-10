import java.util.HashMap;
import java.util.Map;

public class Problem092 {

    private static final Map<Integer, Integer> chains = new HashMap<>();

    public static int squareDigits(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }
        return sum;
    }

    public static int chain(int n) {
        if (chains.containsKey(n)) {
            return chains.get(n);
        }

        int m = n;
        // Use a temporary list to store numbers in the current chain to avoid recomputing
        // and to add them to the 'chains' map once the termination is found.
        java.util.List<Integer> currentChain = new java.util.ArrayList<>();
        currentChain.add(m);

        while (!chains.containsKey(m)) {
            m = squareDigits(m);
            if (!chains.containsKey(m)) { // Avoid adding duplicates if m is already in currentChain
                currentChain.add(m);
            }
        }

        int termination = chains.get(m);
        for (int numInChain : currentChain) {
            chains.put(numInChain, termination);
        }
        return termination;
    }

    public static void main(String[] args) {
        chains.put(1, 1);
        chains.put(89, 89);

        int count89 = 0;
        for (int n = 1; n <= 10_000_000; n++) {
            if (chain(n) == 89) {
                count89++;
            }
        }
        System.out.println(count89);
    }
}
