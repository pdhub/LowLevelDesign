package linkedIn.code.binarySearchTree;

import linkedIn.code.binaryTree.Node;

/**
 * Created by PDeb on 12/31/2017.
 */
public class SearchKeyInBST {

    public boolean search(Node root, int key){
        if (root == null)
            return false;

        if (root.key == key)
            return true;

        if(key < root.key)
            return search(root.left, key);
        else
            return search(root.right, key);

    }
}
