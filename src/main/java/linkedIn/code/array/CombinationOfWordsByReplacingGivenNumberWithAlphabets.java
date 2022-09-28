package linkedIn.code.array;

public class CombinationOfWordsByReplacingGivenNumberWithAlphabets {

    private static final String alphabets = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static void main(String[] args) {
        int[] arr = {1, 2, 2};
        findCombinations(arr, 0, "");
    }

    private static void findCombinations(int[] arr, int i, String str) {
        //System.out.println(String.format("i is %s, str is %s", i, str));
        if (i == arr.length)
        {
            System.out.println(str);
            return;
        }

        int sum = 0;
        for (int j = i; j <= Math.min(arr.length - 1, i + 1); j++) {
            System.out.println("Sum before is "+ sum);
            sum = ( sum * 10 ) + arr[j];
            System.out.println("Sum after is "+ sum);
            if (sum <= 26){
                System.out.println("String before is " + str);
                System.out.println("String after is " + str + alphabets.charAt(sum - 1));
                findCombinations(arr, j + 1, str + alphabets.charAt(sum - 1));
                System.out.println("Continuing with sum " + sum);
            }
        }
    }
}
