package linkedIn.code.binaryTree;

import java.util.Vector;

/**
 * Created by PDeb on 12/28/2017.
 */
public class AllPatFromRootToLeaf {

    public void rootToLeaf(Node node, Vector<Integer> path){
        if(node == null)
            return;

        path.add(node.key);

        if(node.left == null && node.right == null)
        {
            for(Integer values : path)
                System.out.println(values);
        }

        rootToLeaf(node.left, path);
        rootToLeaf(node.right, path);

        path.remove(node.key);// This removal part is important
    }
}
