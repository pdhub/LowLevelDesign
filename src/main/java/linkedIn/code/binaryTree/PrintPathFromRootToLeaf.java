package linkedIn.code.binaryTree;

/**
 * Created by PDeb on 12/30/2017.
 */
public class PrintPathFromRootToLeaf {

    public void printRootToLeafNodes(Node root){
        int sum = rootToLeafSum(root);
        printRootToLeaf(root, sum);
    }

    private boolean printRootToLeaf(Node root, int sum) {
        if(sum == 0)
            return true;
        if(root == null)
            return false;

        boolean left = printRootToLeaf(root.left, sum-root.key);
        boolean right = printRootToLeaf(root.right, sum-root.key);

        if(left || right)
            System.out.println(root.key);
        return left || right;
    }

    private int rootToLeafSum(Node root) {
        if(root == null)
            return 0;
        int left = rootToLeafSum(root.left);
        int right = rootToLeafSum(root.right);

        return (left>right ? left : right) + root.key;
    }
}
