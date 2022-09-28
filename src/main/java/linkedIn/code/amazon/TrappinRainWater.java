package linkedIn.code.amazon;

public class TrappinRainWater {
    public static void main(String[] args) {
        int arr[] = {7, 0, 4, 2, 5, 0, 6, 4, 0, 5};
        System.out.println(trappedwater(arr));
    }

    private static int trappedwater(int[] arr) {
        int L[] = new int[arr.length];
        L[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            L[i] = Math.max(L[i-1], arr[i-1]);//Rem i here
        }

        int R[] = new int[arr.length];
        R[arr.length - 1] = arr[arr.length - 1];
        for (int i = arr.length - 2; i >=1 ; i--) {
            R[i] = Math.max(R[i+1], arr[i+1]);
        }

        int max = 0;
        for (int i = 1; i < arr.length - 1; i++) {
            if(Math.min(L[i], R[i]) >= arr[i])
                max += Math.min(L[i], R[i]) - arr[i];
        }
        return max;
    }
}
