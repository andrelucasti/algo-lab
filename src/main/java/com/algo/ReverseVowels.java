package com.algo;

import java.util.*;

public class ReverseVowels {

    public String reverseVowels(String s) {
        List<Character> vowels = Arrays.stream(new Character[]{'a', 'e', 'i', 'o', 'u'}).toList();
        char[] charArray = s.toCharArray();
        char[] reverseVowelWorld = new char[s.length()];

        for (int i = 0; i < s.length(); i++) {
            if (vowels.contains(Character.toLowerCase(charArray[i]))){
                reverseVowelWorld[i] = charArray[s.length() - i];
            } else {
                reverseVowelWorld[i] = charArray[i];
            }
        }

        return new String(reverseVowelWorld);
    }

    public static void main(String[] args) {

       ReverseVowels reverseVowels = new ReverseVowels();
       //System.out.println(reverseVowels.reverseVowels("hello"));
       System.out.println(reverseVowels.reverseVowels("AEIOU"));
    }
}
