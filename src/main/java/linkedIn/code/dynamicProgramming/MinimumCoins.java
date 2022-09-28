package linkedIn.code.dynamicProgramming;

/**
 * Created by PDeb on 1/7/2018.
 */
public class MinimumCoins
{
    public int findMinCoins(int coins[], int n, int sum)
    {
        int T[] = new int[sum + 1];
        T[0] = 0;

        for (int i = 1; i <= sum ; i++)
        {
            T[i] = Integer.MAX_VALUE;
            int res = Integer.MAX_VALUE;

            for (int c = 0; c < coins.length; c++)
            {
                if (i - coins[c] >= 0)
                    res = T[i - coins[c]];
                if (res != Integer.MAX_VALUE)
                    T[i] = Math.min(T[i], res + 1);
            }
        }
        return T[sum];
    }
}
