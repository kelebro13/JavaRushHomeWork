package com.javarush.test.level33.lesson15.big01.strategies;

/**
 * Created by testim on 27.04.16.
 */
public class FileStorageStrategy implements StorageStrategy {

    private FileBucket[] table =  {new FileBucket(), new FileBucket(), new FileBucket(), new FileBucket(),
            new FileBucket(), new FileBucket(), new FileBucket(), new FileBucket(),
            new FileBucket(), new FileBucket(), new FileBucket(), new FileBucket(),
            new FileBucket(), new FileBucket(), new FileBucket(), new FileBucket()};

    private long bucketSizeLimit = 10000;


    int hash(Long k){
        return k.hashCode();
    }

    int indexFor(int hash, int length){
        return hash & (length-1);
    }

    Entry getEntry(Long key){
        int hash = (key == null) ? 0 : hash(key);
        for (Entry e = table[indexFor(hash, table.length)].getEntry();
             e != null;
             e = e.next) {
            Object k;
            if (e.hash == hash &&
                    ((k = e.key) == key || (key != null && key.equals(k))))
                return e;
        }
        return null;
    }

    void resize(int newCapacity){
        FileBucket[] newTable = new FileBucket[newCapacity];
        for(int i = 0; i < newCapacity; i++){
            newTable[i] = new FileBucket();
        }
        transfer(newTable);
        for(int i = 0; i < table.length; i++){
            table[i].remove();
        }
        table = newTable;
    }

    void transfer(FileBucket[] newTable){
        for(int i = 0; i < table.length; i++){
            if(table[i] == null){
                continue;
            }
            Entry e = table[i].getEntry();
            while(e != null){
                Entry next = e.next;
                int newIndex = indexFor(e.hash, newTable.length);
                if(newTable[newIndex] == null){
                    e.next = null;
                    newTable[newIndex] = new FileBucket();
                }else {
                    e.next = newTable[newIndex].getEntry();
                }
                newTable[newIndex].putEntry(e);
                e = next;
            }
        }
    }

    void addEntry(int hash, Long key, String value, int bucketIndex){

        Entry e = table[bucketIndex].getEntry();
        table[bucketIndex].putEntry(new Entry(hash, key, value, e));
        if(table[bucketIndex].getFileSize() > bucketSizeLimit){
            resize(2 * table.length);
        }
    }

    void createEntry(int hash, Long key, String value, int bucketIndex){
        table[bucketIndex] = new FileBucket();
        table[bucketIndex].putEntry(new Entry(hash, key, value, null));
    }


    public long getBucketSizeLimit() {
        return bucketSizeLimit;
    }

    public void setBucketSizeLimit(long bucketSizeLimit) {
        this.bucketSizeLimit = bucketSizeLimit;
    }

    @Override
    public boolean containsKey(Long key) {
        return getEntry(key) != null;
    }

    @Override
    public boolean containsValue(String value) {
        for(int i = 0; i < table.length; i++){
            if(table[i] == null){
                continue;
            }
            Entry e = table[i].getEntry();
            while(e != null){
                if(e.getValue().equals(value)){
                    return true;
                }
                e = e.next;
            }
        }
        return false;
    }

    @Override
    public void put(Long key, String value) {
        addEntry(hash(key), key, value, indexFor(hash(key),table.length));
    }

    @Override
    public Long getKey(String value) {
        if(value == null){
            return 0l;
        }

        for(FileBucket fb : table){
            if(fb != null){
                if(fb.getFileSize() != 0){
                    Entry e = fb.getEntry();
                    if(e.getValue().equals(value)){
                        return e.getKey();
                    }
                }
            }
        }
        return null;
    }

    @Override
    public String getValue(Long key) {
        return null == getEntry(key) ? null : getEntry(key).getValue();
    }
}
