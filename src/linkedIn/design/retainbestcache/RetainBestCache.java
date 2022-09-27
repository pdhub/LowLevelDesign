package linkedIn.design.retainbestcache;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

public class RetainBestCache<K, V extends Rankable> {
    // Add any fields you need here
    DataSource dataSource;
    int maxNumItems;
    ConcurrentHashMap<K, V> items;
    TreeMap<Long, Set<K>> rankMap;

    /**
     * Constructor with a data source (assumed to be slow) and a cache size
     *
     * @param ds       the persistent layer of the the cache
     * @param capacity the number of entries that the cache can hold
     */
    public RetainBestCache(DataSource<K, V> ds, int capacity) {
        // Implementation here
        dataSource = ds;
        maxNumItems = capacity;
        items = new ConcurrentHashMap<K, V>();
        rankMap = new TreeMap<Long, Set<K>>();
    }

    /**
     * Gets some data. If possible, retrieves it from cache to be fast. If the data is not cached,
     * retrieves it from the data source and, if possible, cache it. If the cache is full, attempt
     * to cache the returned data,
     * evicting the V with lowest rank among the ones that it has available
     * If there is a tie, the cache may choose any V with lowest rank to evict.
     *
     * @param key the key of the cache entry being queried
     * @return the Rankable value of the cache entry
     */
    public V get(K key) {
        // using a ConcurrentHashMap allows multiple callers to invoke "items.get(key)" concurrently
        V item = items.get(key);

        if (item == null) {
            // multiple threads could concurrently invoke the slow "dataSource.get" on the same key here.
            // however, since dataSource.get is slow, we definitely don't want it to be inside a critical section.
            item = (V) dataSource.get(key);
            // "put" is synchronized, so all of its reads and writes to items and rankMap occur as an atomic operation.
            put(key, item);
        }
        return item;
    }

    private synchronized void put(K key, V item) {
        items.put(key, item);
        addToRankMap(item.getRank(), key);

        if (items.size() > maxNumItems) {
            Map.Entry<Long, Set<K>> lowestRankedEntry = rankMap.firstEntry();
            Set<K> lowestRankedSet = lowestRankedEntry.getValue();

            K keyToDelete = lowestRankedSet.iterator().next(); // choose an arbitrary key from the set
            items.remove(keyToDelete);

            if (lowestRankedSet.size() > 1) {
                lowestRankedSet.remove(keyToDelete);
            } else {
                // the set shrinks from 1 item to 0 items, so just remove the set altogether
                rankMap.remove(lowestRankedEntry.getKey());
            }
        }
    }

    private void addToRankMap(Long rank, K key) {
        Set<K> set = rankMap.get(rank);
        if (set == null) {
            set = new HashSet<K>();
            rankMap.put(rank, set);
        }
        set.add(key);
    }
}

/*
Bonus - sharding
Depending on how you present the question (and follow-ups), sharding might come up as a way to improve performance.  Adding sharding to the existing implementation shouldn't be difficult, especially if the candidate is good and uses composition rather than expansion, e.g.:
Scoring
A great candidate will
Implement the cache cleanly and correctly, with clear and easy-to-follow logic,
in O(1) for cached fetches and O(log(n)) if an eviction is required
(e.g. using a HashMap<K, V> for O(1) cached fetching, a PriorityQueue or TreeMap<Long, Set<K>> of ranks for O(log(n))
firstEntry(), remove(), and put(), and synchronized blocks to make the methods safe for multithreading).
Ask about cases like low-rank fetches (it is unclear whether an object with rank X should be replaced by a new object with rank less than X) and non-static rank on their own
Be able to handle non-static rank in a sensible way, as well as putting reasonable limits on when changed ranks will be reflected
Ask about or consider making this data structure safe for multithreading.
Complete the question in less than 30 minutes
**/


