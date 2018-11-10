import java.util.LinkedHashMap;
import java.util.Map;

public class Main {

    static<K, V> void printCache(Map<K, V> map) {
        System.out.println("Cache: (LRU to MRU)");
        for (Map.Entry<K, V> entry : map.entrySet())
            System.out.printf("%s -> %s\n", entry.getKey(), entry.getValue());
        System.out.println();
    }

    static class LRUCache<K, V> extends LinkedHashMap<K, V> {
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

    public static void main(String[] args) {
        Map<Integer, String> map = new LRUCache<>(2);

        map.put(1, "info1");
        map.put(2, "info2");

        printCache(map);

        map.put(1, "info1 (updated)");

        printCache(map);

        map.put(3, "info3");

        printCache(map);
    }
}
