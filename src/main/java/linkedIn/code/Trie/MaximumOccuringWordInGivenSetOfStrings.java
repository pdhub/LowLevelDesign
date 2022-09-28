package linkedIn.code.Trie;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by PDeb on 12/18/2017.
 */
public class MaximumOccuringWordInGivenSetOfStrings {
    class TrieNode{
        String key;
        int count;
        //Only for leaf nodes, key is the string and count is its freq
        Map<Character, TrieNode> map = new HashMap<Character, TrieNode>();
    }

    String maxOccuringStr;
    Integer maxCount = 0;

    public TrieNode getNewNode(){
        TrieNode trieNode = new TrieNode();
        trieNode.count = 0;
        return trieNode;
    }

    public void insert(TrieNode head, String str)
    {
        TrieNode node = head;
        for (int i = 0; i < str.length(); i++) {
            if(!node.map.containsKey(str.charAt(i)))
                node.map.put(str.charAt(i), getNewNode());
            node = node.map.get(str.charAt(i));
        }

        //We are the leaf node now
        node.key = str;
        node.count++;
    }

    public void preorder(TrieNode node){
        if(node == null)
            return;
        for(Character c : node.map.keySet()){
            if(maxCount < node.map.get(c).count)
            {
                maxOccuringStr = node.map.get(c).key;
                maxCount = node.map.get(c).count;
            }
            preorder(node.map.get(c));
        }
    }

    public void calculate(){
        String words[] = {"code", "coder", "coding", "codable", "codec", "codecs", "coded",
        "codeless", "codec", "codecs", "codependence", "codex", "codify", "codependents",
        "codes", "code", "coder", "codesign", "codec", "codeveloper", "codrive", "codec",
        "codiscovered"};

        TrieNode node = getNewNode();
        for(String str: words)
            insert(node, str);



        preorder(node);
        System.out.println("Word : "+ maxOccuringStr + " Count : "+maxCount) ;
    }

    public static void main(String[] args) {
        new MaximumOccuringWordInGivenSetOfStrings().calculate();
    }
}
