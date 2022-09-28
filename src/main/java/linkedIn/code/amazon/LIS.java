package linkedIn.code.amazon;

import java.util.Arrays;

public class LIS {
    public static void main(String[] args) {
        int arr[] = {2, 6, 3, 4, 1, 2, 9, 5, 8};
        System.out.println(getLIS(arr));
    }

    private static int getLIS(int[] arr) {
        int L[] = new int[arr.length+1];
        int pos[] = new int[arr.length + 1];
        Arrays.fill(pos, -1);
        Arrays.fill(L, 1);
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    L[i] = Math.max(L[j] + 1, L[i]);
                    pos[i] = j;
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < L.length; i++) {
            max = Math.max(max, L[i]);
        }
        do {
            System.out.print(arr[max] + " ");
            max = pos[max];
        }while (max!=-1);

        return max;
    }
}
