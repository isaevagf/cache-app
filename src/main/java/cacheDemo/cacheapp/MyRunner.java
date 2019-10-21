package cacheDemo.cacheapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Iterator;
import java.util.Map;

@Component
public class MyRunner implements CommandLineRunner{

    @Autowired
    private CacheRepository cacheRepository;

    @Override
    public void run(String... args) throws Exception {

        CacheLFU<Integer, String> cache = new CacheLFU<Integer, String>(2);

        cache.put(1, "String1");
        cache.put(2, "String2");
        cache.put(3, "String3");

        java.util.Iterator iter = cache.entrySet().iterator();

        while(iter.hasNext()) {

            Map.Entry mapEntry = (Map.Entry) iter.next();
            Entry entry = new Entry((Integer)mapEntry.getKey(), cache.get(mapEntry.getKey()));
            cacheRepository.save(entry);

        }
    }
}