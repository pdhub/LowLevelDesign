package solution;

import java.util.*;

public class WhatFix {

    //output [(b,4), (a,2), (d,2), (c,1), (e,1)]


    public static void main(String[] args) {
        String[] arr = {"a", "b", "d", "c", "a", "d", "b", "e", "b", "b"};
        char[] arr3 = {'a', 'b', 'd', 'c', 'a', 'd', 'b', 'e', 'b', 'b'};
        String[] arr2 = {"Pritom", "Pri", "Pritom"};
        String[] res = removeDuplicates(arr);
        for (String r : res)
            System.out.print(r + " ");
        System.out.println();
        String[] res2 = removeDuplicates(arr2);
        for (String r : res2)
            System.out.println(r + " ");


        Map<Character, Pair> map = new HashMap<>();
        for (int i = 0; i < arr3.length; i++) {
            if (map.containsKey(arr3[i])){
                Pair p = map.get(arr3[i]);
                p.count += 1;
                map.put(arr3[i], p);
            }else
            {
                Pair p = new Pair(arr3[i], 1);
                map.put(arr3[i], p);
            }
        }
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((a,b)->Integer.compare(b.count, a.count));
        for (Pair p : map.values()) {
            pq.offer(p);
        }
        while (!pq.isEmpty()){
            Pair p = pq.poll();
            System.out.print(p.c + " " + p.count + "|");
        }
    }

    private static String[]  removeDuplicates(String[] arr) {
        Trie trie = new Trie();
        List<String> res = new ArrayList<>();
        for (String s : arr)
        {
            if (!trie.search(s)) {
                //System.out.println("Inserting "+s);
                trie.insert(s);
                res.add(s);
            }
        }
        String[] res2 = new String[res.size()];
        for (int i = 0; i < res2.length; i++) {
            res2[i] = res.get(i);
        }

        return res2;
    }
}

class Pair{
    char c;
    int count;

    public Pair(char c, int count) {
        this.c = c;
        this.count = count;
    }
}

class Trie{

    Map<Character, Trie> map = new HashMap<>();
    boolean isLeaf = false;
    Character c;
    Trie(){}

    public void insert(String str){
        Trie trie = this;
        for(int i=0; i<str.length(); i++) {
            char c = str.charAt(i);
            if (!trie.map.containsKey(c))
                trie.map.put(c, new Trie());
            trie = trie.map.get(c);
        }
        trie.isLeaf = true;
    }

    public boolean search(String s){
        Trie trie = this;
        for (int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if (trie.map.containsKey(c))
                trie = trie.map.get(c);
            else
                return false;
        }
        return trie.isLeaf;
    }
}


