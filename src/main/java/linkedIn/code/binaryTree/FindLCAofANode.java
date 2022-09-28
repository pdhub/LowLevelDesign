package linkedIn.code.binaryTree;

/**
 * Created by PDeb on 12/28/2017.
 */
public class FindLCAofANode {

    //Can also be done by checking the value of the root and moving either left or right.
    //Also ensure to check first if the given values exist in the tree by doing a pre order
    Node lca;
    public boolean findLCA(Node root, int x, int y){
        if(root == null)
            return false;
        if(root.key == x || root.key == y){
            lca = root;
            return true;
        }

        boolean left = findLCA(root.left, x, y);
        boolean right = findLCA(root.right, x, y);

        //This will not work, if we have duplicates, in the tree, as the right will return true with the duplicate value.

        if(left && right){
            lca = root;
            return true;
        }
        return left || right;
    }

    public boolean lca(Node root, int x, int y)
    {
        if (root == null)
            return false;

        if (root.key == x || root.key == y)
            return true;

        boolean leftfound = lca(root.left, x, y);
        boolean rightFound = lca(root.right, x, y);

        if (leftfound && rightFound)
        {
            lca = root;
            return true;
        }
        return leftfound || rightFound;
    }

    public boolean isNodePresent(Node root, Node node)
    {
        if (root == null)
            return false;

        if (root.key == node.key)
            return true;

        return isNodePresent(root.left, node) || isNodePresent(root.right, node);
    }
}
