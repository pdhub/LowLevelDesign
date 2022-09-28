package linkedIn.code.Trie;

import java.util.Arrays;
import java.util.Objects;

/**
 * Created by PDeb on 12/17/2017.
 */
public class Trie {
    private final int CHAR_SIZE = 26;
    class TrieNode{
        int isLeaf;
        TrieNode characters[] = new TrieNode[CHAR_SIZE];
    }

    public TrieNode getNewTrieNode(){
        TrieNode trieNode = new TrieNode();
        trieNode.isLeaf = 0;
        Arrays.fill(trieNode.characters, null);
        return trieNode;
    }

    public void insert(TrieNode head, String str){
        TrieNode node = head;
        int i = 0;
        while(i < str.length()){
            char c = str.charAt(i);
            if(node.characters[(int)c - 'a'] == null)
                node.characters[(int)c - 'a'] = getNewTrieNode();
            node = node.characters[(int)c - 'a'];
            i++;
        }
        node.isLeaf = 1;
    }

    public int search(TrieNode head, String str){
        if(Objects.isNull(head))
            return 0;
        int i = 0;
        TrieNode curr = head;
        while(i < str.length())
        {
            curr = curr.characters[str.charAt(i) - 'a'];
            if(Objects.isNull(curr))
                return 0;
            i++;
        }
        return curr.isLeaf;
    }

    public boolean delete(TrieNode curr, String str, int i){
        if(Objects.isNull(curr))
            return false;
        while(i < str.length())
        {
            if(Objects.nonNull(curr) && (curr.characters[str.charAt(i) - 'a']!=null)
                && delete(curr.characters[str.charAt(i)-'a'], str, i+1)
                && curr.isLeaf == 0)
            {
                if(!haveChildren(curr))
                {
                    curr = null;
                    return true;        
                }
                else 
                    return false;
            }
        }

        if(i == str.length()-1 && curr.isLeaf == 1){
            if(!haveChildren(curr)){
                curr = null;
                return true;
            }
            else
            {
                curr.isLeaf = 0;
                return false;
            }
        }
        return false;
    }

    private boolean haveChildren(TrieNode curr) {
        for (int i = 0; i < curr.characters.length; i++) {
            if(curr.characters[i]!=null)
                return true;
        }
        return false;
    }

    public void allOperations(){
        TrieNode head = getNewTrieNode();
        insert(head, "hello");
        System.out.println(search(head, "hello"));
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.allOperations();
    }
}
