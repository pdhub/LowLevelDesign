package linkedIn.code.binaryTree;

import java.util.Arrays;

public class CreateTreeFromParent {

    static class Node{
        int val;
        Node left;
        Node right;
        public Node(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        int arr[] = {-1, 0, 0, 1, 1, 3, 5};
        Node created[] = new Node[arr.length];
        Arrays.fill(created, null);
        for (int i = 0; i < arr.length; i++) {
            createBinaryTree(arr, i, created);
        }
    }

    private static void createBinaryTree(int[] parent, int i, Node[] created) {
        if (created[i] != null)
            return;
        created[i] = new Node(i);

        if (parent[i] == -1)
            return;

        if (created[parent[i]] == null){
            createBinaryTree(parent, parent[i], created);
        }

        Node p = created[parent[i]];
        if (p.left == null)
            p.left = created[i];
        else
            p.right = created[i];
    }
}
