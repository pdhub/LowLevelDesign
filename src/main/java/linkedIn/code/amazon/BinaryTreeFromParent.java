package linkedIn.code.amazon;

import linkedIn.code.binaryTree.Node;

import java.util.Arrays;

public class BinaryTreeFromParent{

    public static Node root;
    public static void main(String[] args) {
        int[] parent = {};
        createBinTree(parent);
    }

    private static void createBinTree(int[] parent) {
        Node[] createdNodes = new Node[parent.length];
        Arrays.fill(createdNodes, null);
        for (int i = 0; i < createdNodes.length; i++) {
            createNode(parent, i, createdNodes);
        }
    }

    private static void createNode(int[] parent, int i, Node[] createdNodes) {
        if(createdNodes[i] != null)
            return;
        createdNodes[i] = new Node(i, null, null);

        if (parent[i] == -1) {
            root = createdNodes[i];
            return;
        }

        if (createdNodes[parent[i]]==null) {
            createNode(parent, parent[i], createdNodes);
        }

        Node p = createdNodes[parent[i]];
        if (p.left == null)
            p.left = createdNodes[i];
        else
            p.right = createdNodes[i];

    }
}
