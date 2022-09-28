package linkedIn.code.binaryTree;

/**
 * Created by PDeb on 11/1/2017.
 */
public class Node {
    public int key;
    public Node left;
    public Node right;

    public Node() {
    }

    public Node(int key, Node left, Node right) {
        this.key = key;
        this.left = left;
        this.right = right;
    }
}
