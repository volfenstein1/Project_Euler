public class Problem034 {

    public static int factorial(int n) {
        if (n == 0) {
            return 1;
        }
        int res = 1;
        for (int i = 1; i <= n; i++) {
            res *= i;
        }
        return res;
    }

    public static int sumFactorialDigits(int num) {
        String s = String.valueOf(num);
        int res = 0;
        for (char c : s.toCharArray()) {
            res += factorial(Character.getNumericValue(c));
        }
        return res;
    }

    public static void main(String[] args) {
        int res = 0;
        for (int n = 3; n < 100000; n++) {
            if (n == sumFactorialDigits(n)) {
                res += n;
            }
        }
        System.out.println(res);
    }
}
