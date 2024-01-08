package com.algo.queue;

public class SimpleQueue<T> implements Queue<T> {
    private QueueNode<T> front;
    private QueueNode<T> rear;
    private int size;

    public SimpleQueue() {
        this.front = null;
        this.rear = null;
        this.size = 0;
    }

    @Override
    public void enqueue(T t) {
        var newNode = new QueueNode<>(t);

        if(rear == null) {
            front = newNode;
        } else {
            rear.next = newNode;
        }

        rear = newNode;
        size ++;
    }

    @Override
    public T dequeue() {
        QueueNode<T> front = this.front;
        this.front = front.next;

        size --;

        return front.value;
    }

    @Override
    public T peek() {
        return front.value;
    }

    @Override
    public boolean isEmpty() {
        return size <= 0;
    }

    @Override
    public int size() {
        return size;
    }

    public static void main(String[] args) {
        Queue<Integer> numbers = new SimpleQueue<>();
        numbers.enqueue(1);
        numbers.enqueue(2);
        numbers.enqueue(3);

        System.out.println(numbers.peek()); //expected 1
        numbers.dequeue();
        System.out.println(numbers.peek()); //expected 2

    }


}
