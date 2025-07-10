public class Problem012 {

    public static int divisors(long n) {
        int count = 0;
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                if (n / i == i) {
                    count++;
                } else {
                    count += 2;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        long n = 1;
        while (true) {
            long triangleNumber = (n * (n + 1)) / 2;
            if (divisors(triangleNumber) >= 500) {
                System.out.println(triangleNumber);
                break;
            }
            n++;
        }
    }
}
