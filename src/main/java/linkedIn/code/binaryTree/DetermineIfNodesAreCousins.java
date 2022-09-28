package linkedIn.code.binaryTree;

/**
 * Created by PDeb on 1/3/2018.
 */
public class DetermineIfNodesAreCousins
{
    public void areNodesCousins(Node root, int level, Node x, Node y)
    {
        //do inorder, set parent of each node, then check level
        inorder(root, null, 0, x, y);
        if(x.parent != y.parent && x.level == y.level)
            System.out.println("yes");
        else
            System.out.println("no");
    }

    private void inorder(Node root, Node parent, int level, Node x, Node y)
    {
        if (root == null)
            return;

        inorder(root.left, root, 1, x, y);
        if (root.key == x.key)
        {
            x.level = level;
            x.parent = parent;
        }

        if (root.key == y.key)
        {
            y.level = level;
            y.parent = parent;
        }

        inorder(root.right, root, level + 1, x, y);
    }

    class Node
    {
        int key;
        Node left, right;
        Node parent;
        int level;
    }
}
