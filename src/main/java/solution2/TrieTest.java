package solution2;

import java.util.ArrayList;
import java.util.List;

public class TrieTest {
    public static void main(String[] args) {
        Trie trie = new Trie();
        List<String> contacts = new ArrayList<>();
        contacts.add("Raj");
        contacts.add("Ravi");
        contacts.add("Shalini");

        for (String contact : contacts)
            trie.insert(contact);

        //System.out.println(trie.search("Ravi"));
        //System.out.println(trie.search("Ra"));
        System.out.println(trie.search("Ravi"));
        System.out.println(trie.search("Ravinjan"));
    }
}
