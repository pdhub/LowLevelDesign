package linkedIn.code.binaryTree;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by PDeb on 1/3/2018.
 */
public class LeftViewOfBinaryTree
{
    public void leftView(Node root)
    {
        Map<Integer, Integer> map = new HashMap<>();
        printLeftView(root, 0, map);
        //We can also use level order traversal, and print the first node of each level
    }

    private void printLeftView(Node root, int level, Map<Integer, Integer> map)
    {
        if (map.get(level) != null)
            map.put(level, root.key);
        printLeftView(root.right, level + 1, map);
        printLeftView(root.left, level + 1, map);
    }
}
