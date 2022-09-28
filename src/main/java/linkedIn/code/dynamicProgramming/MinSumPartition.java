package linkedIn.code.dynamicProgramming;

/**
 * Created by PDeb on 1/7/2018.
 */
public class MinSumPartition
{
    public int minSum(int a[], int n, int s1, int s2)
    {
        if ( n < 0 )
            return Math.abs(s1 - s2);
        int inc = minSum(a, n - 1, s1 + a[n], s2);
        int exc = minSum(a, n - 1, s1, s2 + a[n]);
        return Math.min(inc, exc);
    }

    //use map for a top down approach
}
