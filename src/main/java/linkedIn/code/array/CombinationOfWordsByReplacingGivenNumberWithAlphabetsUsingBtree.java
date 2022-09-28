package linkedIn.code.array;

public class CombinationOfWordsByReplacingGivenNumberWithAlphabetsUsingBtree {
    private static final String alphabets = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static void main(String[] args) {
        int[] arr = {1, 2, 2};
        Node node = new Node("");
        construct(node, arr, 0);
        printNodes(node);
    }

    private static void printNodes(Node node) {
        if (node == null)
            return;
        if (node.left == null && node.right == null)
        {
            System.out.println(node.key);
        }
        else {
            printNodes(node.left);
            printNodes(node.right);
        }
    }

    private static void construct(Node root, int[] arr, int i) {
        if (i == arr.length)
            return;
        if ( i+1 < arr.length){
            int sum = 10 * arr[i] + arr[i + 1];
            if (sum <= 26){
                root.left = new Node(root.key + alphabets.charAt(sum - 1));
            }
            construct(root.left, arr, i + 2);
        }
        root.right = new Node(root.key + alphabets.charAt(arr[i] - 1));
        construct(root.right, arr, i + 1);
    }

    static class Node{
        String key;
        Node left, right;
        public Node(String key) {
            this.key = key;
            left = null;
            right = null;
        }
    }
}
