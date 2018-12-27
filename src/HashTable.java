import java.util.Objects;

interface HashTable {
    Integer find(String key);
    void add(String key);
    void delete(String key);
    void show();
    class Entries {
        private String Key;
        private Integer Value;

        public String getKey() {
            return Key;
        }

        public void setKey(String key) {
            Key = key;
        }

        public Integer getValue() {
            return Value;
        }

        public void setValue(Integer value) {
            Value = value;
        }

        public Entries(String key) {
            Key = key;
            Value = hash(Key);
        }

        static int hash(String str) {
            int hash = 5381;
            int c;
            for (int i = 0; i < str.length(); i++) {
                c = str.charAt(i);
                hash = ((hash << 5) + hash) + c; /* hash * 33 + c */
            }
            return hash;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Entries entries = (Entries) o;
            return Objects.equals(Key, entries.Key) &&
                    Objects.equals(Value, entries.Value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(Key, Value);
        }
    }
}
