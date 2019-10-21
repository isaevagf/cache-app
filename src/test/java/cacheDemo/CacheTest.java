package test.java.cacheDemo;

import cacheDemo.cacheapp.CacheLFU;
import cacheDemo.cacheapp.CacheLRU;
import org.junit.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;


public class CacheTest {

    private CacheLFU cLFU;
    private CacheLRU cLRU;

    public CacheTest(){
        this.cLFU = new CacheLFU(2);
        this.cLRU = new CacheLRU(2);
    };


    @Test
    public void LFUtestSetCapacityNotReached() {
        cLFU.put(1, "data1");
        assertEquals(cLFU.get(1), "data1");
        assertEquals(cLFU.get(2), null);
        cLFU.put(2, "data2");
        assertEquals(cLFU.get(1), "data1");
        assertEquals(cLFU.get(2), "data2");
    }

    @Test
    public void LFUtestCapacityReachedEldestRemoved() {
        cLFU.put(1, "data1");
        cLFU.put(2, "data2");
        cLFU.put(3, "data3");
        assertEquals(cLFU.get(1), null);
        assertEquals(cLFU.get(2), "data2");
        assertEquals(cLFU.get(3), "data3");
    }

    @Test
    public void LFUtestFrequencyChanged() {
        cLFU.put(1, "data1");
        cLFU.put(2, "data2");
        cLFU.put(3, "data3");
        assertEquals(cLFU.get(1), null);
        assertEquals(cLFU.get(2), "data2");
        assertEquals(cLFU.get(3), "data3");
    }

    @Test
    public void LRUtestSetCapacityNotReached() {
        cLRU.put(1, "data1");
        assertEquals(cLRU.get(1), "data1");
        assertEquals(cLRU.get(2), null);
        cLRU.put(2, "data2");
        assertEquals(cLRU.get(1), "data1");
        assertEquals(cLRU.get(2), "data2");
    }

    @Test
    public void LRUtestCapacityReachedEldestRemoved() {
        cLRU.put(1, "data1");
        cLRU.put(2, "data2");
        cLRU.put(3, "data3");
        assertEquals(cLRU.get(1), null);
        assertEquals(cLRU.get(2), "data2");
        assertEquals(cLRU.get(3), "data3");
    }

    @Test
    public void LRUtestFrequencyChanged() {
        cLRU.put(1, "data1");
        cLRU.put(2, "data2");
        assertEquals(cLRU.get(1), "data1");
        cLRU.put(3, "data3");
        assertEquals(cLRU.get(1), "data1");
        assertEquals(cLRU.get(2), null);
        assertEquals(cLRU.get(3), "data3");

    }

    @Test
    public void LRUtestFrequencyChanged1() {
        cLRU.put(1, null);
        cLRU.put(2, null);
        cLRU.put(3, null);
        cLRU.put(4, null);
        cLRU.put(5, null);

        Set<Integer> keys = cLRU.keySet();
        assertEquals("[4, 5]", keys.toString());

    }
}

