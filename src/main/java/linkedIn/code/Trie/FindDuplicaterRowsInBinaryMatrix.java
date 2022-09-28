package linkedIn.code.Trie;

import java.util.Arrays;

/**
 * Created by PDeb on 12/18/2017.
 */
public class FindDuplicaterRowsInBinaryMatrix {

    class TrieNode{
        boolean isLeaf;
        TrieNode nextNodes[] = new TrieNode[2];
    }

    public TrieNode getNewNode(){
        TrieNode trieNode = new TrieNode();
        trieNode.isLeaf = false;
        Arrays.fill(trieNode.nextNodes, null);
        return trieNode;
    }

    public boolean insert(TrieNode node, String str){
        if(node == null)
            return false;
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == ' ')
                continue;
            if(node.nextNodes[(str.charAt(i)) - '0']==null)
                node.nextNodes[(str.charAt(i)) - '0'] = getNewNode();
            node = node.nextNodes[(str.charAt(i))- '0'];
        }

        if(node.isLeaf)
            return false;
        return node.isLeaf = true;
    }

    public void isDuplicatePresent(){

        int matrix[][] = {
                {1,0,0,1,0},
                {0,1,1,0,0},
                {1,0,0,1,0},
                {0,0,1,1,0},
                {0,1,1,0,0}
        };

        TrieNode node = getNewNode();
        for (int i = 0; i < matrix[0].length; i++) {
            if(!insert(node, Arrays.toString(matrix[i]).replace('[',' ').replace(']',' ').replace(',',' '))){
                System.out.println(String.format("Duplicate found at Row %s ", i+1));
            }
        }
    }

    public static void main(String[] args) {
        new FindDuplicaterRowsInBinaryMatrix().isDuplicatePresent();
    }
}
