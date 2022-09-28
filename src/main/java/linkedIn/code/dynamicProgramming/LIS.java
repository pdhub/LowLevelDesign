package linkedIn.code.dynamicProgramming;

import java.util.Arrays;
import java.util.Vector;

/**
 * Created by PDeb on 11/13/2017.
 */
public class LIS
{

    public int LIS(int a[]){
        int L[] = new int[a.length];
        L[0] = 1;

        for (int i = 1; i < a.length; i++) {
            for (int j = 0; j < i; j++) {
                if (a[i] > a[j] && L[i] < L[j])
                    L[i] = L[j];//include j
            }
            L[i]++;
        }

        int maxLen = 0;
        for (int i = 0; i < L.length; i++) {
            if(maxLen < L[i])
                maxLen = L[i];
        }
        return maxLen;
    }

    public static void main(String[] args) {
        int a[] = {0,8,4,12,2,10,6,14,1,9,5,13,3,11,7,15};
        int max = new LIS().LIS(a);
        System.out.println(max);
    }

    //repeat
    public int longestIncreasing(int arr[], int i, int prev)
    {
        if (i == arr.length)
            return 0;
        int excl = longestIncreasing(arr, i + 1, prev);
        int incl = 0;
        if (arr[i] > prev)
            incl = 1 + longestIncreasing(arr, i + 1, arr[i]);
        return Math.max(incl, excl);
    }

    public int longestIncreasingOptimed(int arr[], int n)
    {
        int L[] = new int[n];
        Arrays.fill(L, 0);
        L[0] = 1;
        for (int i = 1; i < n; i++)
        {
            for (int j = 1; j < i; j++)
            {
                if (arr[i] < arr[j] && L[j] > L[i])
                    L[i] = L[j];
            }
            L[i]++;
        }

        int lis = Integer.MIN_VALUE;
        for (int i = 0; i < L.length; i++)
        {
            lis = Math.max(lis, L[i]);
        }
        return lis;
    }

    public void printingLIS(int arr[], int n)
    {
        Vector vector = new Vector();
        vector.add(0, arr[0]);
        for (int i = 1; i < n ; i++)
        {
            for (int j = 1; j < i; j++)
            {
                //if (arr[j] < arr[i])
            }
        }

    }
}
