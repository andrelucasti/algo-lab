package com.algo;

public class ReverseString {
    public String reverseString(String s) {
        char[] charArray = s.toCharArray();
        StringBuilder sb = new StringBuilder();

        for (int i = charArray.length - 1; i >= 0 ; i--) {
            char c = charArray[i];
            sb.append(c);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        ReverseString reverseString = new ReverseString();
        System.out.println(reverseString.reverseString("Hello"));
    }
}


