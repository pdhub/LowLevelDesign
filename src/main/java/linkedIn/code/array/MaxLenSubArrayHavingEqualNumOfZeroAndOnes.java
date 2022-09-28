package linkedIn.code.array;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by pdeb on 11/20/2017.
 */
public class MaxLenSubArrayHavingEqualNumOfZeroAndOnes {
    public static void main(String[] args) {
        int arr[] = {0, 0, 1, 0, 1, 0, 0};

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int endIndex = -1;
        int maxLen = 0;
        int sum = 0;
        map.put(0, -1);
        for (int i = 0; i < arr.length; i++)
        {
            sum += arr[i]==1?1:-1;
            if(map.containsKey(sum))
            {
                if(maxLen < i - map.get(sum))
                {
                    maxLen = i - map.get(sum);
                    endIndex = i;
                }
            }
            else
            {
                map.put(sum, i);
            }
        }

        System.out.println(String.format("Max length is from %s to %s", endIndex - maxLen + 1, endIndex));
    }
}
