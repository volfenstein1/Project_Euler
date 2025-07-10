public class Problem002 {

    public static long fibonacciSum(int b) {
        long f1 = 1;
        long f2 = 1;
        long sumEven = 0;
        while (f2 < b) {
            long temp = f2;
            f2 = f2 + f1;
            f1 = temp;
            if (f2 % 2 == 0) {
                sumEven += f2;
            }
        }
        return sumEven;
    }

    public static void main(String[] args) {
        int bound = 4_000_000;
        System.out.println(fibonacciSum(bound));
    }
}
