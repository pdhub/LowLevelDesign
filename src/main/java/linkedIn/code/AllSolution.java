package linkedIn.code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by PDeb on 11/14/2016.
 */
public class AllSolution {
    public static void main(String[] args) throws Exception{
        longestBitonicSequence();
        knapsack0_1();
        numberOfWaysinfiniteCoinsParticularSum();
        //minimumcoinsForAParticularValueRecursive();
        minimumcoinsForAParticularValue();
        implementationOfHeap();
        longestIncreasingSubsequence();
        //checkIfArrayElementsAreConsequtive();
        changeAllUpperToLowerAndViceVersa();
        isPalindrome();
        //prodOfAllNumbers();
        countDivisors();//complete it
        duplicateExistsWithinKIndices();
        //gasStationCircle();
        totalwaysInMatrixFromSrcToDest();
        stairCaseProblem();
        maxSubsquareMatrix();
        //minCostPathFromTopLeftToBottomRight();
        weightedJobScheduling();
        rodcutting();
        longestCommonsSubsequence();
        maxIncreasingSubsequence();
        kthLargestElementInArray();
        buySellStockOneForMaxProfit();
        buySellManyTimesForMaxProfit();
        eggDroppingProblem();
        diceThrowProblem();
        stackSortInplace();
        removeRepeatedDigits(11332);
        gasStationCircle();
        //groupElementsInSizeM();
        increasingSubsequenceOfLenghth3WithMaxProduct();
        maxcontiguouscircularsum();
        kthLargestElementInArray();
        kthElementInTwoSortedArray();
        printNextGreaterElementOnRight();
        //largestSubArrayWithEqualNumberOfZerosAndOnes();
        //MaximumIminusJSuchThatIgreaterThanj();
        //MaximumOfAllSubarraySOfSizeK();
        maxProductSubArray();
        MaxRepeatingNumber();
        //MinimumDistanceBetweenTwoNumbers();
        MinimumSortedWhichSortsEntireArray();
    }

    private static void MinimumSortedWhichSortsEntireArray() {
    }

    /**
     * http://www.geeksforgeeks.org/find-the-minimum-distance-between-two-numbers/
     */
    /*private static void MinimumDistanceBetweenTwoNumbers() {
        int i = 0;
        int min_dist = Integer.MAX_VALUE;
        int prev=0;

        // Find the first occurence of any of the two numbers (x or y)
        // and store the index of this occurence in prev
        for (i = 0; i < n; i++)
        {
            if (arr[i] == x || arr[i] == y)
            {
                prev = i;
                break;
            }
        }

        // Traverse after the first occurence
        for (; i < n; i++)
        {
            if (arr[i] == x || arr[i] == y)
            {
                // If the current element matches with any of the two then
                // check if current element and prev element are different
                // Also check if this value is smaller than minimum distance
                // so far
                if (arr[prev] != arr[i] && (i - prev) < min_dist)
                {
                    min_dist = i - prev;
                    prev = i;
                }
                else
                    prev = i;
            }
        }
        System.out.println(min_dist);


    }*/

    /*
     * **
     * http://www.geeksforgeeks.org/find-the-maximum-repeating-number-in-ok-time/
     * Given an array of size n, the array contains numbers in range from 0 to k-1
     * where k is a positive integer and k <= n.
     * Find the maximum repeating number in this array
     */
    private static void MaxRepeatingNumber() {
        int arr[] = {2,2,1,3,1,2,0,3,0,0,0,4,5,4,4,4,4};
        int k = 6;
        int len = k;
        for(int i=0;  i < arr.length; i++){
            arr[arr[i]%len] += len;
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        int maxRepeating = 0;
        int maxRepeatingIndex =0;
        for(int i=0; i < len; i++){
            if(maxRepeating < arr[i]){
                maxRepeating = arr[i];
                maxRepeatingIndex = i;
            }
        }
        for(int i=0; i < len; i++){
            arr[i] = arr[i] % len;
        }
        System.out.println("MaxRepeatingNumber :" + maxRepeatingIndex);
    }

    private static void maxProductSubArray() {
        /*http://www.geeksforgeeks.org/maximum-product-subarray/*
        Find the contiguous sub array within an array (containing at least one number) which has the largest product./
         */
        int arr[] = {1, -2, -3, 0, 7, -8, -2};
        int n = arr.length;
        // max positive product ending at the current position
        int max_ending_here = 1;

        // min negative product ending at the current position
        int min_ending_here = 1;

        // Initialize overall max product
        int max_so_far = 1;

        /* Traverse through the array. Following
           values are maintained after the ith iteration:
           max_ending_here is always 1 or some positive product
                           ending with arr[i]
           min_ending_here is always 1 or some negative product
                           ending with arr[i] */
        for (int i = 0; i < n; i++)
        {
            /* If this element is positive, update max_ending_here.
                Update min_ending_here only if min_ending_here is
                negative */
            if (arr[i] > 0)
            {
                max_ending_here = max_ending_here*arr[i];
                min_ending_here = Math.min (min_ending_here * arr[i], 1);
            }

            /* If this element is 0, then the maximum product cannot
               end here, make both max_ending_here and min_ending
              _here 0
               Assumption: Output is alway greater than or equal to 1. */
            else if (arr[i] == 0)
            {
                max_ending_here = 1;
                min_ending_here = 1;
            }

            /* If element is negative. This is tricky
               max_ending_here can either be 1 or positive.
               min_ending_here can either be 1 or negative.
               next min_ending_here will always be prev.
               max_ending_here * arr[i]
               next max_ending_here will be 1 if prev
               min_ending_here is 1, otherwise
               next max_ending_here will be
                           prev min_ending_here * arr[i] */
            else
            {
                int temp = max_ending_here;
                max_ending_here = Math.max (min_ending_here * arr[i], 1);
                min_ending_here = temp * arr[i];
            }

            // update max_so_far, if needed
            if (max_so_far <  max_ending_here)
                max_so_far  =  max_ending_here;
        }

        System.out.println();
        System.out.println(" maxProductSubArray : "+max_so_far);
    }

    /**http://www.geeksforgeeks.org/maximum-of-all-subarrays-of-size-k/*/
    private static void MaximumOfAllSubarraySOfSizeK() {
        int input[] = {1, 2, 3, 1, 4, 5, 2, 3, 6};
        int k = 3;

        // Create a Double Ended Queue, Qi that will store indexes of array elements
        // The queue will store indexes of useful elements in every window and it will
        // maintain decreasing order of values from front to rear in Qi, i.e.,
        // arr[Qi.front[]] to arr[Qi.rear()] are sorted in decreasing order
        Deque<Integer> queue = new LinkedList<Integer>();
        int max[] = new int[input.length - k + 1];
        int maxVal = Integer.MIN_VALUE;
        //first find max of first k values and make it 0th element of max array
        for (int i = 0; i < k; i++) {
            if(maxVal < input[i])
                maxVal = input[i];
            if (queue.isEmpty())
                queue.offerLast(i);
            else {//Keep on removing till input[i] >= input of the index in the last element in the queue
                while (!queue.isEmpty() && input[queue.peekLast()]<=input[i])
                    queue.pollLast();
                queue.offerLast(i);
            }
        }
        max[0] = maxVal;
        int index = -1;
        //continue from k till end of the input array
        for (int i = k; i < input.length; i++) {
            //if index of peek is k distance from i then its no value to us.
            //throw it away
            if (i - k + 1 > queue.peekFirst()) {
                queue.pollFirst();
            }
            while (!queue.isEmpty() && input[queue.peekLast()] <= input[i]) {
                queue.pollLast();
            }
            queue.offerLast(i);
            //Only reason first element survived was because it was biggest element.
            //make it the max value for this k
            max[index] = input[queue.peekFirst()];
            index++;
        }
        System.out.print("MaximumOfAllSubarraySOfSizeK :");
        for (int i : max)
            System.out.print(i + " ");
        System.out.println();
    }

    private static void MaximumIminusJSuchThatIgreaterThanj() {
        int input[] = {11,14,13,1,4,13,1,10};
        int lhs[] = new int[input.length];
        int rhs[] = new int[input.length];
        lhs[0] = 0;
        for (int i = 1; i < lhs.length; i++)
        {
            if (input[lhs[i - 1]] < input[i])
                lhs[i] = lhs[i-1];
            else
                lhs[i] = i;
        }

        rhs[input.length-1] = input.length-1;

        for(int i=input.length-2; i >= 0; i--){
            if(input[rhs[i+1]] > input[i]){
                rhs[i] = rhs[i+1];
            }else{
                rhs[i] = i;
            }
        }

        int i=0;
        int j=0;
        int max = 0;
        for(;j < input.length;){
            if(input[lhs[i]] < input[rhs[j]]){
                max = Math.max(max, j-i);
                j++;
            }else{
                i++;
            }
        }
        System.out.println("MaximumIminusJSuchThatIgreaterThanj : "+max);

    }


    /*http://www.geeksforgeeks.org/largest-subarray-with-equal-number-of-0s-and-1s/*/
    private static void largestSubArrayWithEqualNumberOfZerosAndOnes() {
        int arr[] = {1, 0, 0, 1, 0, 1, 1};

        int sum[] = new int[arr.length];
        sum[0] = arr[0] == 0 ? -1 : 1;
        for (int i = 1; i < sum.length  ; i++) {
            sum[i] = sum[i-1]+arr[i-1]==0? -1 : 1;
        }

        Map<Integer, Integer> pos = new HashMap<Integer, Integer>();
        int maxLen = 0, i =0;
        for (int s : sum){
            if (s==0)
                maxLen = Math.max(maxLen, i+1);
            if (pos.containsKey(s))
                maxLen = Math.max(maxLen, i-pos.get(s));
            else
                pos.put(s,i);
            i++;
        }
        System.out.println("largestSubArrayWithEqualNumberOfZerosAndOnes : " + maxLen);
    }

    private static void printNextGreaterElementOnRight() {
        int input[] = {4,2,-8,6,0,-3,-1,1,9};
        int result[] = getAllLargers(input);
        for(int i=0; i < result.length; i++){
            if(result[i] != -1){
                System.out.print(input[result[i]] + " ");
            }else{
                System.out.print("NIL ");
            }
        }
    }

    private static int[] getAllLargers(int[] input) {
        Deque<Integer> stack = new LinkedList<Integer>();
        int result[] = new int[input.length];
        Arrays.fill(result, -1);

        stack.offerFirst(0);//would fail if there are negative elements. i think we should use INTEGER.MIN_VALUE
        for (int i = 0; i < input.length; i++) {
            while (stack.size() > 0){
                int t = stack.peekFirst();
                if(input[t] < input[i]){
                    result[t] = i;
                    stack.pollFirst();
                }else
                    break;
            }
            stack.offerFirst(i);
        }
        return result;
    }

    /*http://algorithmsandme.in/2014/12/find-kth-smallest-element-in-two-sorted-arrays/
     * http://stackoverflow.com/questions/4686823/given-2-sorted-arrays-of-integers-find-the-nth-largest-number-in-sublinear-time*/
    private static void kthElementInTwoSortedArray() {
        int a[] = {1, 4, 7, 11, 17, 21};
        int b[] = {-4, -1, 3, 4, 6, 28, 35, 41, 56, 70};
        findKthSmallestElement(a, b, a.length, b.length, 4);
    }

    public static int findKthSmallestElement(int a[], int b[], int sizeA, int sizeB, int k)
    {
        /* to maintain uniformaty, we will assume that size_a is smaller than size_b
            else we will swap array in call :) */
        if(sizeA > sizeB)
            return findKthSmallestElement(b, a, sizeB, sizeA, k);
        /* Now case when size of smaller array is 0 i.e there is no elemt in one array*/
        if(sizeA == 0 && sizeB >0)
            return b[k-1]; // due to zero based index

        /* case where K ==1 that means we have hit limit */
        if(k ==1)
            return Math.min(a[0], b[0]);

        /* Now the divide and conquer part */
        int i =  Math.min(sizeA, k/2) ; // K should be less than the size of array
        int j =  Math.min(sizeB, k/2) ; // K should be less than the size of array

        if(a[i-1] > b[j-1]){
            // Now we need to find only K-j th element
            b = Arrays.copyOfRange(b, j, b.length);
            return findKthSmallestElement(a, b, i, (sizeB-j), k-j);
        }
        else if(a[i-1] <= b[j-1]){
            a = Arrays.copyOfRange(a, i, a.length);
            return findKthSmallestElement(a, b, (sizeA-i), j, k-i);
        }
        return -1;
    }

    private static int maxcontiguouscircularsum() {
        int a[] = {9,6,-6,5,7};
        int n = a.length;

        // Case 1: get the maximum sum using standard kadane'
        // s algorithm
        int max_kadane = kadane(a);

        // Case 2: Now find the maximum sum that includes
        // corner elements.
        int max_wrap  =  0;
        for (int i = 0; i < n; i++)
        {
            max_wrap += a[i]; // Calculate array-sum
            a[i] = -a[i];  // invert the array (change sign)
        }

        // max sum with corner elements will be:
        // array-sum - (-max subarray sum of inverted array)
        max_wrap = max_wrap + kadane(a);

        // The maximum circular sum will be maximum of two sums
        return (max_wrap > max_kadane)? max_wrap: max_kadane;

    }

    static int kadane (int a[])
    {
        int n = a.length;
        int max_so_far = 0, max_ending_here = 0;
        for (int i = 0; i < n; i++)
        {
            max_ending_here = max_ending_here + a[i];
            if (max_ending_here < 0)
                max_ending_here = 0;
            if (max_so_far < max_ending_here)
                max_so_far = max_ending_here;
        }
        return max_so_far;
    }


    private static void increasingSubsequenceOfLenghth3WithMaxProduct() {
        /*http://www.geeksforgeeks.org/increasing-subsequence-of-length-three-with-maximum-product/*/
        int actualArr[] = {6,7,9,4,8,9};
        int RGN[] = new int[actualArr.length];
        int LGN[] = new int[actualArr.length];

        RGN[actualArr.length-1] = actualArr[actualArr.length-1];
        int max = actualArr[actualArr.length-1];

        for (int i = actualArr.length-2; i >=0 ; i--) {
            if(max < actualArr[i])
                max = actualArr[i];
            if(max > actualArr[i])
                RGN[i] = max;
            else
                RGN[i] = 0;
        }

        LGN[0] = 0;
        for (int i = 1; i < actualArr.length; i++) {
            getLGN(actualArr, i , LGN);
        }

        int maxProduct = 0;
        for(int i=1; i < actualArr.length-1; i++){
            int product = actualArr[i]*LGN[i]*RGN[i];
            if(maxProduct < product){
                maxProduct = product;
            }
        }

        System.out.println(maxProduct);
    }

    private static void getLGN(int arr[],int pos,int LGN[]){
        int max = 0;
        int i =0;
        while(i < pos){
            if(arr[i] < arr[pos]){
                if(arr[i] > max){
                    max = arr[i];
                }
            }
            i++;
        }
        LGN[pos] = max;
    }

    /*Create an algorithm that makes sure no group of integers of size bigger than M have the same integers*/
    private void groupElementsInSizeM() {
        int input[] = {2,1,5,1,3,5,3,3,4};
        int M = 4;

        Map<Integer, Integer> count = new HashMap<>();
        for (int i = 0; i < input.length; i++) {
            int c = 1;
            if(count.containsKey(i)){
                c = count.get(i);
                c++;
            }
            count.put(i,c);
        }

        PriorityQueue<Pair> maxHeap = new PriorityQueue<Pair>(count.size(), new Comparators());
        for (Integer s : count.keySet()){
            int c = count.get(s);
            if(c > Math.ceil(input.length/M)) {
                System.out.println("cannot group");
                return;
            }
            maxHeap.offer(new Pair(s,c));
        }
        int current = 0;
        int start = current;
        while (maxHeap.size() > 0){
            Pair p = maxHeap.poll();
            int i = 0;
            while (i<p.count){
                input[start] = p.num;
                start = start+M;
                if(start>=input.length){
                    current++;
                    start = current;
                }
                i++;
            }

        }
        return;
    }
    class Pair{
        int num;
        int count;

        public Pair(int num, int count) {
            this.num = num;
            this.count = count;
        }
    }
    public class Comparators implements Comparator<Pair>{

        @Override
        public int compare(Pair o1, Pair o2) {
            if(o1.count<=o2.count)
                return 1;
            else
                return -1;
        }
    }

    private static void gasStationCircle() {
        int[] gasAvailable = {4, 4, 6};
        int[] gasRequired = {5, 6, 1};
        System.out.println(startTour(gasAvailable, gasRequired));
    }

    private static int startTour(int[] gasAvailable, int[] gasRequired) {
        int start = -1;
        int end = 0;
        int currentGas = 0;
        boolean visitedOnce = false;
        while (start!=end){
            currentGas = gasAvailable[end]-gasRequired[end];
            if(start==-1)
                start = end;
            if(end == gasAvailable.length-1 && visitedOnce == false)
                visitedOnce = true;
            else if(end == gasAvailable.length-1 && visitedOnce == true)
                return -1;
            if(currentGas < 0)
            {
                start = -1;
                currentGas = 0;
            }
            end = (end+1)%gasAvailable.length;
        }
        return end;
    }

    private static void removeRepeatedDigits(int n) {
        int prev = n%10;
        int res = prev;
        int pow = 10;
        while (n !=0){//this will break cases where we have zero
            int curr = n%10;
            if(curr != prev){
                res += curr * pow;
                prev = curr;
                pow = pow * 10;
            }
            n = n/10;
        }
    }

    private static void stackSortInplace() {
        Stack stack = new Stack();
        sortInPlace(stack);
    }

    private static void sortInPlace(Stack stack) {
        if(!stack.isEmpty()){
            int x = (int) stack.pop();
            sortInPlace(stack);
            sortedInsert(stack,x);
        }
    }

    private static void sortedInsert(Stack stack, int x) {

        if(stack.isEmpty() || x > (int)stack.peek()){
            stack.push(x);
            return;
        }
        int temp = (int)stack.pop();
        sortedInsert(stack, x);
        stack.push(temp);
    }

    private static void diceThrowProblem() {

        /*Given n dice each with m faces, numbered from 1 to m, find the number of ways to get sum X. X is the summation of values on each face when all the dice are thrown.*/

        /*Let the function to find X from n dice is: Sum(m, n, X)
                The function can be represented as:
                Sum(m, n, X) = Finding Sum (X - 1) from (n - 1) dice plus 1 from nth dice
               + Finding Sum (X - 2) from (n - 1) dice plus 2 from nth dice
               + Finding Sum (X - 3) from (n - 1) dice plus 3 from nth dice
         */

        int mFaces = 4;
        int nDices = 3;
        int sum = 5;

        int table[][] = new int[nDices+1][sum+1];
        //table entries for 1 dice
        for (int i = 1; i <=mFaces && i<= sum ; i++) {
            table[1][i] = 1;
        }

        for (int i = 2; i <= nDices; i++)
            for (int j = 1; j <= sum; j++)
                for (int k = 1; k <= mFaces && k < j; k++)
                    table[i][j] += table[i-1][j-k];

        System.out.println("diceThrowProblem : " + table[nDices][sum]);

    }

    private static void eggDroppingProblem() {
        int eggs = 2, floors = 10;
        int res = eggDropRecusrsive(eggs, floors);
        System.out.println("Min eggs recursive : "+ res);
        int res2 = eggDropOptimized(eggs, floors);
        System.out.println("Min eggs optimized : "+ res2);
    }

    private static int eggDropOptimized(int eggs, int floors) {
        int eggFloor[][] = new int[eggs+1][floors+1];
        int res;
        // We need one trial for one floor and 0 trials for 0 floors
        for (int i = 1; i <= eggs; i++)
        {
            eggFloor[i][1] = 1;
            eggFloor[i][0] = 0;
        }

        // We always need j trials for one egg and j floors.
        for (int j = 1; j <= floors; j++)
            eggFloor[1][j] = j;

        // Fill rest of the entries in table using optimal substructure
        // property
        for (int i = 2; i <= eggs; i++) {
            for (int j = 2; j <= floors; j++) {
                eggFloor[i][j] = Integer.MAX_VALUE;
                for (int k = 1; k <= j; k++) {
                    res = 1+ Math.max(eggFloor[i-1][k-1], eggFloor[i][j-k]); //Watch tushar if you forget
                    if(res < eggFloor[i][j])
                        eggFloor[i][j] = res;
                }
            }
        }
        return eggFloor[eggs][floors];
    }

    private static int eggDropRecusrsive(int eggs, int floors) {
        if(floors ==0 || floors == 1) //If there are no floors then no trials needed
            return floors;

        if(eggs == 1)
            return floors;

        int min = Integer.MAX_VALUE;
        int res;
        for (int i = 1; i <= floors ; i++) {
            res = Math.max(eggDropRecusrsive(eggs-1, i-1), eggDropRecusrsive(eggs, floors-i));
            if(res < min)
                min = res;
        }
        return min+1;
    }

    private static void buySellManyTimesForMaxProfit() {
        int arr[] = {2, 6, 7, 19, 5, 6};
        int profit = 0;
        int localMin = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if(arr[i-1] >= arr[i])
                localMin = arr[i];//Dont buy till it decreases
            else
            {
                profit = arr[i] - localMin;
                localMin = arr[i];
            }
        }
        System.out.println(profit);
    }

    private static void buySellStockOneForMaxProfit() {
        int arr[] = {2, 6, 7, 19, 5, 6};
        int minPrice = arr[0];
        int maxProfit = 0;

        for (int i = 1; i < arr.length ; i++) {
            if(arr[i] - minPrice > maxProfit)
                maxProfit = arr[i]-minPrice;
            if(arr[i]<minPrice)
                minPrice = arr[i];
        }
        System.out.println(maxProfit);
    }

    private static void kthLargestElementInArray() {

        /*This is an optimization over method 1 if QuickSort is used as a sorting algorithm in first step. In QuickSort, we pick a pivot element, then move the pivot element to its
        correct position and partition the array around it. The idea is, not to do complete quicksort, but stop at the point where pivot itself is k’th smallest element.
        Also, not to recur for both left and right sides of pivot, but recur for one of them according to the
        position of pivot. The worst case time complexity of this method is O(n2), but it works in O(n) on average.*/

        //kthSmallest(int arr[], int l, int r, int k);

    }

    int kthSmallest(int arr[], int l, int r, int k)
    {
        // If k is smaller than number of elements in array
        if (k > 0 && k <= r - l + 1)
        {
            // Partition the array around last element and get
            // position of pivot element in sorted array
            int pos = partition(arr, l, r);

            // If position is same as k
            if (pos-l == k-1)
                return arr[pos];
            if (pos-l > k-1)  // If position is more, recur for left subarray
                return kthSmallest(arr, l, pos-1, k);

            // Else recur for right subarray
            return kthSmallest(arr, pos+1, r, k-pos+l-1);
        }

        // If k is more than number of elements in array
        return Integer.MAX_VALUE;
    }

    /*Standard partition process of QuickSort().  It considers the last
    element as pivot and moves all smaller element to left of it
    and greater elements to right */
    int partition(int arr[], int l, int r) {
        int x = arr[r], i = l;
        for (int j = l; j <= r - 1; j++) {
            if (arr[j] <= x) {
                //swap(&arr[i], &arr[j]);
                i++;
            }
        }
        //swap(&arr[i], &arr[r]);
        return i;
    }


    private static void maxIncreasingSubsequence() {
        int arr[] = {1, 101, 2, 3, 100, 4, 5};
        int n = arr.length;
        {
            int i, j, max = 0;
            int msis[] = new int[n];

            /* Initialize msis values for all indexes */
            for (i = 0; i < n; i++)
                msis[i] = arr[i];

            /* Compute maximum sum values in bottom up manner */
            for (i = 1; i < n; i++)
                for (j = 0; j < i; j++)
                    if (arr[i] > arr[j] &&  msis[i] < msis[j] + arr[i])
                        msis[i] = msis[j] + arr[i];

            /* Pick maximum of all msis values */
            for (i = 0; i < n; i++)
                if (max < msis[i])
                    max = msis[i];

            System.out.println(max);
        }
    }

    private static void longestCommonsSubsequence() {
        /*If last characters of both sequences match (or X[m-1] == Y[n-1]) then
        L(X[0..m-1], Y[0..n-1]) = 1 + L(X[0..m-2], Y[0..n-2])

        If last characters of both sequences do not match (or X[m-1] != Y[n-1]) then
        L(X[0..m-1], Y[0..n-1]) = MAX ( L(X[0..m-2], Y[0..n-1]), L(X[0..m-1], Y[0..n-2])*/

        //longestCommonsSubsequenceRecursive();
        //longestCommonSubsequenceOptimized();
    }

    private static int longestCommonSubsequenceOptimized(String[] X, String[] Y, int m, int n) {

        int L[][] = new int[m + 1][n + 1];
        int i, j;

    /* Following steps build L[m+1][n+1] in bottom up fashion. Note
      that L[i][j] contains length of LCS of X[0..i-1] and Y[0..j-1] */
        for (i = 0; i <= m; i++) {
            for (j = 0; j <= n; j++) {
                if (i == 0 || j == 0)
                    L[i][j] = 0;

                else if (X[i - 1] == Y[j - 1])
                    L[i][j] = L[i - 1][j - 1] + 1;

                else
                    L[i][j] = Math.max(L[i - 1][j], L[i][j - 1]);
            }
        }

        /* L[m][n] contains length of LCS for X[0..n-1] and Y[0..m-1] */
        return L[m][n];

    }

    private static int longestCommonsSubsequenceRecursive(String[] X, String[] Y, int m, int n) {

        if (m == 0 || n == 0)
            return 0;
        if (X[m - 1] == Y[n - 1])
            return 1 + longestCommonsSubsequenceRecursive(X, Y, m - 1, n - 1);
        else
            return Math.max(longestCommonsSubsequenceRecursive(X, Y, m, n - 1), longestCommonsSubsequenceRecursive(X, Y, m - 1, n));
    }

    private static void rodcutting() {
        int price[] = {3,5,8};
        int n = price.length;
        cutRod(price, n);
    }

    static int cutRod(int price[],int n)
    {
        int val[] = new int[n+1];
        val[0] = 0;

        // Build the table val[] in bottom up manner and return
        // the last entry from the table
        for (int i = 1; i<=n; i++)
        {
            int max_val = Integer.MIN_VALUE;
            for (int j = 0; j < i; j++)
            {
                max_val = Math.max(max_val, price[j] + val[i - j - 1]);
            }
            val[i] = max_val;
        }

        return val[n];
    }

    private static void weightedJobScheduling() {
        /*
        Given N jobs where every job is represented by following three elements of it.

        Start Time
        Finish Time
        Profit or Value Associated
        Find the maximum profit subset of jobs such that no two jobs in the subset overlap*/


        //Job arr[] =
        // Sort jobs according to finish time
        //sort(arr, arr+n, jobComparataor);

        // Create an array to store solutions of subproblems.  table[i]
        // stores the profit for jobs till arr[i] (including arr[i])
        // int *table = new int[n];
        // table[0] = arr[0].profit;

        // Fill entries in M[] using recursive property
        //for (int i=1; i<n; i++)
        /*{
            // Find profit including the current job
            int inclProf = arr[i].profit;
            int l = latestNonConflict(arr, i);
            if (l != -1)
                inclProf += table[l];

            // Store maximum of including and excluding
            table[i] = max(inclProf, table[i-1]);
        }

        // Store result and free dynamic memory allocated for table[]
        int result = table[n-1];
        delete[] table;

        return result;
    }

    /*int latestNonConflict(Job arr[], int i)
    {
        for (int j=i-1; j>=0; j--)
        {
            if (arr[j].finish <= arr[i].start)
                return j;
        }
        return -1;
    }*

    // A job has start time, finish time and profit.
    struct Job
    {
        int start, finish, profit;
    };
    /

    private static void minCostPathFromTopLeftToBottomRight() {
        /*res[i][j] = min(T[i-i)[j], T[i][j-1]*/
    }

    private static void maxSubsquareMatrix() {
        int arr[][] = {{0, 0, 1, 1},
                {1, 0, 1, 1},
                {0, 1, 1, 1},
                {1, 0, 1, 1}};

        int res[][] = new int[arr.length][arr[0].length];
        for (int i = 0; i < arr.length; i++) {
            res[i][0] = arr[i][0];
        }
        for (int i = 0; i < arr[0].length; i++) {
            res[0][i] = arr[0][i];
        }

        int max = 1;
        for (int i = 1; i < arr.length ; i++) {
            for (int j = 1; j < arr[0].length; j++) {
                if(arr[i][j]==0)
                    continue;
                int t = Math.min((Math.min(res[i-1][j],res[i-1][j-1])),res[i][j-1]);
                res[i][j] = t+1;
                if(max < res[i][j])
                    max = res[i][j];
            }
        }
    }

    private static void stairCaseProblem() {
        /*I can take 1 pr 2 steps, count number of ways to reach n*/
        //f[n] = f[n-1]+f[n-2];
        //if can take three steps too
        //f[n] = f[n-1]+f[n-2]+f[n-3];

        /*4 is 3+1 or 2+2, 3 is 2+1 or 1+2.. and so on*/
    }

    private static void totalwaysInMatrixFromSrcToDest() {
        int rows = 4;
        int cols = 4;

        int T[][] = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            T[i][0] = 1;
        }

        for (int i = 0; i < cols; i++) {
            T[0][i] = i;
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                T[i][j] = T[i-1][j]+T[i][j-1];
            }
        }
        System.out.println(T[rows-1][cols-1]);
    }

    /*private static void gasStationCircle() {
        int petrol[] = new int{6, 3, 7};
        int distance[] = new int{4, 6, 3};
        //struct petrolPump arr[] = {{6, 4}, {3, 6}, {7, 3}};

        int n = sizeof(arr)/sizeof(arr[0]);
        int start = printTour(arr, n);

        (start == -1)? printf("No solution"): printf("Start = %d", start);

        return 0;
    }

    int printTour(struct petrolPump arr[], int n)
    {
        // Consider first petrol pump as a starting point
        int start = 0;
        int end =  1;

        int curr_petrol = arr[start].petrol - arr[start].distance;

    //* Run a loop while all petrol pumps are not visited.
      And we have reached first petrol pump again with 0 or more petrol *//*
        while (end != start || curr_petrol < 0)
        {
            // If curremt amount of petrol in truck becomes less than 0, then
            // remove the starting petrol pump from tour
            while (curr_petrol < 0 && start != end)
            {
                // Remove starting petrol pump. Change start
                curr_petrol -= arr[start].petrol - arr[start].distance;
                start = (start + 1)%n;

                // If 0 is being considered as start again, then there is no
                // possible solution
                if (start == 0)
                    return -1;
            }

            // Add a petrol pump to current tour
            curr_petrol += arr[end].petrol - arr[end].distance;

            end = (end + 1)%n;
        }

        // Return starting point
        return start;
    }*/


        /*
        int circ(vector<int> &gas, vector<int> &cost) {
        int min_S=INT_MAX, S=0, position=0;
        for(int i=0;i<gas.size();i++)
        {
        S += gas[i] - cost[i];
        if(S<min_S)
        {
        min_S = S;
        position = (i+1) % gas.size();
        }
        }
        if(S>=0)
        return position;
        else
        return -1;
        }
*/

        /*Here's an approach that works in O(n) time and O(1) space (as opposed to O(n) space for Aryabhatta's answer).

        Start at any station, call it station 0, and advance until you run out of gas.
        If you don't run out of gas, done.
        Otherwise, if you run out between stations k and k+1, start over again at station k+1.
        Make a note if you pass 0 again, and if you run out after that it can't be done.

        The reason this works is because if you start at station i and run out of gas between stations k and k+1,
        then you will also run out of gas before station k+1 if you start at any station between i and k.

        Here's an algorithm, given an arrays P (petrol) and D (distance):

        int position = 0;
        int petrol = P[0];
        int distance = D[0];

        int start = 0;
        while (start < n) {
            while (petrol >= distance) {
                petrol += P[++position % N] - distance;
                distance = D[position % N];
                if (position % N == start)
                    return start;
            }
            start = position;
            petrol = P[start];
        }
        return -1;
*/

    private static boolean duplicateExistsWithinKIndices() {
        int arr[] = {1,2,3,5,6,3};
        int k = 3;
        Set s = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            if(s.contains(arr[i]))
                return true;
            if(i>k)
                s.remove(arr[i-k]);
            s.add(arr[i]);
        }
        return false;
    }

    private static void countDivisors() {

        /*You have been given
        3 integers l,
                r
        r and
        k
        k. Find how many numbers between
                l
        l and
        r
        r (both inclusive) are divisible by
                k
        k. You do not need to print these numbers, you just have to find their count.*/


    }

    private static void prodOfAllNumbers() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        String nums = br.readLine();
        String numberString[] = new String[N];
        numberString = nums.split(" ");

        int numbers[] = new int[N];
        System.out.println(numberString);

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(numberString[i]);
        }
        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }
        double prod = 1;


        System.out.println(N);
        while(N>0)
        {
            System.out.println("...");
            int temp = br.read();
            System.out.println(temp);
            prod = prod* numbers[N-1];
            //prod =
            N--;
        }
        System.out.println( prod % (Math.pow(10,9)+7));
    }

    private static void isPalindrome() {

        String line = "AAbAA";
        int len = line.length();
        int i = 0;
        int j = len-1;
        boolean isPalin = true;
        while(i<j)
        {
            if(line.charAt(i)!=line.charAt(j))
            {
                isPalin = false;
                break;
            }
            i++;j--;
        }
        if(isPalin)
            System.out.println("YES");
        else
            System.out.println("NO");
    }

    private static void changeAllUpperToLowerAndViceVersa() {
        System.out.print("changeAllUpperToLowerAndViceVersa : ");
        String line = "aBCFd";
        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            if (c > 96 && c < 123)
                c = (char) (c - 32);
            else if(c > 64 && c < 91)
                c = (char) (c + 32);
            System.out.print(c);
        }
        System.out.println();
    }

    private static void checkIfArrayElementsAreConsequtive() {
        int arr[] = {6,7,8,9};
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length ; i++) {
            if(min>arr[i])
                min = arr[i];
        }
        for (int i = 0; i < arr.length; i++) {
            if((Math.abs(arr[i])-min)>arr.length) {
                System.out.println("NO");
                break;
            }
            if((arr[Math.abs(arr[i])]-min)<0){
                System.out.println("NO");
                break;
            }
            arr[Math.abs(arr[i]-min)] = -arr[Math.abs(arr[i]-min)];
        }
    }

    private static void longestIncreasingSubsequence() {
        int arr[] = {3,4,-1,0,6,2,3};
        int lis[] = new int[arr.length];
        int actualSol[] = new int[arr.length];
        Arrays.fill(lis,1);
        for (int i = 0; i < actualSol.length; i++) {
            actualSol[i] = i;
        }
        for (int i = 0; i < arr.length ; i++) {
            for (int j = 0; j < i; j++) {
                if(arr[i]>arr[j] && lis[i]<lis[j]+1){
                    lis[i] = lis[j]+1;
                    actualSol[i]=j;
                }
            }
        }
        System.out.println("LongestIncreasingSubsequnce is : "+lis[arr.length-1]);
    }

    private static void implementationOfHeap() {
        List<Integer> items = new ArrayList<Integer>();
        siftUp(items);
        siftDown(items);
    }

    private static void siftUp(List<Integer> items) {
        int k = items.size() - 1;
        while (k > 0) {
            int p = (k - 1) / 2;
            Integer item = items.get(k);
            Integer parent = items.get(p);
            if (item > parent) {
                items.set(k, parent);
                items.set(p, item);
                k = p;
            } else
                break;
        }
    }

    private static void siftDown(List<Integer> items) {
        int k = 0;
        int left = 2*k+1;
        int l = 0;
        while(l<items.size()){
            int max = left;
            int right = l+1;
            if(right < items.size()){
                if(items.get(right)>items.get(left))
                    max = right;
            }
            if(items.get(k)>items.get(max)){
                int temp = items.get(k);
                items.set(k, items.get(max));
                items.set(max, temp);
                k = max;
                l = 2*k+1;
            }else
                break;
        }
    }

    private static void minimumcoinsForAParticularValue() {
        int coins[] = {9, 6, 5, 1};
        int sum = 11;
        int res = mincoinsOptimized(coins, sum);
        System.out.println("Mincoins optimized : " + res);
    }

    private static int mincoinsOptimized(int[] coins, int sum) {
        int table[] = new int[sum+1];
        table[0] = 0;
        for (int i = 1; i < table.length ; i++) {
            table[i] = Integer.MAX_VALUE;
        }

        for (int i = 1; i <= sum; i++) {
            for (int j = 0; j < coins.length ; j++) {
                if(coins[j] <= i){
                    int sub_res = table[i-coins[j]];
                    if(sub_res !=Integer.MAX_VALUE && sub_res+1 < table[i])
                        table[i] = sub_res+1;
                }
            }
        }
        return table[sum];
    }

    private static void minimumcoinsForAParticularValueRecursive() {
        int coins[] = {9, 6, 5, 1};
        int sum = 11;
        int res = mincoinsRecur(coins, sum);
        System.out.println("Mincoins recursive : " + res);
    }

    private static int mincoinsRecur(int[] coins, int sum) {
        if (sum == 0)
            return 0;
        int res = Integer.MAX_VALUE;
        //For each coin that is smaller than the sum
        for (int i = 0; i < coins.length; i++) {
            if (coins[i] <= sum) {
                int tempRes = mincoinsRecur(coins, sum - coins[i]);
                if (tempRes != Integer.MAX_VALUE && tempRes + 1 < res)
                    res = tempRes + 1;
            }
        }
        return res;
    }

    private static void numberOfWaysinfiniteCoinsParticularSum() {
        int[] coins = {1,2,3};
        int sum = 4;
        int table[] = new int[sum+1];

        Arrays.fill(table, 0);
        table[0] = 1;

        // Pick all coins one by one and update the table[] values
        // after the index greater than or equal to the value of the
        // picked coin
        for(int i=0; i< coins.length; i++)
            for(int j=coins[i]; j<= sum; j++)
                table[j] += table[j-coins[i]];

        System.out.println("numberOfWaysinfiniteCoinsParticularSum : "+ table[sum]);
    }

    private static void knapsack0_1() {
        int val[] = {60, 100, 120};
        int wt[] = {10, 20, 30};
        int  totalWt = 50;

        int knapsack[][] = new int[val.length+1][totalWt+1];
        for (int i = 0; i <= val.length; i++) {
            for (int j = 0; j <= totalWt; j++) {
                if (i == 0 || j == 0) {
                    knapsack[i][j] = 0;
                    continue;
                }
                if (wt[i - 1] <= j) {
                    knapsack[i][j] = Math.max(knapsack[i - 1][j],knapsack[i - 1][j - wt[i - 1]] + val[i - 1]);
                }else {
                    knapsack[i][j] = knapsack[i-1][j];
                }
            }
        }
        System.out.println("knapsack : " + knapsack[val.length][totalWt]);
    }

    private static void longestBitonicSequence() {
        int arr[] = {1, 11, 2, 10, 4, 5, 2, 1};
        int lis[] = new int[arr.length];
        int lds[] = new int[arr.length];
        Arrays.fill(lis,1);
        Arrays.fill(lds,1);

        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if(arr[i]>arr[j])
                    lis[i] = Math.max(lis[i],lis[j]+1);
            }
        }

        for (int i = arr.length - 2; i >= 0; i--) {
            for (int j = arr.length - 1; j > i; j--) {
                if (arr[i] > arr[j])
                    lds[i] = Math.max(lds[i], lds[j] + 1);
            }
        }

        int max = 0;
        for (int i=0; i < arr.length; i++)
        {
            int temp = lis[i]+lds[i]-1;
            if(max < temp)
                max = temp;
        }
        System.out.println("max bitonic seq : "+ max);
    }
}
