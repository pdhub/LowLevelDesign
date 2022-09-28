package linkedIn.code.amazon;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class MergeMSortedlist {

    public static void main(String[] args) {
        List<List<Integer>> lists = Arrays.asList(
          Arrays.asList(10, 20, 30, 40),
                Arrays.asList(15, 25, 35),
                Arrays.asList(27, 29 , 37, 48, 93),
                Arrays.asList(32, 33)
        );

        mergeLists(lists);
    }

    static class ListNode implements Comparable<ListNode>{
        int val;
        int listNum;
        int index;

        public ListNode(int val, int listNum, int index) {
            this.val = val;
            this.listNum = listNum;
            this.index = index;
        }

        @Override
        public int compareTo(ListNode o) {
            return this.val-o.val;
        }
    }

    private static void mergeLists(List<List<Integer>> lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>();
        int listIndex = 0;
        for (List<Integer> l : lists) {
            for (Integer i : l){
                pq.add(new ListNode(i, listIndex, 0));
                break;
            }
            listIndex++;
        }

        while (!pq.isEmpty()){
            ListNode listNode = pq.poll();
            System.out.print(listNode.val + " ");
            if (listNode.index + 1 < lists.get(listNode.listNum).size()){
                int listNum = listNode.listNum;
                int index = listNode.index + 1;
                int val = lists.get(listNum).get(index);
                pq.add(new ListNode(val, listNum, index));
            }
        }
    }
}
