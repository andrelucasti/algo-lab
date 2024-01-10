package com.algo.linkedlist;

public interface LinkedList<T> {
    void insertBefore(T t);

    void insertAfter(T t);

    T peek();

    T get(int index);

    boolean contains(T i);

    LinkedList<T> reverse();

    void print();


}
