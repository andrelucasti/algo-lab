package com.algo.queue;

public interface Queue<T> {
    void enqueue(T t);
    T dequeue();
    T peek();
    boolean isEmpty();

    int size();

}
