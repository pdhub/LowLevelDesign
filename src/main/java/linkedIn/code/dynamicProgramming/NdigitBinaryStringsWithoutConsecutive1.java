package linkedIn.code.dynamicProgramming;

/**
 * Created by PDeb on 1/7/2018.
 */
public class NdigitBinaryStringsWithoutConsecutive1
{
    private int countStrings(int n, int last_digit)
    {
        if (n == 0)
            return 0;
        if (n == 1)//1 digit left
        {
            if (last_digit == 1)
                return 1;
            else
                return 2;
        }
        if (last_digit == 0)
            return countStrings(n - 1, 0) + countStrings(n - 1, 1);
        else
            return countStrings(n - 1, 0);
    }

    private int countStrings(int n)
    {
        int T[][] = new int[n + 1][2];
        T[0][0] = 0;//No digits left
        T[0][1] = 0;
        T[1][0] = 2;//1 digit left
        T[1][1] = 2;

        for (int i = 2; i <= n; i++)
        {
            T[i][0] = T[i - 1][0] + T[i - 1][1];
            T[i][1] = T[i - 1][0];
        }
        return T[n][0];
    }
}
