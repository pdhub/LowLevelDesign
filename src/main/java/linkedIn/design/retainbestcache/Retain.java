package linkedIn.design.retainbestcache;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

public class Retain<K, V extends Rankable>{
    DataSource dataSource;
    int maxNumItems;
    ConcurrentHashMap<K, V> items;
    TreeMap<Long, Set<K>> rankMap;

    Retain(DataSource<K,V> ds, int cacheSize){
        dataSource = ds;
        maxNumItems = cacheSize;
        items = new ConcurrentHashMap<>();
        rankMap = new TreeMap<>();
    }

    public V get(K key){
        V item = items.get(key);
        if (item == null){
            item = (V)dataSource.get(key);
            put(key, item);
        }
        return item;
    }

    private void put(K key, V item) {
        items.put(key, item);
        addToRankMap(item.getRank(), key);
    }

    private void addToRankMap(long rank, K key) {
        Set<K> set = rankMap.get(rank);
        if (set == null){
            set = new HashSet<>();
            rankMap.put(rank, set);
        }
        set.add(key);
    }
}
