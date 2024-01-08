package com.algo.linkedlist;

public class ListNode<T> {
    final T value;
    final ListNode<T> next;

    public ListNode(T value,
                    ListNode<T> head) {

        this.value = value;
        this.next = head;
    }
}
