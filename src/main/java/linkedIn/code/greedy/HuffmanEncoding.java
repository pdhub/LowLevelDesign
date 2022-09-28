package linkedIn.code.greedy;

import java.util.*;

/**
 * Created by PDeb on 12/17/2017.
 */

public class HuffmanEncoding {
    class HuffManNode{
        Character character;
        Integer freq;
        HuffManNode left, right;

        public HuffManNode(Character character, Integer freq, HuffManNode left, HuffManNode right) {
            this.character = character;
            this.freq = freq;
            this.left = left;
            this.right = right;
        }
    }

    class HuffManNodeComparator implements Comparator<HuffManNode>
    {
        @Override
        public int compare(HuffManNode left, HuffManNode right) {
            return left.freq.compareTo(right.freq);
        }
    }

    HuffManNode getNewNode(char ch, int freq, HuffManNode left, HuffManNode right){
        return new HuffManNode(ch, freq, left, right);
    }

    void encode(HuffManNode root, String str, Map<Character, String> huffManCode){
        if(root == null)
            return;
        if(root.left == null && root.right==null) {//found a leaf node
            huffManCode.put(root.character, str);
        }

        encode(root.left, str+"0", huffManCode);
        encode(root.right, str+"1", huffManCode);
    }

    void decode(HuffManNode root, int index, String str){
        if(root== null)
            return;
        if(root.left==null && root.right==null){
            System.out.print(root.character);
            return;
        }
        index++;
        if(index == str.length()-1)
            return;
        if(str.charAt(index)=='0')
            decode(root.left, index, str);
        else
            decode(root.right, index, str);
    }

    void buildHuffManTree(String text)
    {
        Map<Character, Integer> charToFreqMap = new HashMap<>();
        for (int i = 0; i < text.length(); i++) {
            Character c = text.charAt(i);
            if(charToFreqMap.containsKey(c)){
                charToFreqMap.put(c, ((Integer)charToFreqMap.get(c))+1);
            }
            else
            {
                charToFreqMap.put(c, 1);
            }
        }

        PriorityQueue<HuffManNode> pq = new PriorityQueue<>(new HuffManNodeComparator());
        for(Character character : charToFreqMap.keySet())
        {
            pq.offer(new HuffManNode(character, charToFreqMap.get(character), null, null));
        }

        while (pq.size()!=1)
        {
            int sum = 0;
            HuffManNode left = pq.poll();
            sum += left!=null?left.freq:0;
            HuffManNode right = pq.poll();
            sum += right!=null?right.freq:0;
            pq.offer(new HuffManNode('\0', sum, left, right));
        }

        HuffManNode root = pq.poll();
        Map<Character, String> charToString = new HashMap<>();
        encode(root, "", charToString);

        System.out.println("HuffMan codes are");
        String encodedString = "";
        for (Character c : charToString.keySet())
        {
            System.out.println(c + " : "+ charToString.get(c));
            encodedString += charToString.get(c);
        }
        System.out.println("Original String was : "+text);
        System.out.println("Encoded string is : "+encodedString);

        int index = -1;
        System.out.print("Decoded string is : ");
        while (index < text.length()-2)
            decode(root, index++, text);
    }

    public static void main(String[] args)
    {
        String text = "Huffman coding is a data compression algorithm.";
        HuffmanEncoding huffmanEncoding = new HuffmanEncoding();
        huffmanEncoding.buildHuffManTree(text);
    }
}

