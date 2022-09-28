package solution;

import java.util.ArrayList;
import java.util.List;

public class Recursion {

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }


    public List<TreeNode> generateTrees(int n) {
        if(n==0)
            return new ArrayList();
        return generate(1, n);
    }

    public List<TreeNode> generate(int start, int end){
        List<TreeNode> list = new ArrayList();
        if(start > end){
            list.add(null);
            return list;
        }
        for(int idx = start; idx <= end; idx++){
            for(TreeNode left : generate(start, idx-1)){
                for(TreeNode right : generate(idx+1, end)){
                    //printList(left);
                    //printList(right);
                    TreeNode node = new TreeNode(idx);
                    node.left = left;
                    node.right = right;
                    list.add(node);
                }
            }
        }
        return list;
    }


    public static void main(String[] args) {
//        int[] arr = new int[]{4, 3, 6, -1, 0, 1, 2, 5};
//        mergeSort(arr, 0, arr.length-1);
//        for (int i = 0; i < arr.length; i++) {
//            System.out.print(arr[i] + " ");
//        }
        new Recursion().generateTrees(3);
    }

    public static void mergeSort(int[] arr, int start, int end){
        if(start < end){
            int mid = (start + end)/2;
            mergeSort(arr, start, mid);
            mergeSort(arr, mid+1, end);
            merge(arr, start, mid, end);
        }
    }

    public static void merge(int arr[], int start, int mid, int end){
        int temp[] = new int[end-start+1];
        int i=start, j=mid+1, k=0;
        while (i<=mid && j<=end){
            if(arr[i] <= arr[j]){
                temp[k++] = arr[i++];
            }else
                temp[k++] = arr[j++];
        }
        while (i<=mid){
            temp[k++] = arr[i++];
        }
        while (j<=end){
            temp[k++] = arr[j++];
        }
        for (int l = start; l <= end ; l++) {
            arr[l] = temp[l-start];
        }
    }
}
