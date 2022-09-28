package linkedIn.code.dynamicProgramming;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by PDeb on 11/4/2017.
 */
public class LCS {

    public int recursiveImplmentation(String firstString, String secondString, int firstStrLen, int secondStrLen){

        if(firstStrLen == 0 || secondStrLen ==0)
            return 0;

        if(firstString.charAt(firstStrLen-1) == secondString.charAt(secondStrLen-1))
            return recursiveImplmentation(firstString, secondString, firstStrLen-1, secondStrLen-1)+1;
        else
            return Math.max(recursiveImplmentation(firstString, secondString, firstStrLen-1, secondStrLen),
                            recursiveImplmentation(firstString, secondString, firstStrLen, secondStrLen-1));
    }
    /**Worst case in this above is O(2^(m+n)), when there are no subsequences and each recursive call will end up in two calls*/

    public int usingMemoization(String firstString, String secondString, int firstStrLen, int secondStrLen, Map<String, Integer> stringToLen)
    {
        if(firstStrLen == 0 || secondStrLen ==0)
            return 0;
        String keyWithLastCharOfEachString = firstString.charAt(firstStrLen-1) + "|" + secondString.charAt(secondStrLen-1);
        if(!stringToLen.containsKey(keyWithLastCharOfEachString))
        {
            if(firstString.charAt(firstStrLen-1) == secondString.charAt(secondStrLen-1))
                stringToLen.put(keyWithLastCharOfEachString, usingMemoization(firstString, secondString, firstStrLen-1, secondStrLen-1, stringToLen)+1);

            else
                stringToLen.put(keyWithLastCharOfEachString, Math.max(usingMemoization(firstString, secondString, firstStrLen-1, secondStrLen, stringToLen),
                                                                        usingMemoization(firstString, secondString, firstStrLen, secondStrLen-1, stringToLen)));
        }
        return stringToLen.get(keyWithLastCharOfEachString);
    }

    /**Time complexity is O(mn) and auxillary spaces is also O(mn), this is town down approach, lets do a bottom up approach*/

    /*Here we have assumed the table row to contain X-> firstString elements, Y->Second String elements*/
    public int usingBottomUpApproachAndTable(String firstString, String secondString)
    {
        int lookUpTable[][] = new int[firstString.length()+1][secondString.length()+1];

        for (int i = 0; i < firstString.length(); i++) {
            lookUpTable[i][0] = 0;
        }

        for (int i = 0; i < secondString.length(); i++) {
            lookUpTable[0][i] = 0;
        }

        //populate table in bottom up manner
        for (int i = 1; i <= firstString.length(); i++) {
            for (int j = 1; j <= secondString.length(); j++) {
                if(firstString.charAt(i-1) == secondString.charAt(j-1)){
                    lookUpTable[i][j] = lookUpTable[i-1][j-1]+1;
                }else {
                    lookUpTable[i][j] = Math.max(lookUpTable[i-1][j], lookUpTable[i][j-1]);
                }
            }
        }
        return lookUpTable[firstString.length()][secondString.length()];
    }

    public static void main(String[] args) {
        LCS lcs = new LCS();
        String firstString = "XMJAUZ", secondString = "MZJAWXU";
        System.out.println("Maxsubsequence is : ");
        System.out.println("Recursive Naive : "+ lcs.recursiveImplmentation(firstString, secondString, firstString.length(), secondString.length()));

        Map<String, Integer> stringIntegerMap = new HashMap<String, Integer>();
        System.out.println("Memoized Top down :" + lcs.usingMemoization(firstString, secondString, firstString.length(), secondString.length(), stringIntegerMap));

        System.out.println("Using bottom up : "+lcs.usingBottomUpApproachAndTable(firstString, secondString));

    }

    //revise

    private int LCSLength(String x, String y)
    {
        int m = x.length();
        int n = y.length();

        int lookUp[][] = new int[m + 1][n + 1];

        for (int i = 0; i <= m ; i++)
        {
            lookUp[i][0] = 0;
        }

        for (int i = 0; i <= n ; i++)
        {
            lookUp[0][n] = 0;
        }

        for (int i = 1; i <= m; i++)
        {
            for (int j = 1; j <= n; j++)
            {
                if (x.charAt(i - 1) == y.charAt(j - 1))
                    lookUp[i][j] = lookUp[i-1][j-1] + 1;
                else
                    lookUp[i][j] = Math.max(lookUp[i - 1][j], lookUp[i][j - 1]);
            }
        }
        return lookUp[m][n];
    }
}
