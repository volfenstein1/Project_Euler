public class Problem005 {

    // Function to find the greatest common divisor of two numbers
    public static long gcd(long a, long b) {
        while (b > 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // Function to find the least common multiple of two numbers
    public static long lcm(long a, long b) {
        return (a * b) / gcd(a, b);
    }

    public static void main(String[] args) {
        long result = 1;
        for (long i = 1; i <= 20; i++) {
            result = lcm(result, i);
        }
        System.out.println(result);
    }
}
