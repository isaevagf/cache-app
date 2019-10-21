package cacheDemo.cacheapp;

import java.util.LinkedHashMap;
import java.util.Map;

public class CacheLFU<K, V> extends LinkedHashMap<Object, Object> implements Map<Object, Object>{

    class CacheLFUEntry {
        private V data;
        private int frequency;

        public V getData() {
            return data;
        }

        public  void setData (V data) {
            this.data = data;
        }

        public int getFrequency() {
            return frequency;
        }
        public void setFrequency(int frequency) {
            this.frequency = frequency;
        }

    }
    private int cacheSize;

    public CacheLFU(int cacheSize)
    {
        this.cacheSize  = cacheSize;
    }
    @Override
    public Object put(Object key, Object data)
    {
        if(!isFull())
        {
            CacheLFUEntry temp = new CacheLFUEntry();
            temp.setData((V)data);
            temp.setFrequency(0);

            super.put(key, temp);
        }
        else
        {
            Object keyToBeRemoved = getLFUKey();
            System.out.println("value will be removed from cash " + keyToBeRemoved +" " + ((CacheLFUEntry)super.get(keyToBeRemoved)).getFrequency());
            super.remove(keyToBeRemoved);


            CacheLFUEntry temp = new CacheLFUEntry();
            temp.setData((V)data);
            temp.setFrequency(0);

            super.put(key, temp);
        }
        return data;
    }

    private Object getLFUKey() {
        Object key = null;
        int minFreq = Integer.MAX_VALUE;

        for (Map.Entry entry : this.entrySet()) {
            CacheLFUEntry temp = (CacheLFUEntry)entry.getValue();
            if (minFreq > temp.frequency) {
                key = entry.getKey();
                minFreq = temp.frequency;
            }
        }
        return key;

    }
    @Override
    public V get (Object key)
    {
        if(this.containsKey(key))  // cache hit
        {
            CacheLFUEntry temp = (CacheLFUEntry)(super.get(key));
            temp.setFrequency(temp.getFrequency()+1);
            super.put(key, temp);
            return (V)temp.getData();
        }
        return null; // cache miss
    }

    private boolean isFull()
    {
        if (this.size() >= this.cacheSize)
            return true;
        else
            return false;
    }

}
