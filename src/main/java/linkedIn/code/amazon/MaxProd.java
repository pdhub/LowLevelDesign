package linkedIn.code.amazon;

public class MaxProd {
    public static void main(String[] args) {
        int ar[] = {-6, 4, -5, 8, -10, 0, 8};
        System.out.println(maxProd(ar));
    }

    public static int maxProd(int arr[]){
        int maxEnding = 0, minEnding = 0;
        int maxSoFar = 0;
        for (int i = 0; i < arr.length; i++) {
            int temp = maxEnding;

            maxEnding = Integer.max(arr[i], Integer.max(arr[i] * maxEnding, arr[i]*minEnding));
            minEnding = Integer.min(arr[i], Integer.min(arr[i]*temp, arr[i] * minEnding));
            maxSoFar = Integer.max(maxSoFar, maxEnding);
        }
        return maxSoFar;
    }
}
