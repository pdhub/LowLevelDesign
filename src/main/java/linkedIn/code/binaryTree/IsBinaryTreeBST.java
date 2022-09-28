package linkedIn.code.binaryTree;

/**
 * Created by PDeb on 12/30/2017.
 */
public class IsBinaryTreeBST {

    public void checkTree(Node root){
        if(isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE))
            System.out.println(true);
        else
            System.out.println(false);
    }

    private boolean isBST(Node root, int minValue, int maxValue) {
        if(root == null)
            return true;

        if(root.key < minValue || root.key > maxValue)
            return true;

        return isBST(root.left, minValue, root.key) || isBST(root.right, root.key, maxValue);
    }
}
