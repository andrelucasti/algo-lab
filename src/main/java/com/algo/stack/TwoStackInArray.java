package com.algo.stack;

public class TwoStackInArray {
    int size;
    int top1, top2;
    int arr[];

    TwoStackInArray() {
        arr = new int[100];
        size = 100;

        top1 = 0;
        top2 = size;
    }

    void push1(int x) {
        arr[top1] = x;
        top1 ++;
    }

    void push2(int x) {
        arr[top2 -1] = x;
        top2 --;
    }

    // Note: Always return -1, when stack becomes empty.
    int pop1() {
        if (top1 <= 0) {
            return -1;
        }

        int result = arr[top1 -1];

        arr[top1] = 0;
        top1--;

        return result;
    }

    // Note: Always return -1, when stack becomes empty.
    int pop2() {
        if (top2 >= size) {
            return -1;
        }
        int result = arr[top2];
        arr[top2] = 0;
        top2 ++;

        return result;
    }

    public static void main(String[] args) {

        var solution = new TwoStackInArray();

        solution.push1(7);
        solution.push2(8);
        solution.push2(9);
        solution.push2(10);

        System.out.println(solution.pop1()); //returns 7
        System.out.println(solution.pop2()); //returns 10
        System.out.println(solution.pop2()); //returns 9
    }
}