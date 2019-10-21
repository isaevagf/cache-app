package cacheDemo.cacheapp;

import java.util.Optional;

public interface CacheService {

        Optional<Entry> save(Entry entry);

}
