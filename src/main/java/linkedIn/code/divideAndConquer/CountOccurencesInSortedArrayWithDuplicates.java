package linkedIn.code.divideAndConquer;

/**
 * Created by PDeb on 1/4/2018.
 */
public class CountOccurencesInSortedArrayWithDuplicates
{
    public int countOccurences(int arr[], int key, boolean searchFirst)
    {
        int low = 0, high = arr.length - 1;
        int length = arr.length - 1;
        int result = -1;
        while (low < high)
        {
            int mid = (low + high) / 2;
            if (arr[mid] == key)
            {
                result = mid;
                if (searchFirst)
                    low = mid + 1;
                else
                    high = mid - 1;
            }
            if (arr[mid] > key)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return result;
    }

    public void countOccurence(int arr[], int key)
    {
        int firstOccurence = countOccurences(arr, key, true);
        int lastOccurence = countOccurences(arr, key, false);
        int count = lastOccurence - firstOccurence + 1;
    }
}
