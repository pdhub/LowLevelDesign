package linkedIn.code.binaryTree;

import java.util.Stack;

/**
 * Created by PDeb on 1/1/2018.
 */
public class BinaryTreesAreIdentical
{
    public boolean isIdentical(Node x, Node y)
    {
        if(x == null && y == null)
            return true;

        return ((x != null && y != null) && (x.key == y.key) && isIdentical(x.left, y.left) && (isIdentical(x.right, y.right)));
    }

    public boolean isIdenticalIterative(Node x, Node y)
    {
        //use a Stack of node pair
        //Stack<NodePair> stack = new Stack<NodePair>()
        return true;
    }

    class NodePair
    {
        Node x, y;

        public NodePair(Node x, Node y)
        {
            this.x = x;
            this.y = y;
        }
    }
}
