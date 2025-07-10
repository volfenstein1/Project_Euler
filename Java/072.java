public class Problem072 {

    public static void main(String[] args) {
        int limit = 1_000_000;
        long[] phi = new long[limit + 1];

        for (int i = 0; i <= limit; i++) {
            phi[i] = i;
        }

        for (int i = 2; i <= limit; i++) {
            if (phi[i] == i) { // i is prime
                for (int j = i; j <= limit; j += i) {
                    phi[j] -= phi[j] / i;
                }
            }
        }

        long totalCount = 0;
        for (int i = 2; i <= limit; i++) {
            totalCount += phi[i];
        }

        System.out.println(totalCount);
    }
}
