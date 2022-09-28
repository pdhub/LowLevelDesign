package linkedIn.code.array;

import java.util.Arrays;

/**
 * Created by pdeb on 11/22/2017.
 */
public class ReplaceEachElementWithProductOfOthers {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5};
        Arrays.stream(arr).forEach(System.out::println);
        new ReplaceEachElementWithProductOfOthers().calculateRight(0, 1, arr);
        Arrays.stream(arr).forEach(System.out::println);

    }

    public int calculateRight(int i, int left, int arr[]) {
        if (i == arr.length)
            return 1;
        int element = arr[i];
        int right = calculateRight(i+1, left * element, arr);
        arr[i] = left * right;
        return element * right;
    }
}
