package linkedIn.code.binaryTree;

import java.util.List;
import java.util.Map;

/**
 * Created by PDeb on 1/3/2018.
 */
public class LevelOrderTraversalUsingMap
{
    public void levelOrder(Node root, int level, Map<Integer, List> levelToDataMap)
    {
        if(root == null)
            return;
        levelToDataMap.get(level).add(root.key);
        levelOrder(root.left, level+1, levelToDataMap);
        levelOrder(root.right, level+1, levelToDataMap);
    }
}
