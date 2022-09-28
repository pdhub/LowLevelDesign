package linkedIn.code.Trie;

import java.util.Arrays;

/**
 * Created by PDeb on 12/18/2017.
 */
public class WordBreakProblem {
    class TrieNode{
        boolean isleaf;
        TrieNode next[] = new TrieNode[26];
    }

    TrieNode getNewTrieNode(){
        TrieNode trieNode = new TrieNode();
        trieNode.isleaf = false;// Not a leaf node
        Arrays.fill(trieNode.next, null);
        return trieNode;
    }

    void insert(TrieNode head, String str){
        TrieNode node = head;
        for (int i = 0; i < str.length(); i++) {
            if(node.next[str.charAt(i) - 'a']==null)
                node.next[str.charAt(i)-'a'] = new TrieNode();
            node = node.next[str.charAt(i)-'a'];
        }
        node.isleaf = true;//marking node as leaf
    }

    boolean wordBreak(TrieNode head, String str){
        int n = str.length();
        boolean good[] = new boolean[n+1];
        good[0] = true;
        for (int i = 0; i < n; i++) {
            if(good[i]){//We can break the string till index i into the dictionary word
                TrieNode node = head;
                for (int j = i; j < n; j++) {
                    if(node==null){
                        break;
                    }
                    node = node.next[str.charAt(j) - 'a'];
                    if(node !=null && node.isleaf)
                        good[j+1] = true;
                }
            }
        }
        return good[n];
    }

    public void checkIfWordCanBeBroken(){
        String words[] = {"this", "th", "is", "famous", "word", "break", "b", "r", "e",
                "a", "k", "br", "bre", "brea", "ak", "prob", "lem"};

        TrieNode node = getNewTrieNode();
        for(String word : words)
            insert(node, word);

        String str = "wordbreakproblem";
        if(wordBreak(node, str))
            System.out.println("Word can be broken");
        else
            System.out.println("Word cannot be broken");
    }

    public static void main(String[] args) {
        new WordBreakProblem().checkIfWordCanBeBroken();
    }
}
