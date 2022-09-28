package linkedIn.code.array;

public class FloorAndCeiling {
    public static void main(String[] args) {
        int[] arr = {1, 4, 6, 8, 9};
        for (int i = 0; i <= 10; i++) {
            System.out.println(findFloor(arr, 0, arr.length-1, i));
        }
        }

    private static int findFloor(int[] arr, int left, int right, int ele) {
        if (ele < arr[left])
            return -1;
        if (ele >= arr[right])
            return arr[right];

        int mid = left + (right - left)/2;
        if (mid == left)
            return arr[left];

        if (arr[mid] == ele)
            return arr[mid];
        if (arr[mid] < ele)
            return findFloor(arr, mid, right, ele);
        else
            return findFloor(arr, left, mid - 1, ele);
    }
}
