package solution2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Trie {
    Character c;
    Map<Character, Trie> map;
    boolean isLeaf;

    public Trie() {
        map = new HashMap<>();
        //this.c = c;
    }

    public void insert(String string){
        Trie trie = this;
        for (int i = 0; i < string.length(); i++) {
            Character c = string.charAt(i);
            if (!trie.map.containsKey(c))
                trie.map.put(c, new Trie());
            trie = trie.map.get(c);
        }
        trie.isLeaf = true;
    }

    public List<String> search(String string){
        Trie trie = this;
        List<String> list = new ArrayList<>();
        for (int i = 0; i < string.length(); i++) {
            Character c = string.charAt(i);
            if (!trie.map.containsKey(c)) {
                return list;
            }
            trie = trie.map.get(c);
        }
        buildList(list, trie, string);
        return list;
    }

    private void buildList(List<String> list, Trie trie, String currentString) {
        if (trie.isLeaf) {
            list.add(new String(currentString));
            return;
        }
        for (Character c : trie.map.keySet()) {
            currentString += c;
            buildList(list, trie.map.get(c), currentString);
            currentString = currentString.substring(0, currentString.length()-1);
        }
    }

}
