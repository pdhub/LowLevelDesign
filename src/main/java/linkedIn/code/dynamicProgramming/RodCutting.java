package linkedIn.code.dynamicProgramming;

import java.util.Arrays;

/**
 * Created by PDeb on 1/7/2018.
 */
public class RodCutting
{
    private int rodcut(int price[], int n)
    {
        int T[] = new int[n + 1];
        Arrays.fill(T, 0);
        for (int i = 1; i <= n ; i++)
        {
            for (int j = 1; j <= i ; j++)
            {
                T[i] = Math.max(T[i], price[i] + T[i - j]);
            }
        }
        return T[n];
    }
}
