package linkedIn.code.binaryTree;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by PDeb on 12/30/2017.
 */
public class DiagonalSum {

    public void diagonalSum(Node root)
    {
        Map<Integer, Integer> map = new HashMap<>();
        calculateDiagonalSum(root, 0, map);

    }

    private void calculateDiagonalSum(Node root, int diagonal, Map<Integer, Integer> map) {
        if(root == null)
            return;

        map.put(diagonal, map.get(diagonal)+root.key);
        calculateDiagonalSum(root.right, diagonal, map);
        calculateDiagonalSum(root.left, diagonal - 1, map);
    }
}
