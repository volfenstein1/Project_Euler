public class Problem017 {

    private static final String[] digitsToWord = {
        "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"
    };

    private static final String[] teensToWord = {
        "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"
    };

    private static final String[] tensToWord = {
        "", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"
    };

    public static String numToWord(int n) {
        if (n == 1000) {
            return "onethousand";
        }

        StringBuilder res = new StringBuilder();

        int hundreds = n / 100;
        if (hundreds > 0) {
            res.append(digitsToWord[hundreds]).append("hundred");
            if (n % 100 != 0) {
                res.append("and");
            }
        }

        int remainder = n % 100;
        if (remainder >= 10 && remainder < 20) {
            res.append(teensToWord[remainder - 10]);
        } else {
            int tens = remainder / 10;
            int ones = remainder % 10;
            if (tens > 0) {
                res.append(tensToWord[tens]);
            }
            if (ones > 0) {
                res.append(digitsToWord[ones]);
            }
        }

        return res.toString();
    }

    public static void main(String[] args) {
        int res = 0;
        for (int n = 1; n <= 1000; n++) {
            res += numToWord(n).length();
        }
        System.out.println(res);
    }
}
