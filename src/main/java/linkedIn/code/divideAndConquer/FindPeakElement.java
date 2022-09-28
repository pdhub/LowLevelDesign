package linkedIn.code.divideAndConquer;

/**
 * Created by PDeb on 1/5/2018.
 */
public class FindPeakElement
{
    public int findPeakElement(int arr[], int low, int high, int n)
    {
        int mid = ( low + high )/2;
        if ((mid == 0 || arr[mid] > arr[mid - 1]) && (mid == n - 1) || (arr[mid] > arr[mid + 1]))
            return mid;
        if (mid - 1 > 0 && arr[mid - 1] > arr[mid])
            return findPeakElement(arr, low, mid - 1, n);
        return findPeakElement(arr, mid + 1, high, n);
    }
}
