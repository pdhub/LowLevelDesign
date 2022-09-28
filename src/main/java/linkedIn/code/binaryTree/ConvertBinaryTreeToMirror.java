package linkedIn.code.binaryTree;

/**
 * Created by PDeb on 12/28/2017.
 */
public class ConvertBinaryTreeToMirror {
    public void convert(Node root){
        if(root == null)
            return;

        convert(root.left);
        convert(root.right);
        Node temp = root.left;
        root.left = root.right;
        root.right = temp;
    }

    public void mirror(Node root)
    {
        if(root == null)
            return;

        convert(root.left);
        convert(root.right);

        Node temp = root.left;
        root.left = root.right;
        root.right = temp;

    }
}
