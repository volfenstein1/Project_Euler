public class Problem009 {

    public static boolean pythagoreanTriplet(int a, int b, int c) {
        return a * a + b * b == c * c;
    }

    public static void main(String[] args) {
        for (int a = 1; a < 1001; a++) {
            for (int b = a + 1; b < 1001 - a; b++) {
                int c = 1000 - a - b;
                if (pythagoreanTriplet(a, b, c)) {
                    System.out.println("Product abc: " + (long) a * b * c);
                    return;
                }
            }
        }
    }
}
