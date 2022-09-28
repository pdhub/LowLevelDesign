package linkedIn.code.dynamicProgramming;

/**
 * Created by PDeb on 1/7/2018.
 */
public class Knapsack01
{
    private int knapsack(int v[], int w[], int totalWeight)
    {
        int T[][] = new int[v.length + 1][totalWeight + 1];

        for (int i = 0; i < totalWeight; i++)
        {
            T[0][i] = 0;
        }

        for (int i = 1; i < v.length; i++)
        {
            for (int j = 0; j <= totalWeight; j++)
            {
                if (w[i] > j)
                    T[i][j] = T[i - 1][j];
                else
                    T[i][j] = Math.max(T[i - 1][j], T[i][j - w[i - 1]] + v[i - 1]);
            }
        }
        return T[v.length][totalWeight];
    }
}
