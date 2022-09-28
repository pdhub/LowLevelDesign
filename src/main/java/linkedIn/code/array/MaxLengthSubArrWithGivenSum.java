package linkedIn.code.array;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by pdeb on 11/15/2017.
 */
public class MaxLengthSubArrWithGivenSum {
    public static void main(String[] args) {
        int a[] = {5,6,-5,-5,3,5,3,-2,0};
        int sum = 8;
        maxLenSubarr(a, sum);
    }

    private static void maxLenSubarr(int[] a, int sum) {
        Map map = new HashMap();

        map.put(0, -1);
        int leftSum = 0;
        int len = 0;
        int endingIndex = -1;
        for (int i = 0; i < a.length; i++) {
            leftSum +=a[i];
            if(!map.containsKey(leftSum))
                map.put(leftSum, i);
            if(map.containsKey(leftSum-sum)){
                if(len < i-(Integer)(map.get(leftSum-sum))) {
                    len = i-(Integer)(map.get(leftSum-sum));
                    endingIndex = i;
                }
            }
        }
        System.out.println(endingIndex-len+1+" to "+endingIndex);

    }
}
