package com.algo.cache;

import java.util.*;

public class LFUCache<K,V> implements Cache<K,V>{
    private final int capacity;
    private final Map<K,Item<K,V>> data;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.data = new HashMap<>(capacity);
    }

    @Override
    public void put(K key, V value) {
        if (data.size() >= capacity){
            Item<K, V> item = data.values()
                    .stream()
                    .filter(kvItem -> kvItem.count == data.values().stream().map(c -> c.count).mapToInt(v -> v).min().getAsInt())
                    .findFirst().orElseThrow();

            data.remove(item.key, item);

        }

        data.put(key, new Item<>(key, value));
    }

    @Override
    public Optional<V> get(K key) {
        if (data.containsKey(key)){
            Item<K, V> item = data.get(key);
            item.sumCounter();

            return Optional.of(item.value);
        }
        
        return Optional.empty();
    }

    @Override
    public void display() {
        data.forEach((k, kvItem) -> System.out.printf("Key: %s | Value: %s | Counts: %s%n", k, kvItem.value, kvItem.count));
    }
    
    private static class Item<K,V> {
        private final K key;
        private final V value;
        
        private int count;

        public Item(K key, V value) {
            this.key = key;
            this.value = value;
            this.count = 0;
        }
        
        void sumCounter(){
            count ++;
        }
    }
}
