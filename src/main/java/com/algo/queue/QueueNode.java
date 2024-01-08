package com.algo.queue;

public class QueueNode<T> {
    T value;
    QueueNode<T> next;
    public QueueNode(T value) {
        this.value = value;
        this.next = null;
    }
}
