package linkedIn.code.Trie;

public class WordBreakProblem1 {

    class TrieNode{
        boolean isLeaf;
        TrieNode[] next;

        public TrieNode() {
            next = new TrieNode[26];
            isLeaf = false;
        }
    }

    public void insertTrieNode(TrieNode head, String str){
        TrieNode node = head;
        for (int i = 0; i < str.length(); i++) {
            if(node.next[str.charAt(i) - 'a'] == null){
                node.next[str.charAt(i) - 'a'] = new TrieNode();
            }
        }
        node.isLeaf = true;
    }

    public boolean wordBreakExists(TrieNode node, String word){
        boolean[] exists = new boolean[word.length()+1];
        exists[0] = true;
        for (int i = 0; i < word.length(); i++) {
            if (exists[i]){
                TrieNode node1 = node;
                for (int j = i; j < word.length(); j++) {
                    if (node1 == null)
                        break;
                    node1 = node1.next[word.charAt(i) - 'a'];
                }
                if (node1 != null && node1.isLeaf == true)
                    exists[i] = true;
            }
        }
        return exists[word.length() + 1];
    }
}
