public class Problem031 {

    public static void main(String[] args) {
        int[] coins = {1, 2, 5, 10, 20, 50, 100, 200};
        int[] totalWays = new int[201];
        totalWays[0] = 1;

        for (int coin : coins) {
            for (int i = coin; i <= 200; i++) {
                totalWays[i] += totalWays[i - coin];
            }
        }

        System.out.println(totalWays[200]);
    }
}
