package com.algo;

import java.util.Stack;

public class ReverseStackString {

    // O(n)
    public String reverseString(String s) {
        char[] charArray = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (Character character : charArray) {
            stack.push(character);
        }

        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        ReverseStackString reverseString = new ReverseStackString();
        System.out.println(reverseString.reverseString("Hello"));
    }
}


