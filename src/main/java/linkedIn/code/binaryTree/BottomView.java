package linkedIn.code.binaryTree;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by PDeb on 1/3/2018.
 */
public class BottomView
{
    public void printBottomView(Node root)
    {
        Map<Integer, NodeLevelToKey> map = new HashMap<>();
        printBottomView(root, 0, 0, map);
    }

    private void printBottomView(Node root, int horizontalDist, int level, Map<Integer, NodeLevelToKey> map)
    {
        if(root == null)
            return;
        if (map.get(horizontalDist) == null || level > map.get(horizontalDist).level)
            map.put(horizontalDist, new NodeLevelToKey(level, root.key));
        printBottomView(root.left, horizontalDist - 1, level + 1, map);
        printBottomView(root.right, horizontalDist + 1, level + 1, map);
    }

    class NodeLevelToKey
    {
        int level;
        int key;

        public NodeLevelToKey(int level, int key)
        {
            this.level = level;
            this.key = key;
        }
    }
}
