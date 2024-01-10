package com.algo.cache;

import java.util.*;

public class LRUCache<K,T> implements Cache<K, T>{
    private final Map<K,T> data;
    private final int capacity;
    private final Deque<K> recently;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.data = new HashMap<>();
        this.recently = new LinkedList<>();
    }

    @Override
    public void put(K key, T value) {
        if (recently.size() >= capacity){
            K lastKey = recently.removeLast();
            data.remove(lastKey);
        }

        data.put(key, value);
        recently.push(key);
    }

    @Override
    public Optional<T> get(K key) {
        if (data.containsKey(key)){
            T value = data.get(key);
            recently.remove(key);

            recently.push(key);
            return Optional.of(value);
        }

        return Optional.empty();
    }

    @Override
    public void display() {
        data.forEach((k, t) -> System.out.printf("My Key: %s - My value: %s%n", k, t));
    }

    @Override
    public void displayRecentlyUsed() {
        recently.forEach(System.out::println);

    }

    public static void main(String[] args) {
        Cache<Integer, String> redisCache = new LRUCache<>(3);

        redisCache.put(1, "Andre");
        redisCache.put(2, "Lucas");
        redisCache.put(3,"Santos");

        redisCache.display();
        redisCache.displayRecentlyUsed();

        redisCache.get(3);
        redisCache.get(1);

        redisCache.put(4,"Santos");
        redisCache.display();
        redisCache.displayRecentlyUsed();

        redisCache.put(5,"Silva");
        redisCache.display();
        redisCache.displayRecentlyUsed();

    }
}
