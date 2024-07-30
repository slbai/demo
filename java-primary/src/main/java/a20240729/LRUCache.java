package a20240729;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache<K,V> extends LinkedHashMap<K,V> {

    private final int capacity;

    public LRUCache(int capacity) {
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > capacity;
    }


    public static void main(String[] args) {
        LRUCache<Integer,Integer> cache = new LRUCache<>(2);
        cache.put(1,1);
        cache.put(2,2);
        cache.put(3,3); // 1被移除，目前是2，3

        cache.get(2);// 2被移到最后，目前是3，2
        System.out.println(cache);

        cache.put(4,4); // 3被移除，目前是2，4.原因是lru中只关注访问，并不关注频次，虽然2被访问了，但是4是最近访问的，在最后
        System.out.println(cache);
    }
}
