package linkedIn.code.binaryTree;

/**
 * Created by PDeb on 12/28/2017.
 */
public class CheckIfBinaryTreeIsSumTree {
    static class Node {
        int key;
        Node left, right;
    }

    public int isBinaryTreeSumTree(Node root){
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return root.key;
        if (root.key == isBinaryTreeSumTree(root.left) + isBinaryTreeSumTree(root.right))
            return 2 * root.key;
        return Integer.MIN_VALUE;
    }
}
