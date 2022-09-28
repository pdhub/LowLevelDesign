package linkedIn.code.binaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by PDeb on 12/30/2017.
 */
public class CornerNodesOfEveryLevel {

    public void printCornerNodes(Node root){
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (queue.isEmpty()){
            int size = queue.size();
            int n = size;
            while (--n > 0){
                Node node = queue.poll();
                if (n == size-1 || n == 0)
                    System.out.println(node.key);
                if(node.right != null)
                    queue.offer(node.right);
                if(node.left != null)
                    queue.offer(node.left);
            }
        }
    }
}
