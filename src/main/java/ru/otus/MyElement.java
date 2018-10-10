package ru.otus;

import java.lang.ref.SoftReference;

public class MyElement<K, V> {
    private final K key;
    private final SoftReference<V> value;
    private final long creationTime;
    private long lastAccessTime;

    public MyElement(K key, V value) {
        this.key = key;
        this.value = new SoftReference<>(value);
        this.creationTime = getCurrentTime();
        this.lastAccessTime = getCurrentTime();
    }

    protected long getCurrentTime() {
        return System.currentTimeMillis();
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value.get();
    }

    public long getCreationTime() {
        return creationTime;
    }

    public long getLastAccessTime() {
        return lastAccessTime;
    }

    public void setAccessed() {
        lastAccessTime = getCurrentTime();
    }
}