package linkedIn.code.amazon;

public class WordBreakProblem {
    class TrieNode{
        Character c;
        boolean isLeaf;
        TrieNode[] nodes = new TrieNode[26];

        public TrieNode(Character c) {
            this.c = c;
        }
    }
    
    public void insertIntoTrie(TrieNode head, String str){
        TrieNode node = head;
        for (int i = 0; i < str.length(); i++) {
            if (node.nodes[str.charAt(i)-'a'] == null)
                node.nodes[str.charAt(i)-'a'] = new TrieNode(str.charAt(i));
            node = node.nodes[str.charAt(i)-'a'];
        }
        node.isLeaf = true;
    }

    public boolean wordBreak(TrieNode head, String word){
        boolean[] good = new boolean[word.length()+1];
        good[0] = true;
        for (int i = 0; i < word.length(); i++) {
            if (good[i]){
                TrieNode node = head;
                for (int j = i; j < word.length(); j++) {
                    if (node == null)
                        break;
                    node = node.nodes[word.charAt(j) - 'a'];
                    if (node != null && node.isLeaf)
                        good[j + 1] = true;
                }
            }
        }
        return good[word.length()];
    }
}
