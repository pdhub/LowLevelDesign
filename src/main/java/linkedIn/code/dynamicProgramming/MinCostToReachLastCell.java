package linkedIn.code.dynamicProgramming;

/**
 * Created by PDeb on 1/7/2018.
 */
public class MinCostToReachLastCell
{
    private int M, N;
    public int findMinCost(int cost[][])
    {
        int T[][] = new int[M][N];
        for (int i = 0; i <= M; i++)
        {
            for (int j = 0; j <= N ; j++)
            {
                T[i][j] = cost[i][j];
                if (i == 0 && j > 0)
                    T[i][j] += T[i][j - 1]; //First row
                else if (i > 0 && j == 0)
                    T[i][j] += T[i - 1][j]; //First column
                else
                {
                    T[i][j] += Math.min(T[i - 1][j], T[i][j - 1]);
                }
            }
        }
        return T[M][N];
    }
}
