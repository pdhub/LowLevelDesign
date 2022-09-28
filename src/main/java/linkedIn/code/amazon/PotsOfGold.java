package linkedIn.code.amazon;

public class PotsOfGold {
    public static void main(String[] args) {
        int[] coins = {4, 6, 2, 3};
        System.out.println(optimalStrategy(coins, 0, coins.length - 1));
        int[][] lookup = new int[coins.length][coins.length];
        System.out.println(optimalStrategyTopDown(coins, 0, coins.length - 1, lookup));
    }

    private static int optimalStrategy(int[] coins,
                                       int i,
                                       int j) {
        if (i == j)
            return coins[i];
        if (i + 1 == j)
            return Integer.max(coins[i], coins[j]);
        int pickedFromStart = coins[i] +
                Math.min(optimalStrategy(coins, i + 2, j)
                        , optimalStrategy(coins, i + 1, j - 1));
        int pickedFromEnd = coins[j] +
                Math.min(optimalStrategy(coins, i + 1, j - 1),
                        optimalStrategy(coins, i, j - 2));
        return Math.max(pickedFromStart, pickedFromEnd);
    }

    private static int optimalStrategyTopDown(int[] coins, int i, int j,
                                              int[][] lookup) {
        if (i == j)
            return coins[i];
        if (i + 1 == j)
            return Math.max(coins[i], coins[j]);
        if (lookup[i][j] == 0) {
            int coinSelectedFromStart = coins[i] +
                    Math.min(optimalStrategyTopDown(coins, i + 2, j, lookup),
                            optimalStrategyTopDown(coins, i + 1, j - 2, lookup));
            int coinSelectedFromEnd = coins[j] + Math.min(
                    optimalStrategyTopDown(coins, i + 1, j - 1, lookup),
                    optimalStrategyTopDown(coins, i, j - 2, lookup));
            lookup[i][j] = Math.max(coinSelectedFromEnd, coinSelectedFromStart);
        }
        return lookup[i][j];
    }
}
