package linkedIn.code.divideAndConquer;

/**
 * Created by PDeb on 1/4/2018.
 */
public class SearchElementInCircularSortedArray
{
    private int getIndexOfElement(int arr[], int key)
    {
        int n = arr.length - 1;
        int low = 0;
        int high = n;

        while (low <= high)
        {
            int mid = (low + high) / 2;
            if (arr[mid] == key)
                return mid;

            //Right half sorted and key still not found
            if (arr[mid] <= arr[high])
            {
                if (key >= arr[mid] && key <= arr[high])
                    low = mid + 1;
                else
                    high = mid - 1;
            }
            else
            {
                if (key >= arr[low] && key < arr[mid])
                    high = mid - 1;
                else
                    low = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args)
    {
        int arr[] = {9, 10, 2, 5, 6, 8};
        int index = new SearchElementInCircularSortedArray().getIndexOfElement(arr, 5);
        System.out.println(index);
    }
}

