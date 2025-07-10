public class Problem004 {

    public static boolean isPalindrome(int num) {
        String s = String.valueOf(num);
        int n = s.length();
        for (int i = 0; i < n / 2; i++) {
            if (s.charAt(i) != s.charAt(n - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int res = 0;
        for (int x = 999; x > 100; x--) {
            for (int y = 999; y > 100; y--) {
                int product = x * y;
                if (product < res) {
                    break;
                }
                if (isPalindrome(product)) {
                    res = product;
                }
            }
        }
        System.out.println("Largest palindrome: " + res);
    }
}
