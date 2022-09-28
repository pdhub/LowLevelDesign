package linkedIn.code.array;

/**
 * Created by pdeb on 11/22/2017.
 */
public class MaxSumSubArray {
    public static void main(String[] args) {
        int arr[] = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        int maxSum = maxKadane(arr);
        System.out.println(String.format("Max sum is %s", maxSum));
    }

    private static int maxKadane(int[] arr) {

        int maxTillHere = arr[0];
        int maxSoFar = arr[0];

        for (int i = 1; i < arr.length; i++) {
            maxTillHere += arr[i];
            maxTillHere = Math.max(arr[i], maxTillHere);

            maxSoFar = Math.max(maxSoFar, maxTillHere);
        }
        return maxSoFar;
    }
}
