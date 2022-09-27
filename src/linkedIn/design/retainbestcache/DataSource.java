package linkedIn.design.retainbestcache;

public interface DataSource<K, V extends Rankable> {
    V get(K key);
}
