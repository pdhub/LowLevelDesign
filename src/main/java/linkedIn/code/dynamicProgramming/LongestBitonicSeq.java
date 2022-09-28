package linkedIn.code.dynamicProgramming;

/**
 * Created by PDeb on 1/7/2018.
 */
public class LongestBitonicSeq
{
    public void longestBitonic(int arr[])
    {
        int I[] = new int[arr.length];
        int D[] = new int[arr.length];

        I[0] = 1;
        for (int i = 1; i < arr.length; i++)
        {
            for (int j = 0; j < i; j++)
            {
                if (arr[i] > arr[j] && I[i] < I[j])
                    I[i] = I[j];
            }
            I[i]++;
        }

        D[arr.length - 1] = 1;
        for (int i = arr.length - 2; i >= 0 ; i--)
        {
            for (int j = arr.length - 1; j < i ; j--)
            {
                if (arr[i] > arr[j] && D[i] < D[j])
                    D[i] = D[j];
            }
            D[i]++;
        }
        int lbs = 1;
        for (int i = 0; i < arr.length; i++)
        {
            lbs = Math.max(lbs, I[i] + D[i] - 1);
        }
    }
}
