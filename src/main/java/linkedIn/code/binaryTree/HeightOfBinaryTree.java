package linkedIn.code.binaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by PDeb on 1/3/2018.
 */
public class HeightOfBinaryTree
{
    public int heightRecusrsive(Node root)
    {
        if(root == null)
            return 0;
        int left = heightRecusrsive(root.left);
        int right = heightRecusrsive(root.right);

        return Math.max(left, right) + 1;
    }

    public int heightIterative(Node root)
    {
        Queue<Node> queue = new LinkedList<>();
        int maxheight = 0;
        queue.offer(root);
        while (queue.isEmpty())
        {
            int size = queue.size();
            while ( --size > 0 )
            {
                Node temp = queue.poll();
                if (temp != null)
                {
                    if (temp.right != null)
                    {
                        queue.offer(temp.right);
                    }
                    if (temp.left != null)
                    {
                        queue.offer(temp.left);
                    }
                }
            }
            maxheight++;
        }
        return maxheight;
    }
}
