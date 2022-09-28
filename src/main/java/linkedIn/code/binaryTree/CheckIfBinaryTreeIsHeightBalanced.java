package linkedIn.code.binaryTree;

/**
 * Created by PDeb on 12/30/2017.
 */
public class CheckIfBinaryTreeIsHeightBalanced {

    public boolean isHeightBalanced(Node root)
    {
        Boolean isBalanced = false;
        isHeightBalanced(root, isBalanced);
        return isBalanced;
    }

    private int isHeightBalanced(Node root, Boolean isBalanced) {
        if(root == null)
            return 0;

        int leftHeight = isHeightBalanced(root, isBalanced);
        int rightHeight = isHeightBalanced(root, isBalanced);

        if(Math.abs(leftHeight-rightHeight) > 1)
            isBalanced = false;
        return Math.max(leftHeight, rightHeight) + 1;
    }

    private int isHeightBalanced1(Node root, boolean isBalanced)
    {
        if (root == null)
            return 0;

        int leftHeight = isHeightBalanced1(root.left, isBalanced);
        int rightHeight = isHeightBalanced1(root.right, isBalanced);

        if (Math.abs(leftHeight - rightHeight) > 1)
            isBalanced = false;
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
