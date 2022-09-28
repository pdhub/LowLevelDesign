package solution;

import java.util.*;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Solution {

    public static int getMaxPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int dp[][] = new int[m][n];
        for(int j=0; j<n; j++){
            dp[m-1][j] = matrix[m-1][j];
        }
        for(int i=m-2; i>=0; i--){
            for(int j=0; j<n; j++){
                int left = j>0?dp[i+1][j-1]+matrix[i][j]:0;
                int below = dp[i+1][j]+matrix[i][j];
                int right = j<n?dp[i+1][j+1]+matrix[i][j]:0;
                dp[i][j] = Math.max(Math.max(left,below), right);
            }
        }
        int res = Integer.MIN_VALUE;
        for(int j=0; j<n; j++)
            res = 0;//Math.max(dp[0][j]);
        return res;
    }


        public static int findPivot(int[] arr){
            int low = 0, high = arr.length-1;
            while(low < high){
               while (arr[low]==arr[low+1])
                   low++;
               while (arr[high]==arr[high-1])
                   high--;
               int mid = low + (high-low)/2;
               if(arr[low]>arr[high])
                   return high;
               if (arr[low] < arr[mid])
                   low = mid;
               else
               {
                   if (arr[mid] < arr[high])
                       high = mid;
                   else
                       low = mid;
               }
            }
            return low;
        }



    public String[] reorderLogFiles(String[] logs) {
        List<Log> res = new ArrayList();
        for(String log : logs){
            Log logg = new Log();
            String[] elements = log.split("");
            logg.identifier=(elements[0]);
            List<String> list = new ArrayList();
            for(int i=1; i<elements.length; i++){
                list.add(elements[i]);
            }
            Collections.sort(list);
            logg.elements = list;
            res.add(logg);
        }
        Collections.sort(res);
        String[] resString = new String[res.size()];
        int count = 0;
        for(Log l : res){
            resString[count++] = String.valueOf(l.elements);
        }
        return resString;
    }

    class Log implements Comparable<Log>{
        public String identifier;
        public List<String> elements;

        public int compareTo(Log log){
            if(isDigitLog(log) == isDigitLog(this)){
                return 0;
            }else if(!isDigitLog(log) == !isDigitLog(this)){
                return 0;//log.elements.compareTo(this.elements);
            }else
            {
                if(isDigitLog(log))
                    return 1;
                else
                    return 0;
            }
        }

        public boolean isDigitLog(Log log){
            try{
                for(String ele : elements){
                    Integer d = Integer.parseInt(ele);
                }
            }catch(Exception e){
                return false;
            }
            return true;
        }
    }

    public static int maxHeight = 0, bound = 10;
    public static int findHeight(int arr[], int i){
        if (arr[i]==-1)
            return 0;
        return 1 + findHeight(arr, arr[i]);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = {4,4,5,5,5,1,2,2,3,4};
        System.out.println("Required" + 5 + " Got " + findPivot(arr));
        int[] arr1 = {5,5,5,5,5,0,0,0,0,0};
        System.out.println("Required" + 5 + " Got " + findPivot(arr1));
        int[] arr2 = {4, 1, 1, 3, 4, 4};
        System.out.println("Required" + 1 + " Got " + findPivot(arr2));
        int[] arr3 = {4, 4, 1, 1, 4, 4};
        System.out.println("Required" + 2 + " Got " + findPivot(arr3));

        //int arr[] = {12, 11, 13, 5, 6, 7};
        /*int[] arr = {-1, 0, 0, 1, 2, 2, 4, 4};

        int[] height = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            height[i] = findHeight(arr, i);
        }
        System.out.println(Arrays.stream(height).max().getAsInt());

        //s.mergesort(arr, 0, arr.length - 1);

        /*int arr2[] = {5, 3, 4, 7};
        int arr3[] = {2, 3, 5};
        List<Integer> result = bestSum(8, arr2);
        for (Integer item: result) {
            System.out.println(item);
        }

        solution.ListNode l1 = new solution.ListNode(2);
        l1.next = new solution.ListNode(4);
        l1.next.next = new solution.ListNode(3);

        solution.ListNode l2 = new solution.ListNode(5);
        l2.next = new solution.ListNode(6);
        l2.next.next = new solution.ListNode(4);

        solution.ListNode r = new solution.Solution().addTwoNumbers(l1, l2);
        while (r!=null) {
            System.out.print(r.val + "->");
            r = r.next;
        }*/
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l11 = reverse(l1);
        ListNode l21 = reverse(l2);
        ListNode res = null; int carry = 0, sum = 0;
        //solution.ListNode resPo = res;
        while(l11 !=null && l21 !=null){
            sum = l11.val + l21.val;
            sum += carry;
            carry = sum/10;
            l11 = l11.next;
            l21 = l21.next;

            res = new ListNode();
            res.val = sum%10;
            res = res.next;

        }

        while(l11 !=null){
            sum = l11.val;
            sum += carry;
            carry = sum/10;
            l11 = l11.next;
            res.next = new ListNode();
            res.val = sum%10;
            res = res.next;
        }

        while(l21 !=null){
            sum = l21.val;
            sum += carry;
            carry = sum/10;
            l21 = l21.next;
            res = new ListNode();
            res.val = sum%10;
            res = res.next;
        }

        if(carry!=0){
            res.val = carry;
        }

        return reverse(res);

    }

    public ListNode reverse(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode p = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }

    public boolean canConstruct(String word, String[] parts){
        if (word == "")
            return true;
        for (String part: parts) {
            if (word.indexOf(part) == 0){
                //String suffix = word.
            }
        }
        return false;
    }

    public static List<Integer> bestSum(int sum, int[] arr){
        if( sum == 0)
            return new ArrayList();
        if(sum < 0)
            return null;

        List<Integer> shortest = null;

        for(int i=0; i<arr.length; i++){
            int remainder = sum - arr[i];
            List<Integer> remainderCombination = bestSum(remainder, arr);
            if (remainderCombination!= null){
                remainderCombination.add(arr[i]);
                if (shortest ==null || remainderCombination.size() < shortest.size())
                    shortest = remainderCombination;
            }

        }
        return shortest;
    }

    private void mergesort(int[] arr, int left, int right) {
        if (left < right){
            int mid = (right - left / 2) + 1;
            mergesort(arr, left, mid);
            mergesort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    private void merge(int[] arr, int left, int mid, int right) {
        int firstArrSize = mid - left + 1;
        int secondArrSize = right - mid;
        int firstArr[] = new int[firstArrSize];
        int secondArr[] = new int[secondArrSize];
        for (int i = 0; i < firstArrSize; i++) {
            firstArr[i] = arr[left + i];
        }
        for (int i = 0; i < secondArrSize; i++) {
            secondArr[i] = arr[mid + 1 + i];
        }
        int k = 1;
        int i = 0, j = 0;
        while (i< firstArrSize && j < secondArrSize){
            if (firstArr[i] < secondArr[j]){
                arr[k++] = firstArr[i++];
            }else {
                arr[k++] = secondArr[j++];
            }
        }
        while (i < firstArrSize){
            arr[k++] = firstArr[i++];
        }
        while (j < secondArrSize){
            arr[k++] = secondArr[j++];
        }
    }
}
