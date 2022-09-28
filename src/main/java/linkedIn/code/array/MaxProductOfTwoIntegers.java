package linkedIn.code.array;

/**
 * Created by pdeb on 11/22/2017.
 */
public class MaxProductOfTwoIntegers {
    public static void main(String[] args) {
        int arr[] = {10, -3, 5, 6, -2};

        int max = Integer.MIN_VALUE, second_max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] > max){
                second_max = max;
                max = arr[i];
            }
            else if(arr[i] > second_max){
                second_max = arr[i];
            }
        }

        int min = Integer.MAX_VALUE, secondMin = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] < min){
                secondMin = min;
                min = arr[i];
            }
            else if(arr[i] < secondMin)
            {
                secondMin = arr[i];
            }
        }

        int maxValue = Math.max(max*second_max, min*secondMin);
        System.out.println(String.format("Max value is %s", maxValue));
    }
}
