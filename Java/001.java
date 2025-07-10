public class Problem001 {
    public static void main(String[] args) {
        int fizzBuzzSum = 0;
        for (int i = 0; i < 1000; i++) {
            if (i % 3 == 0 || i % 5 == 0) {
                fizzBuzzSum += i;
            }
        }
        System.out.println(fizzBuzzSum);
    }
}
