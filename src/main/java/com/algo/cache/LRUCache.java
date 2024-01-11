package com.algo.cache;

import java.util.*;

public class LRUCache<K,V> implements Cache<K,V> {
    private final int capacity;
    private final Map<K, V> data;
    private final Deque<K> orderQueue;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.data = new HashMap<>(capacity);
        this.orderQueue = new LinkedList<>();
    }

    @Override
    public void put(K key, V value) {
        if (orderQueue.size() >= capacity){
            K firstKey = orderQueue.pollLast();

            data.remove(firstKey);
        }

        data.put(key, value);
        orderQueue.push(key);
    }

    @Override
    public Optional<V> get(K key) {
        if (data.containsKey(key)){
            V value = data.get(key);

            orderQueue.remove(key);
            orderQueue.push(key);

            return Optional.of(value);
        }

        return Optional.empty();
    }

    @Override
    public void display() {

    }

    @Override
    public void displayRecentlyUsed() {

    }
}
