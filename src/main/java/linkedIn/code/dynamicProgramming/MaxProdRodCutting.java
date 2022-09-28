package linkedIn.code.dynamicProgramming;

/**
 * Created by PDeb on 1/7/2018.
 */
public class MaxProdRodCutting
{
    private int rodCut(int n)
    {
        int T[] = new int[n + 1];
        for (int i = 0; i <= n ; i++)
        {
            T[i] = i;
        }

        for (int i = 2; i <= n ; i++)
        {
            for (int j = 1; j <= i ; j++)
            {
                T[i] = Math.max(T[i], j * T[i - j]);
            }
        }
        return T[n];
    }
}
