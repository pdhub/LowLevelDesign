package linkedIn.code.array;

import java.util.Arrays;

/**
 * Created by pdeb on 11/14/2017.
 */
public class EquilibriumIndex {
    public static void main(String[] args) {
        int arr[] = {0, -3, 5, -4, -2, 3, 1, 0};

        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }

        int rightSum = 0;
        for (int i = arr.length-1; i >=0; i--) {

            if(sum-arr[i] == 2*rightSum)
                System.out.println(i);
            rightSum+= arr[i];
        }
    }
}
