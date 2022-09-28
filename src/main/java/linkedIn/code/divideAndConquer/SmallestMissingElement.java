package linkedIn.code.divideAndConquer;

/**
 * Created by PDeb on 1/5/2018.
 */
public class SmallestMissingElement
{
    private int smallestMissingELement(int arr[], int low, int high)
    {
        if (low > high)
            return low;

        int mid = ( low + high ) / 2;
        if (arr[mid] == mid) //middle element matches with index of middle element, so mismatch is on the right
            return smallestMissingELement(arr, low, mid - 1);
        else
            return smallestMissingELement(arr, mid + 1, high);
    }
}
