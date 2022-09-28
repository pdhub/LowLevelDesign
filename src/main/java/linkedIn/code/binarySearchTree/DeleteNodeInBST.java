package linkedIn.code.binarySearchTree;

import linkedIn.code.binaryTree.Node;

/**
 * Created by PDeb on 12/31/2017.
 */
public class DeleteNodeInBST
{
    public void delete(Node root, int key)
    {
        Node parent = null;
        Node curr = root;

        //Sets parent of node to be deleted
        search(curr, key, parent);

        //if key not found, return
        if(curr == null)
            return;

        //if node to delete is leaf
        if(curr.left == null && curr.right == null)
        {
            if (parent.left == curr)
                parent.left = null;
            else
                parent.right = null;
        }
        //its not a leaf
        else if(curr.left != null && curr.right !=null)
        {
            Node succesor = minimumKey(curr.right);
            int val = succesor.key;
            delete(root, val);//recursively delete
            curr.key = val;
        }
        //if one node
        else
        {
            Node child = root.left == null ? root.right : root.left;
            //If node to be deleted is not a root node
            if(curr != root)
            {
                if(curr == parent.left)
                    parent.left = child;
                else
                    parent.right = child;
            }
            else
                root = child;
        }
    }

    private void search(Node curr, int key, Node parent)
    {
        while (curr !=null && curr.key != key)
        {
            parent = curr;
            if(curr.key < key)
                curr = curr.left;
            else
                curr = curr.right;
        }
    }


    private Node minimumKey(Node node)
    {
        while (node.left != null)
            node = node.left;
        return node;
    }

    //Repeat 1

    public void deleteNodeInBST(Node root, int key)
    {
        if (root == null)
            return;

        Node current = root;
        Node parent = null;

        searchNodeToDelete(root, current, key, parent);
        if (current == null)
            return; // Node to delete is not found

        if (current.left == null && current.right == null)
        {
            if (current != root)
            {
                if (parent.left == current)
                    parent.left = null;
                else
                    parent.right = null;
            }
            else
                root = null; // If tree has only one root, delete it
        }

        else if (current.left != null && current.right !=null)
        {
            Node successor = findMinimum(current.right);
            int tempVal = successor.key;
            delete(root, successor.key);
            current.key = tempVal;
        }
        else // Node to delete has only one child
        {
            current.key = current.left!=null?current.left.key:current.right.key;
            if (current.left != null)
                current.left = null;
            else
                current.right = null;
        }
    }

    private Node findMinimum(Node node)
    {
        while (node.left != null)
            node = node.left;
        return node;
    }

    private void searchNodeToDelete(Node root, Node current, int key, Node parent)
    {
        while (current != null && current.key != key)
        {
            parent = current;
            if (key < current.key)
                current = current.left;
            else
                current = current.right;
        }
    }
}
