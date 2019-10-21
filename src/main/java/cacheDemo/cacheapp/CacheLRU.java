package cacheDemo.cacheapp;

import java.util.LinkedHashMap;
import java.util.Map;


public class CacheLRU<K, V> extends LinkedHashMap<K, V> implements Map<K,V>{
    private int cacheSize;

    public CacheLRU(int cacheSize) {
        super(cacheSize, (float) 0.75, true);
        this.cacheSize = cacheSize;
    }

    @Override
    protected boolean removeEldestEntry(Entry<K, V> eldest) {
        System.out.println(eldest.getKey());
        return size() > cacheSize;

    }
}