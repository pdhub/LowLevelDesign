package linkedIn.code.amazon;

public class FloorAndCeiling {
    public static void main(String[] args) {

    }

    public static int getCeil(int arr[], int left, int right, int num){
        if (num <= arr[left])
            return arr[left];
        if (num > arr[right])
            return  -1;
        int mid = left + (right - left)/2;
        if (arr[mid] == num)
            return arr[mid];
        if (arr[mid] > num)
            return getCeil(arr, left, mid-1, num);
        else
            return getCeil(arr, mid + 1, right, num);
    }
}
