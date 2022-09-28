package linkedIn.code.dynamicProgramming;

/**
 * Created by PDeb on 1/6/2018.
 */
public class LongestRepeatedSubsequence
{
    public int LRSLength(String x, int m, int n)
    {
        if (m == 0 || n == 0)
            return 0;
        if ((x.charAt(m - 1) == x.charAt(n - 1)) && (m != n))
            return LRSLength(x, m - 1, n - 1) + 1;
        return Math.max(LRSLength(x, m - 1, n), LRSLength(x, m, n - 1));
    }

    //use a map to do it in top down approach.

    //Here is the bottom up
    public void LRSLength(String x, int m)
    {
        int lookUp[][] = new int[m + 1][m + 1];
        for (int i = 0; i <= m; i++)
        {
            lookUp[i][0] = 0;
        }

        for (int i = 0; i <= m ; i++)
        {
            lookUp[0][i] = 0;
        }

        for (int i = 1; i <= m; i++)
        {
            for (int j = 1; j <= m; j++)
            {
                if ((x.charAt(i - 1) == x.charAt(j - 1)) && (i != j))
                    lookUp[i][j] = lookUp[i - 1][j - 1] + 1;
                else
                    lookUp[i][j] = Math.max(lookUp[i][j - 1], lookUp[i - 1][j]);
            }
        }

        printTheLRS(x, m, m, lookUp);
    }

    private String printTheLRS(String x, int m, int n, int[][] lookUp)
    {
        if (m == 0 || n == 0)
            return "";

        if ((x.charAt(m - 1) == x.charAt(n - 1)) && (m != n))
            return printTheLRS(x, m - 1, n - 1, lookUp) + x.charAt(m - 1);
        else
        {
            if (lookUp[m - 1][n] > lookUp[m][n - 1])
                return printTheLRS(x, m - 1, n, lookUp);
            return printTheLRS(x, m, n - 1, lookUp);
        }
    }
}
