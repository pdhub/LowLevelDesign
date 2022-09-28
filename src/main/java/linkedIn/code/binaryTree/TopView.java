package linkedIn.code.binaryTree;

import java.util.Map;

/**
 * Created by PDeb on 1/3/2018.
 */
public class TopView
{
    public void topview(Node root, int hordist, int level, Map<Integer, NodeToLevel> map)
    {
        if (map.get(hordist) == null || level < map.get(hordist).level)
            map.put(hordist, new NodeToLevel(root.key, level));

        topview(root.left, hordist - 1, level + 1, map);
        topview(root.right, hordist + 1, level + 1, map);
    }

    class NodeToLevel
    {
        int key;
        int level;

        public NodeToLevel(int key, int level)
        {
            this.key = key;
            this.level = level;
        }
    }
}
