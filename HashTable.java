import java.util.LinkedList;

public class HashTable {
    ////////////////////
    private class Entry {
        private int key;
        private String value;

        public Entry(int key, String value) {// 1, 107A
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return key + " / " + value;
        }

    }

    /////////////////////////
    private LinkedList<Entry>[] entries;

    public HashTable(int size) {
        entries = new LinkedList[size];
    }

    public void put(int key, String value) {// 11, C
        int index = hash(key);
        // Check if key is already in list, update value if there is one
        Entry entry = getEntry(key);
            if (entry!=null) {
                entry.value = value;
                return;
            }
        // If no LinkedList at index, make a new one
        if (entries[index] == null) entries[index] = new LinkedList<>();

        entries[index].addLast(new Entry(key, value));
    }

    public String get(int key) {
        Entry entry = getEntry(key);
        return (entry == null) ? null : entry.value;
    }

    public boolean remove(int key) {
        int index = hash(key);
        Entry entry = getEntry(key);
        if (entry != null && entry.key == key)
            return entries[index].remove(entry);
        // else
        return false;
    }

    private Entry getEntry(int key) {
        int index = hash(key);
        // check for entry
        if (key >= 0 && entries[index] != null) {
            for (var entry : entries[index])
                if (entry.key == key)
                    return entry;
             }
        // no entry
        return null;
        }

        private int hash ( int key){
            return key % entries.length;
        }
    }
