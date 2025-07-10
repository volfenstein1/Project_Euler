public class Problem006 {

    public static void main(String[] args) {
        int n = 100;
        long sumOfSquares = 0;
        for (int i = 1; i <= n; i++) {
            sumOfSquares += i * i;
        }

        long sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        long squareOfSum = sum * sum;

        System.out.println(squareOfSum - sumOfSquares);
    }
}
