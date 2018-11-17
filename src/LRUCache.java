import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache<K, V> extends LinkedHashMap<K, V> {
    private int maxSize;
    public LRUCache(int capacity) {
        // AccessOrder: Least Recently to most recently accessed
        super(capacity, 0.75f, true);
        this.maxSize = capacity;
    }

    @Override
    // Implements a removal policy for eldest entries
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return this.size() > maxSize;
    }
}