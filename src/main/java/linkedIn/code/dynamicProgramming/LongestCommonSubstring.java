package linkedIn.code.dynamicProgramming;

/**
 * Created by PDeb on 1/5/2018.
 */
public class LongestCommonSubstring
{
    public int longestCommonSubString(String x, String y)
    {
        int lookup[][] = new int[x.length() + 1][y.length() + 1];
        int maxLen = 0;
        int endingIndex = x.length();

        for (int i = 1; i <= x.length() ; i++)
        {
            for (int j = 1; j <= y.length() ; j++)
            {
                if (x.charAt(i - 1) == y.charAt(j - 1))
                    lookup[i][j] = lookup[i - 1][j - 1] + 1;
                if (maxLen < lookup[i][j])
                {
                    maxLen = lookup[i][j];
                    endingIndex = i;
                }
            }
        }
        return endingIndex - maxLen;
    }
}
