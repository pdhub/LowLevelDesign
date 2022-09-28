package linkedIn.code.dynamicProgramming;

import java.util.Map;

/**
 * Created by PDeb on 1/5/2018.
 */
public class LongestPalindromicSubsequence
{
    private int longestPalindrome(String x, int i, int j)
    {
        if (i > j)
            return 0;

        if (x.charAt(i) == x.charAt(j))
            return longestPalindrome(x, i + 1, j - 1) + 2;

        return Math.max(longestPalindrome(x, i + 1, j), longestPalindrome(x, i, j - 1));
    }

    private int longestPalindrome(String x, int i, int j, Map<String, Integer> map)
    {
        if (i > j)
            return 0;

        String key = String.valueOf(i) + "|" + String.valueOf(j);

        if (map.get(key) == null)
        {
            if (x.charAt(i) == x.charAt(j))
            {
                map.put(key, longestPalindrome(x, i + 1, j - 1) + 2);
            }
            else
            {
                map.put(key, Math.max(longestPalindrome(x, i + 1, j, map), longestPalindrome(x, i, j - 1, map)));
            }
        }
        return map.get(key);
    }

    private void printingTheSequence(String x, String y)
    {
        int m = x.length();
        //y is actually the reverse of x
        int lookUp[][] = new int[m + 1][m + 1];
        for (int i = 1; i <= m; i++)
        {
            for (int j = 1; j <= m ; j++)
            {
                if (x.charAt(i - 1) == y.charAt(j - 1))
                {
                    lookUp[i][j] = lookUp[i - 1][j - 1] + 1;
                }
                else
                {
                    lookUp[i][j] = Math.max(lookUp[i][j - 1], lookUp[i - 1][j]);
                }
            }
        }

        String str = printThePalindrome(x, y, m, m, lookUp);
    }

    private String printThePalindrome(String x, String y, int m, int n, int[][] lookUp)
    {
        if (m == 0 && n == 0)
            return "";

        if (x.charAt(m - 1) == y.charAt(n - 1))
            return printThePalindrome(x, y, m - 1, n - 1, lookUp);

        if (lookUp[m - 1][n] > lookUp[m][n - 1])
            return printThePalindrome(x, y, m - 1, n, lookUp);
        return printThePalindrome(x, y, m, n - 1, lookUp);
    }
}
