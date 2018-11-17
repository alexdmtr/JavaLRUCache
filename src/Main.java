
import java.util.Map;

public class Main {

    static<K, V> void printCache(Map<K, V> map) {
        System.out.println("Cache: (LRU to MRU)");
        for (Map.Entry<K, V> entry : map.entrySet())
            System.out.printf("%s -> %s\n", entry.getKey(), entry.getValue());
        System.out.println();
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
