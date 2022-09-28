package linkedIn.code.binarySearchTree;

import linkedIn.code.binaryTree.Node;

/**
 * Created by PDeb on 1/1/2018.
 */
public class FindLCAinBST
{
    void LCA(Node root, int x, int y)
    {
        if(root == null || !search(root, x) || !search(root, y))
            return;

        Node lca = lcaRecursive(root, x, y);
    }

    private boolean search(Node root, int x)
    {
        while (root != null)
        {
            if(root.key < x)
                root = root.right;
            else if(root.key > x)
                root = root.left;
            else
                return true;
        }
        return false;
    }

    private Node lcaRecursive(Node root, int x, int y)
    {
        if(root == null)
            return null;
        if(root.key > Math.max(x, y))
        {
            return lcaRecursive(root.left, x, y);
        }

        if(root.key < Math.min(x, y))
        {
            return lcaRecursive(root.right, x, y);
        }

        return root;
    }
}
