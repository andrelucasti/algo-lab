package com.algo.linkedlist;

public class SingleLinkedList<T> implements LinkedList<T>  {

    private ListNode<T> head;
    @Override
    public void insert(T t) {
        head = new ListNode<>(t, head);
    }

    @Override
    public void print() {
        var tempHead = head;
        while (tempHead != null){
           System.out.println(tempHead.value);
           tempHead = tempHead.next;
       }
    }

    @Override
    public boolean contains(T t) {
        var tempHead = head;
        while (tempHead != null){
            if (tempHead.value == t) {
                return true;
            }
            tempHead = tempHead.next;
        }
        return false;
    }


    public static void main(String[] args) {
        LinkedList<Integer> sLinkedList = new SingleLinkedList<>();
        sLinkedList.insert(1);
        sLinkedList.insert(2);
        sLinkedList.insert(3);

        sLinkedList.print();

        System.out.println(sLinkedList.contains(1)); //true
        System.out.println(sLinkedList.contains(3)); //true
     }
}
