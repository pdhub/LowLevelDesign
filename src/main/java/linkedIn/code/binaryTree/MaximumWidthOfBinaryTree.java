package linkedIn.code.binaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by PDeb on 12/30/2017.
 */
public class MaximumWidthOfBinaryTree
{

    public int maxWidth(Node root)
    {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int max = Integer.MIN_VALUE;
        while (queue.isEmpty())
        {
            int size = queue.size();
            if(max < size)
            {
                max = size;
            }

            while (size-- > 0)
            {
                if(root.left != null)
                {
                    queue.offer(root.left);
                }
                if(root.right != null)
                {
                    queue.offer(root.right);
                }
            }
        }
        return max;
    }
}
