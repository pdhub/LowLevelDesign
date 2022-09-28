package linkedIn.code.binaryTree;

import java.util.*;

/**
 * Created by PDeb on 1/3/2018.
 */
public class ReverseLevelOrderTraversal
{
    public void reverseLevelOrder(Node root)
    {
        if(root == null)
            return;

        Queue<Node> queue = new LinkedList<>();
        Stack<Node> stack = new Stack<>();
        queue.add(root);

        while (!queue.isEmpty())
        {
            Node temp = queue.poll();
            stack.push(temp);

            //First push right, then the left node
            if(temp != null)
            {
                queue.offer(temp.right);
                queue.offer(temp.left);
            }
        }

        while (!stack.isEmpty())
        {
            System.out.print(stack.pop().key + " ");
        }
    }

    public void reverseLevelOrderUsingHashing(Node root)
    {
        Map<Integer, List<Integer>> map = new LinkedHashMap<>();
        preOrder(root, 0, map);
    }

    private void preOrder(Node root, int level, Map<Integer, List<Integer>> map)
    {
        if(root == null)
            return;
        map.get(level).add(root.key);
        preOrder(root.left, level + 1, map);
        preOrder(root.right, level + 1, map);
    }
}
