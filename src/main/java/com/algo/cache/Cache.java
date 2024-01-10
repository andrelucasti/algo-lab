package com.algo.cache;

import java.util.Optional;

public interface Cache<K, T> {
    void put(K key, T t);

   Optional<T> get(K key);

   void display();
   void displayRecentlyUsed();
}
