package linkedIn.code.binaryTree;

/**
 * Created by PDeb on 12/28/2017.
 */
public class ConvertBinaryTreeToSumTree {

    class Node{
        int data;
        Node left, right;
    }

    public int convert(Node root){
        if (root == null)
            return 0;
        int temp = root.data;
        root.data = convert(root.left) + convert(root.right);
        return temp + root.data;
    }
}
