package linkedIn.code.binaryTree;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by PDeb on 12/29/2017.
 */
public class AncestorOfGivenNode {

    public void printAncestorsOfGivenNode(Node root, int node){
        if(root == null)
            return;
        Map<Integer, Integer> nodeToAncestor = new HashMap<>();
        nodeToAncestor.put(root.key, 0);
        setParent(root, nodeToAncestor);
        printBottomToTop(node, nodeToAncestor);
    }

    private void printBottomToTop(int node, Map<Integer, Integer> nodeToAncestor) {
        while (nodeToAncestor.get(node)!=null){
            node = nodeToAncestor.get(node);
            System.out.println(node);
        }
    }

    private void setParent(Node root, Map<Integer, Integer> nodeToAncestor) {
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            Node node = stack.pop();
            if(node.right!=null){
                nodeToAncestor.put(node.right.key, node.key);
                stack.push(node.right);
            }
            if(node.left!=null){
                nodeToAncestor.put(node.left.key, node.key);
                stack.push(node.left);
            }
        }
    }
}
