package linkedIn.code.binaryTree;

/**
 * Created by PDeb on 12/28/2017.
 */
public class DiameterOfATree {

    public int diameter = 0;//In C++ we could have passed the diameter as a pass by reference, to update its value. Here in java, we are having to create a public variable
    public void getDiameter(Node root){
        findDiameter(root);
    }


    private int findDiameter(Node root) {
        if(root == null)
            return 0;

        int leftHeight = findDiameter(root.left);
        int rightHeight = findDiameter(root.right);

        diameter = Math.max(diameter, leftHeight+rightHeight+1);
        int maxHeight = Math.max(leftHeight, rightHeight);
        return maxHeight+1;
    }

    private int diameter(Node root)
    {
        if (root == null)
            return 0;

        int leftHeight = diameter(root.left);
        int rightHeight = diameter(root.right);

        diameter = Math.max(diameter, leftHeight + rightHeight + 1);
        int maxHeight = Math.max(leftHeight, rightHeight);
        return maxHeight + 1;
    }
}
