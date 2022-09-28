package linkedIn.code.binaryTree;

/**
 * Created by PDeb on 12/30/2017.
 */
public class DistanceBetweenNodes {

    public int findDistance(Node root, Node x, Node y)
    {
        Node lca = null;
        if(isPresent(root, x) && isPresent(root, y))
            lca = findLCA(root, x, y);
        else
            return Integer.MIN_VALUE;

        return findLevel(lca, x, 0) + findLevel(lca, y, 0);
    }

    private boolean isPresent(Node root, Node nodeValue)
    {
        if(root == null)
            return false;

        if(root.key == nodeValue.key)
            return true;

        return (isPresent(root.left, nodeValue) || isPresent(root.right, nodeValue));
    }

    public Node findLCA(Node node, Node x, Node y){
        if(node == null)
            return null;

        if(node.key == x.key || node.key == y.key)
            return node;

        Node left = findLCA(node.left, x, y);
        Node right = findLCA(node.right, x, y);

        if(left!=null && right!=null)
            return node;

        if(left!=null)
            return left;
        if(right!=null)
            return right;

        return null;
    }

    public int findLevel(Node root, Node x, Integer level){
        if(root == null)
            return Integer.MIN_VALUE;
        if(root.key == x.key)
            return level;
        int left = findLevel(root.left, x, level+1);
        if(left != Integer.MIN_VALUE)
            return left;
        return findLevel(root.right, x, level+1);
    }

    public void findDistanceBetweenNodes(Node root, Node x, Node y)
    {
        Node lca = null;
        if (isPresent(root, x) && isPresent(root, y))
        {
            lca = findLCA1(root, x, y);
        }

        int distanceToX = findLevel1(lca, x, 0);
        int distanceToY = findLevel1(lca, y, 0);

        System.out.println(distanceToX + distanceToY);
    }

    private int findLevel1(Node lca, Node x, int level)
    {
        if (lca == null)
            return 0;

        if (lca.key == x.key)
            return level;

        int left = findLevel1(lca.left, x, level + 1);
        if (left != 0)
            return left;

        return findLevel1(lca.right, x, level + 1);
    }

    private Node findLCA1(Node root, Node x, Node y)
    {
        if (root == null)
            return null;

        if (root.key == x.key || root.key == y.key)
            return root;

        Node leftLCA = findLCA1(root.left, x, y);
        Node rightLCA = findLCA1(root.right, x, y);

        if (leftLCA != null && rightLCA != null)
            return root;

        if (leftLCA != null)
            return leftLCA;

        if (rightLCA != null)
            return rightLCA;

        return null;
    }
}
