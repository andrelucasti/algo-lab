package com.algo.linkedlist;

public class LinkedNode<T> {
    final T value;
    LinkedNode<T> next;

    public LinkedNode(T value, LinkedNode<T> next) {
        this.value = value;
        this.next = next;
    }

    public T getValue() {
        return value;
    }
}
