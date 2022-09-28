package solution;

import java.util.Arrays;

public class ZeroFilledSubarray {

    public static void main(String[] args) {
        int[] nums = {1,3,0,0,2,0,0,4};
        System.out.println(new ZeroFilledSubarray().zeroFilledSubarray(nums));

    }
    public long zeroFilledSubarray(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        int dp[] = new int[nums.length];
        Arrays.fill(dp, 0);
        if(nums[0] == 0)
            dp[0] = 1;
        for(int i=1; i < nums.length; i++){
            if(nums[i] == 0){
                dp[i] = 1;
                if(dp[i-1] != 0){
                    dp[i] += dp[i-1];
                    dp[i] = (int) (Math.pow(2, dp[i])-1);
                    dp[i-1] = 0;
                }
            }
        }
        long total = 0;
        for(int i=0; i<nums.length; i++)
            total += dp[i];
        return total;
    }
}
