package linkedIn.code.binaryTree;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by PDeb on 12/30/2017.
 */
public class VerticalSum {

    public void verticalSum(Node root){
        Map<Integer, Integer> map = new HashMap<>();
        calculateVerticalSum(root, 0, map);
        printVeticalSum(map);
    }

    private void printVeticalSum(Map<Integer, Integer> map) {
    }

    private void calculateVerticalSum(Node root, int dist, Map<Integer, Integer> map)
    {
        if(root == null)
            return;

        map.put(dist, map.get(dist)+root.key);
        calculateVerticalSum(root.right, dist+1, map);
        calculateVerticalSum(root.left, dist-1, map);
    }
}
