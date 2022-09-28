
/**
 * Program to check if two nodes are cousins or not. Don't confuse it with sibling node.
 * Two nodes having same parent are siblings and not cousins.
 *
 *              20
 *      25              30
 * 5        10                  50
 *
 */
        import java.io.*;
        import java.util.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Solution
{
    public static void main (String[] args)
    {
        //System.out.println("Hello World!");

        Tree root = new Tree(20);
        root.left = new Tree(25);
        root.right = new Tree(30);
        root.left.left = new Tree(5);
        root.left.right = new Tree(10);
        root.right.right = new Tree(50);
        System.out.println(isCousins(root, 50, 100));


    }

    private static boolean isCousins(Tree root, int node1, int node2){
        Parent p1 = findParent(root, node1, 0);
        Parent p2 = findParent(root, node2, 0);
        if (p1 == null || p2 == null)
            return false;
        //System.out.println(p1.data + " " + p2.data);
        if (p1.data != p2.data && p1.level == p2.level)
            return true;
        return false;
    }

    private static Parent findParent(Tree root, int value, int level){
        if (root == null)
            return null;
        if ((root.left!=null && root.left.data == value) || (root.right!=null && root.right.data == value))
            return new Parent(root.data, level);
        Parent p1 = findParent(root.left, value, level+1);
        Parent p2 = findParent(root.right, value, level+1);
        return p1!=null?p1:p2;
    }

}
class Parent{
    int data;
    int level;

    public Parent(int data, int level) {
        this.data = data;
        this.level = level;
    }
}

class Tree {
    int data;
    Tree left;
    Tree right;

    public Tree() {}

    public Tree(int data) {
        this.data = data;
    }
}