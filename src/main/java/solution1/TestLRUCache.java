package solution1;

public class TestLRUCache {
    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache();
        lruCache.put("Day1", "Monday");
        lruCache.put("Day2", "Tuesday");
        lruCache.put("Day3", "Wednesday");
        lruCache.put("Day4", "Thursday");
        lruCache.put("Day5", "Friday");
        lruCache.put("Day6", "Saturday");
        lruCache.printContents();
        lruCache.get("Day3");
        lruCache.printContents();
        lruCache.get("Day6");
        lruCache.printContents();
        lruCache.put("Day1", "MondayAgain");
        lruCache.printContents();
    }
}
