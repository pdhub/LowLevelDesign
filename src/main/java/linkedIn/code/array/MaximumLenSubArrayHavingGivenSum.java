package linkedIn.code.array;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by pdeb on 11/20/2017.
 */
public class MaximumLenSubArrayHavingGivenSum {
    public static void main(String[] args) {
        int a[] = {5, 6, -5, 5 , 3, 5, 3, -2, 0};
        int sum = 8;

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        int tempSum = 0;
        map.put(0, -1);
        int maxLength = 0;
        int endIndex = 0;
        for (int i = 0; i < a.length; i++) {
            tempSum += a[i];

            if(!map.containsKey(tempSum))
            {
                map.put(tempSum, i);
            }

            if(map.containsKey(tempSum - sum)){

                int prevIndex = map.get(tempSum - sum);
                if(i - prevIndex > maxLength) {
                    maxLength = i - prevIndex;
                    endIndex = i;
                }
            }

        }

        System.out.println(String.format("MaxLength is from %s to %s", endIndex - maxLength + 1, endIndex));
    }
}
