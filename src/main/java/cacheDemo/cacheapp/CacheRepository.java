package cacheDemo.cacheapp;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

    @Repository
    public interface CacheRepository extends CrudRepository<Entry, Long> {
    }

