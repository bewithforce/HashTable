public class HashTableWithOpenAddressing implements HashTable {

    private int Size;

    private Entries[] hashTable;

    public HashTableWithOpenAddressing(int Size){
        this.Size = Size;
        this.hashTable = new Entries[Size];
        for(int i = 0; i < Size; i++){
            hashTable[i] = null;
        }
    }

    @Override
    public Integer find(String key) {
        int idx = HashTable.Entries.hash(key);
        Entries entry = new Entries(key);
        for (int i = 0; i < Size; i++) {
            if (hashTable[(idx + i) % Size] == entry) {
                return entry.getValue();
            }
        }
        return null;

    }

    @Override
    public void add(String key) {
        int idx = HashTable.Entries.hash(key);
        Entries entry = new Entries(key);
        for(int i = 0; i < Size; i++){
            if(hashTable[(idx + i) % Size] == null){
                hashTable[(idx + i) % Size] = entry;
                return;
            }
            if (i == Size - 1){
                System.out.println("SMALL TABLE");
            }
        }
    }

    @Override
    public void delete(String key) {
        int idx = HashTable.Entries.hash(key);
        Entries entry = new Entries(key);
        for(int i = 0; i < Size; i++){
            if(hashTable[(idx + i) % Size] == entry){
                hashTable[(idx + i) % Size] = null;
                return;
            }
        }
    }

    @Override
    public void show(){
        for(Entries entry: hashTable){
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}
