package linkedIn.code.binarySearchTree;

import linkedIn.code.binaryTree.Node;

/**
 * Created by PDeb on 11/2/2017.
 */
public class BinarySearchTreeInsertion {

    Node insert(Node root, int key)
    {
        if(root == null)
            root = new Node();
        if(root.key < key)
            root.left = insert(root.left, key);
        else
            root.right = insert(root.right, key);
        return root;
    }


    void insertNodeIterative(Node root, int key){
        if(root == null) {
            root = new Node();
            return;
        }
        Node current = root;
        Node parent = null;

        while (current !=null)
        {
            parent = current;
            if(key < current.key)
                current = current.left;
            else
                current= current.right;
        }

        if(key < parent.key)
            parent.left = new Node();
        else
            parent.right = new Node();
    }

    /*Time complexity is O(h) where h is the height of the tree, so we need to balance the tree like in AVL, so that insertion takes logarithmic time*/
}
