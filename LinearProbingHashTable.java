public class LinearProbingHashTable {

    ////////////////////
    private class Entry{
        int key;
        String value;

        public Entry(int key, String value){
            this.key = key;
            this.value = value;
        }

        public String toString(){
            return key + " / " + value;
        }
    }

    //////////////
    Entry[] entries;
    int entriesCount;

    public LinearProbingHashTable(int size){
        entries = new Entry[size];
        entriesCount = 0;
    }

    public void put(int key, String value) {
        int index = hash(key);
        // check for entry and update if there is one
        if (updateEntry(key, value)) return;

        // if there is no entry, make a new one and add at index
        Entry entry = new Entry(key, value);
        System.out.println(index);
        if (entries[index] == null) {
            entries[index] = entry;
            entriesCount++;
            return;
        }
        // if index is full, find next available entry point
         int entryPoint = FindOpenEntryPoint(key, entry);
         entries[entryPoint] = entry;
         entriesCount++;
    }

    public Entry get(int key){
        for(Entry entry : entries)
            if(entry!= null && entry.key == key ) return entry;

        return null;
    }

    public boolean remove(int key){
        // check each key in entries and set to null if there is one
        for(int i = 0; i<entries.length; i++){
            System.out.println("remove - check: "+ i);
            if(entries[i]!=null && entries[i].key == key) {
                entries[i] = null;
                entriesCount--;
                return true;
            }
        }
        // no such entry
        return false;
    }

    public int size(){
        return entriesCount;
    }


    // class helper methods
    private boolean updateEntry(int key, String value) {
        // there is a key in entries
        if (get(key) != null) {
            get(key).value = value;
            return true;
        }
        // no such key in entries
        return false;
    }

    private int FindOpenEntryPoint(int key, Entry entry){
        int index = hash(key);
        int i = index % entries.length; // keeps i within entries range
        int count = 0; // checks to see if gone through entire array
        while(count<entries.length){
            System.out.println("count: "+count+" i: "+ i+" key: "+ key);
            if(entries[i] == null) {
                return i;
            }
            i= ((i+1) % entries.length);
            count++;
        }
        // if no available index, entries is full
        throw new IllegalStateException();
    }

    private int hash(int key){
        return (key % entries.length);
    }

}
