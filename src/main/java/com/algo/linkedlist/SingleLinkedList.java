package com.algo.linkedlist;

public class SingleLinkedList<T> implements LinkedList<T> {
    LinkedNode<T> head;
    LinkedNode<T> tail;
    private int size;

    @Override
    public void insertBefore(T t) {
        LinkedNode<T> newNode = new LinkedNode<>(t, head);
        head = newNode;
        size ++;
    }

    @Override
    public void insertAfter(T t) {
        LinkedNode<T> newNode = new LinkedNode<>(t, null);

        if (tail == null){
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }

        size ++;
    }

    @Override
    public T peek() {
        return tail.getValue();
    }

    @Override
    public T get(int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException();
        }

        if(index + 1 > size) {
            throw new IndexOutOfBoundsException();
        }

        LinkedNode<T> result = head;
        for(int i = 0; i < index; i++){
            result = result.next;
        }

        return result.value;
    }

    @Override
    public boolean contains(T i) {
        return false;
    }

    @Override
    public LinkedList<T> reverse() {
        return null;
    }

    @Override
    public void print() {

    }

    public static void main(String[] args) {
        LinkedList<String> singleList = new SingleLinkedList<>();
        singleList.insertAfter("Andre");
        singleList.insertAfter("Lucas");
        singleList.insertAfter("Karol");
        singleList.insertAfter("Josef");

        System.out.println(singleList.get(0)); //expected Andre
        System.out.println(singleList.get(1)); //expected Lucas
        System.out.println(singleList.get(2)); //expected Karol
        System.out.println(singleList.get(3)); //expected Josef

    }
}
