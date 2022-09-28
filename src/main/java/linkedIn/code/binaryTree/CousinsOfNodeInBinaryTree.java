package linkedIn.code.binaryTree;

/**
 * Created by PDeb on 12/28/2017.
 */
public class CousinsOfNodeInBinaryTree {

    class Node{
        int key;
        Node left, right;
    }

    void printAllCousins(Node root, Node node){
        int level = 0;
        findlevel(root, node, 1, level);
        printLevel(root, node, level);
    }

    private void findlevel(Node root, Node node, int index, int level) {
        if(root == null || level==1)
            return;
        if(root.key == node.key)
            level = index;
        findlevel(root.left, node, index+1, level);
        findlevel(root.right, node, index+1, level);
    }

    private void printLevel(Node root, Node node, int level) {
        if(root == null)
            return;
        if(level==1)
            System.out.println(root.key);
        if(root.left!=null && root.left.key != node.key && root.right!=null && root.right.key != node.key)
        {
            printLevel(root.left, node, level-1);
            printLevel(root.right, node, level-1);
        }
    }
}
