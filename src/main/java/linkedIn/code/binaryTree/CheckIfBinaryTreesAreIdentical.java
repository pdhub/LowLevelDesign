package linkedIn.code.binaryTree;

import java.util.Stack;

/**
 * Created by PDeb on 11/1/2017.
 */
public class CheckIfBinaryTreesAreIdentical {
    public boolean isIdenticalRecursive(Node x, Node y){
        if(x == null && y == null)
            return true;
        return (x!=null && y!=null) && (isIdenticalRecursive(x.left, y.left))&&(isIdenticalRecursive(x.right, y.right));
    }

    public boolean isIdenticalIterative(Node x, Node y){
        if(x==null && y==null)return true;
        if(x==null) return false;
        if(y==null) return false;

        Stack<PairNode> stack = new Stack<PairNode>();
        PairNode pairNode = new PairNode(x, y);
        stack.push(pairNode);
        while (!stack.isEmpty()){
            PairNode pairNodePopped = stack.pop();
            if(pairNodePopped.x.key != pairNode.y.key)
                return false;

            if(pairNodePopped.x.left.key == pairNodePopped.y.left.key)
                stack.push(new PairNode(pairNodePopped.x.left, pairNode.y.left));
            else if((pairNodePopped.x.left == null) || (pairNodePopped.y.left == null))
                return false;

            if(pairNodePopped.x.right.key == pairNodePopped.y.right.key)
                stack.push(new PairNode(pairNodePopped.x.right, pairNode.y.right));
            else if((pairNodePopped.x.right == null) || (pairNodePopped.y.right == null))
                return false;
        }

        return true;
    }

    class PairNode{
        Node x;
        Node y;

        public PairNode(Node x, Node y) {
            this.x = x;
            this.y = y;
        }
    }
}
