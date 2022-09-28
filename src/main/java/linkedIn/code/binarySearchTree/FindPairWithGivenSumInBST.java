package linkedIn.code.binarySearchTree;

import linkedIn.code.binaryTree.Node;

/**
 * Created by PDeb on 1/1/2018.
 */
public class FindPairWithGivenSumInBST
{
    public void findPair(Node root, int sum)
    {
        int minVal = minVal(root);
        int maxVal = maxVal(root);

        if(!findPair(root, root, minVal, maxVal, sum))
            System.out.println("Pair does not exist");
    }

    private int minVal(Node root)
    {
        while (root.left != null)
            root = root.left;
        return root.key;
    }

    private int maxVal(Node root)
    {
        while (root.right != null)
            root = root.right;
        return root.key;
    }

    private boolean findPair(Node X, Node Y, int x, int y, int sum)
    {
        if(X == null && Y == null)
            return false;

        if(x + y < sum)
        {
            if (findPair(X.left, Y, x, y, sum))
                return true;
            x = X.key;

            if(x+y == sum)
            {
                System.out.println("Pair found at "+x+" and "+y);
            }
            return findPair(X.right, Y, x, y, sum);
        }
        else if(x+y > sum)
        {
            if (findPair(X, Y.right, x, y, sum))
                return true;
            y = Y.key;
            if (x + y == sum)
            {
                System.out.println("Pair found at "+x+" and "+y);
            }
            return findPair(X, Y.left, x, y, sum);
        }
        return false;
    }
}
