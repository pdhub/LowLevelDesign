package linkedIn.code.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by PDeb on 11/1/2017.
 */
public class FindPairWithGivenSum {

    //This is O(nlogn) solution, but wont work for multiple pairs
    public void findPair(int arr[], int sum)
    {
        Arrays.sort(arr);
        int low = 0;
        int high = arr.length;
        while(low < high)
        {
            int tempsum = arr[low]+arr[high];
            if( tempsum > sum){
                high--;
            }
            else if(tempsum < sum){
                low++;
            }else {
                System.out.println(" found pair "+arr[low]+" : "+arr[high]);
            }
        }
    }

    //O(n) solution
    public void findPairOn(int arr[], int sum){
        Map map = new HashMap();
        for (int i = 0; i < arr.length; i++) {
            if(map.containsKey(sum-arr[i]))
                System.out.println("found");
            else
                map.put(arr[i], i);
        }
    }
}
