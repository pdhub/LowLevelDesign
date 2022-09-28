package linkedIn.code.dynamicProgramming;

/**
 * Created by PDeb on 1/7/2018.
 */
public class SubsetSum
{
    public boolean findSubset(int arr[], int n, int sum)
    {
        if (sum == 0)
            return true;

        if (n < 0 || sum < 0)
            return false;

        boolean include = findSubset(arr, n - 1, sum - arr[n]);
        boolean exclude = findSubset(arr, n - 1, sum);

        return include || exclude;
    }
    //top down can be done with a map

    public boolean findSubSet(int arr[], int sum)
    {
        int n = arr.length;
        boolean T[][] = new boolean[n + 1][sum + 1];

        //num items 0
        for (int i = 0; i <= sum; i++)
        {
            T[0][i] = false;
        }

        //sum is zero
        for (int i = 0; i <= n ; i++)
        {
            T[i][0] = true;
        }

        for (int i = 1; i <= n ; i++)
        {
            for (int j = 1; j <= sum; j++)
            {
                if (arr[i - 1] > sum)
                    T[i][j] = T[i - 1][j];
                else
                    T[i][j] = T[i - 1][j] || T[i - 1][j - arr[i - 1]];
            }
        }
        return T[n][sum];
    }
}
