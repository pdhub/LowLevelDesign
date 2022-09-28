package linkedIn.code.dynamicProgramming;

/**
 * Created by PDeb on 1/6/2018.
 */
public class ImplementDiffUtility
{
    private int lookup[][] = new int[25][25];

    public void populateLookUp(String x, String y)
    {
        int m = x.length();
        int n = y.length();


        for (int i = 0; i <= m ; i++)
        {
            lookup[i][0] = 0;
        }

        for (int i = 0; i <= n ; i++)
        {
            lookup[0][i] = 0;
        }

        for (int i = 1; i <= m ; i++)
        {
            for (int j = 1; j <= n ; j++)
            {
                if (x.charAt(i) == y.charAt(j) && i != j)
                    lookup[i][j] = lookup[i -1][j - 1] + 1;
                else
                    lookup[i][j] = Math.max(lookup[i][j - 1], lookup[i - 1][j]);
            }
        }
    }

    public void printDiffUtility(String x, String y, int m, int n)
    {
        if (m > 0 && n > 0 && x.charAt(m - 1) == y.charAt(n - 1))
        {
            printDiffUtility(x, y, m - 1, n - 1);
            System.out.print(" " + x.charAt(m - 1));
        }
        //current character of y is not present in x
        else if (n > 0 && (m == 0 || lookup[m][n - 1] >= lookup[m - 1][n]))
        {
            printDiffUtility(x, y, m, n - 1);
            System.out.print(" + " + y.charAt(n - 1));
        }
        else if (m > 0 && (n == 0 || lookup[m][n - 1] < lookup[m - 1][n]))
        {
            printDiffUtility(x, y, m, n - 1);
            System.out.print(" + " + y.charAt(n - 1));
        }
    }
}
