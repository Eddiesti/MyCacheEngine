package ru.otus;

import org.junit.Test;

import static org.junit.Assert.*;

public class CacheEngineImplTest {
    @Test
    public void put() {
        CacheEngine cacheEngine = new CacheEngineImpl(5, 0, 0, true);
        Object value = "cache";
        String key = String.valueOf(value.hashCode());
        cacheEngine.put(new MyElement(key, value));
        assertEquals(1, ((CacheEngineImpl) cacheEngine).size());
    }

    @Test
    public void get() {
        CacheEngine cache = new CacheEngineImpl(5, 0, 0, true);
        Object obj = new String("cache");
        String key = String.valueOf(obj.hashCode());
        cache.put(new MyElement(key, obj));
        Object someElement = cache.get(key);
        assertNotNull(someElement);

    }

    @Test
    public void getHitCount() {
        CacheEngine cacheEngine = new CacheEngineImpl(5, 0, 0, true);
        Object value = "cache";
        String key = String.valueOf(value.hashCode());
        cacheEngine.put(new MyElement(key, value));
        Object cachedItem = cacheEngine.get(key);
        assertNotNull(cachedItem);
    }

    @Test
    public void getMissCount() {
        CacheEngine cacheEngine = new CacheEngineImpl(5, 0, 0, true);
        Object value = "cache";
        String key = String.valueOf(value.hashCode());
        cacheEngine.put(new MyElement(key, value));
        Object cachedItem = cacheEngine.get("random_key");
        assertNull(cachedItem);
    }

    @Test
    public void testMyElements() {
        CacheEngine cacheEngine = new CacheEngineImpl(1, 0, 0, true);
        Object value = "cache";
        String key = String.valueOf(value.hashCode());
        cacheEngine.put(new MyElement(key, value));
        assertEquals(1, ((CacheEngineImpl) cacheEngine).size());
    }
}