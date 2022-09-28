package solution;

import java.util.Arrays;
import java.util.List;

public class MinMaxSum {

    public static void main(String[] args) {
        //List<Integer> list = Arrays.asList()
        //miniMaxSum();

    }
    static long max = Long.MIN_VALUE;
    static long min = Long.MAX_VALUE;
    public static void miniMaxSum(List<Integer> arr) {
        if(arr == null || arr.size() < 4)
            return;
        if(arr.size() == 4){
            Integer sum = 0;
            for(Integer s : arr)
                sum += s;
            System.out.print(sum +" "+ sum);
        }
        int count = 0; int localSum = 0;
        boolean used[] = new boolean[arr.size()];
        helper(count, localSum, arr, used);
        System.out.print(min +" "+ max);
    }

    public static void helper(int count, Integer localSum, List<Integer> arr, boolean[] used){
        if(count == 4){
            min = Math.min(min, localSum);
            max = Math.max(max, localSum);
            //return;
        }
        for(int i=0; i<arr.size(); i++){
            if(!used[i]){
                localSum += arr.get(i);
                used[i] = true;
                count = count + 1;
                helper(count, localSum, arr, used);
                localSum -= arr.get(i);
                count = count - 1;
                used[i] = false;
            }
        }
    }
}
