package linkedIn.code.binaryTree;

/**
 * Created by PDeb on 1/4/2018.
 */
public class MaximumRootToLeafSum
{
    public void rootToLeafSum(Node root)
    {
        int sum = findMaxRootToLeafSum(root);
        System.out.println(sum);
        printSum(root, sum);
    }

    private int findMaxRootToLeafSum(Node root)
    {
        if (root == null)
            return 0;

        int leftSum = findMaxRootToLeafSum(root.left);
        int rightSum = findMaxRootToLeafSum(root.right);

        return ( leftSum > rightSum ? leftSum : rightSum ) + root.key;
    }

    private boolean printSum(Node root, int sum)
    {
        if (sum == 0)
            return true;

        if (root == null)
            return false;

        boolean left = printSum(root.left, sum - root.key);
        boolean right = printSum(root.right, sum - root.key);

        if (left || right)
            System.out.println(root.key);

        return left || right;
    }
}
