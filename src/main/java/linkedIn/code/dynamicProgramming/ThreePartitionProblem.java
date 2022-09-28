package linkedIn.code.dynamicProgramming;

/**
 * Created by PDeb on 1/7/2018.
 */
public class ThreePartitionProblem
{
    private boolean threeSumProblem(int arr[], int n, int a, int b, int c)
    {
        if (a == 0 || b == 0 || c == 0)
            return true;
        if (n < 0)
            return false;

        boolean A = false;
        if (a - arr[n] >= 0)
            A = threeSumProblem(arr, n - 1, a - arr[n], b , c);

        boolean B = false;
        if (!A && b - arr[n] > 0)
            B = threeSumProblem(arr, n - 1, a, b - arr[n], c);

        boolean C = false;
        if ((!A && !B) && (c - arr[n] > 0))
            C = threeSumProblem(arr, n - 1, a, b, c - arr[n]);

        return A || B || C;
    }
}
