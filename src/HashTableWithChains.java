import java.util.*;

public class HashTableWithChains implements HashTable {

    private Map<String, List<Entries>> hashTable = new HashMap<>();

    @Override
    public Integer find(String key) {
        List<Entries> entries = hashTable.get(key);
        if (entries == null) {
            return null;
        }
        Optional<Entries> value = entries.stream().filter(e -> key.equals(e.getKey())).findAny();
        return value.isPresent() ? value.get().getValue() : null;
    }

    @Override
    public void add(String key) {
        List<Entries> entries;
        Entries entry = new Entries(key);
        if (find(key) == null) {
            entries = new ArrayList<>();
            entries.add(entry);
            hashTable.put(key, entries);
        } else {
            entries = hashTable.get(key);
            entries.add(entry);
        }
    }

    @Override
    public void delete(String key) {
        List<Entries> entries;
        Entries entry = new Entries(key);
        if (find(key) != null) {
            entries = hashTable.get(key);
            entries.remove(entry);
        }
    }

    public void show() {
        for (List<Entries> entries : hashTable.values()) {
            for (Entries entry : entries) {
                System.out.println(entry.getKey() + " -> " + entry.getValue());
            }
        }
    }
}
