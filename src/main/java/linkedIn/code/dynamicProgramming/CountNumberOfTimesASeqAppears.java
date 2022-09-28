package linkedIn.code.dynamicProgramming;

/**
 * Created by PDeb on 1/7/2018.
 */
public class CountNumberOfTimesASeqAppears
{
    public int count(String str, String seq, int m, int n)
    {
        int T[][] = new int[m + 1][n + 1];

        //If pattern empty then we have found the subsequence
        for (int i = 0; i <= m ; i++)
        {
            T[i][0] = 1;
        }

        //If input string is empty
        for (int i = 1; i <= n ; i++)
        {
            T[0][i] = 0;
        }

        for  (int i = 1; i <= m ; i++)
        {
            for (int j = 1; j <= n ; j++)
            {
                T[i][j] = ((str.charAt(i) == seq.charAt(j))? T[i - 1][j - 1]:0) + T[i - 1][j];
            }
        }
        return T[m][n];
    }
}
