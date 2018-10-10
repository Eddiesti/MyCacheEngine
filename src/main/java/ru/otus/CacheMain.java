package ru.otus;

public class CacheMain {
    public static void main(String[] args) {
        testSoftReferense();
    }

    public static void testSoftReferense() {
        int size = 10000000;
        while (true) {
            CacheEngine cacheEngine = new CacheEngineImpl(size, 0, 0, true);
            Object value = "cache";
            String key = String.valueOf(value.hashCode());
            for (int i = 0; i < size; i++) {
                cacheEngine.put(new MyElement(key, value));
            }
            for (int i = 0; i < size; i++) {
                System.out.println(cacheEngine.get(key));
            }
        }
    }
}