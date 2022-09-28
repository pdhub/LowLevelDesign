package linkedIn.code.divideAndConquer;

/**
 * Created by PDeb on 1/4/2018.
 */
public class FindFirstOccurenceInSortedArray
{
    private int firstOccurence(int arr[], int key)
    {
        int low = 0, high = arr.length - 1;
        int result = -1;
        int length = arr.length - 1;

        while (low <= high)
        {
            int mid = (low + high) / 2;
            if (arr[mid] == key)
            {
                high = mid - 1;
                result = mid;
            }
            if (arr[mid] > key)
            {
                high = mid - 1;
            }
            else
                low = mid + 1;
        }
        return result;
    }

    public static void main(String[] args) {
        int arr[] = { 2, 5, 5, 5, 6, 6, 8, 9, 9, 9};
        int index = new FindFirstOccurenceInSortedArray().firstOccurence(arr, 5);
        System.out.println(index);
    }
}
