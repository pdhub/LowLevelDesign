package linkedIn.code.dynamicProgramming;

public class PotsOfGold {

    public static void main(String[] args) {
        int[] coins = {4, 6, 2, 3};
        int max = maxCoinsCollectedByPlayer(coins, 0, coins.length - 1);
        System.out.println(max);
        System.out.println(String.format("Result is %s",  max == 9));
    }

    private static int maxCoinsCollectedByPlayer(int coins[], int start, int end) {
        if (start == end)
            return coins[start];
        if (start + 1 == end)
            return Integer.max(coins[start], coins[end]);

        int whenStartCoinSelected = coins[start] + Integer.min(maxCoinsCollectedByPlayer(coins, start+2, end),
                maxCoinsCollectedByPlayer(coins, start+1, end-1));
        int whenEndCoinSelected = coins[end] + Integer.min(maxCoinsCollectedByPlayer(coins, start+1, end-1),
                maxCoinsCollectedByPlayer(coins, start, end-2));

        return Integer.max(whenStartCoinSelected, whenEndCoinSelected);
    }
}
