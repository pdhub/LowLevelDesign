package linkedIn.code.array;

/**
 * Created by pdeb on 11/22/2017.
 */
public class IndexOfZeroToBeReplaceToGetMaxLenOnes {

    public static void main(String[] args) {
        int arr[] = {0, 0, 1, 0, 1, 1, 1, 0, 1, 1};


        int prevZeroIndex = -1;
        int count = 0;
        int left = 0;
        int maxLen = 0;
        int indexOfZeroToBeReplaced = -1;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]==0){
                prevZeroIndex = i;
                count++;
            }

            if(count == 2){
                while (arr[left] !=0){
                    left++;
                }

                left++;
                count=1;
            }

            if(i - left + 1 > maxLen){
                maxLen = i - left + 1;
                indexOfZeroToBeReplaced = prevZeroIndex;
            }
        }

        System.out.println(String.format("Index to be replaced is %s", indexOfZeroToBeReplaced));
    }
}
