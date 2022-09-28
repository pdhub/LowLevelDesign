package linkedIn.code;

import java.util.*;

public class WordLadder2 {
    public static void main(String[] args) {

    }

    public List<List<String>> findLadders(String start, String end, List<String> wordList){
        HashSet<String> uniqueWords = new HashSet<>(wordList);
        Map<String, List<String>> wordToNeighbours = new HashMap<>();
        Map<String, Integer> wordToDistance = new HashMap<String, Integer>();
        List<List<String>> res = new ArrayList<>();
        buildGraph(start, end, wordToNeighbours, wordToDistance, wordList);
        dodfs(start, end, wordToNeighbours, new ArrayList<String>(), wordToDistance, res);
        return res;
    }

    private void dodfs(String start, String end, Map<String, List<String>> wordToNeighbours, ArrayList<String> temp, Map<String, Integer> wordToDistance, List<List<String>> res) {
        temp.add(start);
        if (start.equals(end))
            res.add(new ArrayList<>(temp));
        else {
            for(String neighbour : wordToNeighbours.get(start)){
                if (wordToDistance.get(neighbour) == wordToDistance.get(start)+1){
                    dodfs(neighbour, end, wordToNeighbours, temp, wordToDistance, res);
                }
            }
        }
        temp.remove(res.size()-1);
    }

    private void buildGraph(String start, String end,
                            Map<String, List<String>> wordToNeighbours,
                            Map<String, Integer> wordToDistance, List<String> wordList) {
        for(String word : wordList)
            wordToNeighbours.put(word, new ArrayList<String>());
        Queue<String> q = new ArrayDeque<>();
        q.offer(start);
        wordToDistance.put(start, 0);
        boolean foundEnd = false;
        while (!q.isEmpty()){
            int queueSize = q.size();
            while (queueSize-- > 0){
                String currentWord = q.poll();
                int currentDepth = wordToDistance.get(currentWord);
                List<String> neighbours = getNeighbours(currentWord, wordList);
                for(String neighbour : neighbours){
                    wordToNeighbours.get(currentWord).add(neighbour);
                    wordToDistance.putIfAbsent(neighbour, currentDepth+1);
                    if (neighbour.equals(end))
                        foundEnd = true;
                    q.offer(neighbour);
                }
            }
            if (foundEnd)
                break;
        }
    }

    private List<String> getNeighbours(String currentWord, List<String> wordList) {
        List<String> neighbors = new ArrayList<>();
        for (char c = 'a'; c <= 'z'; c++){
            for (int i=0; i<currentWord.length(); i++){
                if (currentWord.charAt(i)==c) continue;
                else{
                    char[] temp = currentWord.toCharArray();
                    temp[i] = c;
                    if (wordList.contains(String.valueOf(temp)))
                        neighbors.add(temp.toString());
                }

            }
        }
        return neighbors;
    }

}
