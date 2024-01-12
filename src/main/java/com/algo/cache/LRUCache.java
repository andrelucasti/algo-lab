package com.algo.cache;

import java.util.*;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class LRUCache<K,V> implements Cache<K,V> {
    private final int capacity;
    private final Map<K, V> data;
    private final Deque<K> orderQueue;

    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.data = new HashMap<>(capacity);
        this.orderQueue = new LinkedList<>();
    }

    @Override
    public void put(K key, V value) {
        this.lock.writeLock().lock();
        try {
            if (orderQueue.size() >= capacity){
                evict();
            }

            data.put(key, value);
            orderQueue.push(key);
        } finally {
           this.lock.writeLock().unlock();
        }
    }

    @Override
    public Optional<V> get(K key) {
        this.lock.readLock().lock();

        try {
            if (data.containsKey(key)){
                V value = data.get(key);

                orderQueue.remove(key);
                orderQueue.push(key);

                return Optional.of(value);
            }

            return Optional.empty();
        }finally {
            this.lock.readLock().unlock();
        }
    }


    @Override
    public void display() {
        data.forEach((k, value) -> System.out.printf("Key: %s | Value: %s%n", k, value));
        System.out.printf("Last fetched/stored %s", orderQueue.peek());
    }

    @Override
    public int size() {
        return data.size();
    }

    private void evict() {
        K firstKey = orderQueue.pollLast();

        data.remove(firstKey);
    }
}
