package cacheDemo.cacheapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CacheServiceImpl implements CacheService{

    private final CacheRepository cacheRepository;

        @Autowired
    public CacheServiceImpl(CacheRepository cacheRepository) {
        this.cacheRepository = cacheRepository;
    }

        @Override
        public Optional<Entry> save(Entry entry) {
            return Optional.of(cacheRepository.save(entry));
        }
    }

