package linkedIn.code.binarySearchTree;

import linkedIn.code.binaryTree.Node;

/**
 * Created by PDeb on 1/1/2018.
 */
public class FindKthSmallestAndKthLargest
{
    public int kthSmallest(Node root, int k)
    {
        //either do an inorder or keep count of k while doing an inorder
        Integer i = 0;
        return kthSmallest(root, i, k);
    }

    private int kthSmallest(Node root, Integer i, int k)
    {
        if(root == null)
            return Integer.MAX_VALUE;

        int left = kthSmallest(root.left, i+1, k);
        if(left != Integer.MAX_VALUE)
            return left;

        if(++i == k)
            return root.key;

        return kthSmallest(root.right, i, k);
    }

    public int kthLargest(Node root, int k)
    {
        //Do a reverse inorder traversal
        int i = 0;
        return kthLargest(root, i, k);
    }

    private int kthLargest(Node root, int i, int k)
    {
        if(root == null)
            return Integer.MAX_VALUE;

        int left = kthLargest(root.right, i, k);
        if(left != Integer.MAX_VALUE)
            return left;

        if(++i == k)
            return root.key;

        return kthSmallest(root.left, i, k);
    }

    //repeat
    public int kthSmallest1(Node root, Integer i, Integer k)
    {
        if (root == null)
            return Integer.MAX_VALUE;

        int left = kthSmallest1(root.left, i, k);

        if (left != Integer.MAX_VALUE)
            return left;
        if (++i == k)
            return root.key;

        return kthSmallest(root.right, i, k);
    }
}
