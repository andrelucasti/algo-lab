package com.algo;

import java.util.HashSet;
import java.util.Set;

public class Pangram {

    public boolean checkIfPangram(String sentence) {
        if (sentence.length() < 26) {
            return false;
        }

        Set<Character> set = new HashSet<>();
        for (int i = 0; i < sentence.length(); i++) {
            if (Character.isLetter(sentence.charAt(i))) {
                set.add(Character.toLowerCase(sentence.charAt(i)));
            }
        }

        return set.size() == 26;
    }

    public static void main(String[] args) {
        Pangram pangram = new Pangram();
        System.out.println(pangram.checkIfPangram("ABCDEFGHIJKLMNOPQRSTUVWXyZ"));
        System.out.println(pangram.checkIfPangram("thequickbrownfoxjumpsoverthelazydog"));
        System.out.println(pangram.checkIfPangram("This is not a pangram"));
        System.out.println(pangram.checkIfPangram("abcdefghijklmnopqrstuvwxyz"));
        System.out.println(pangram.checkIfPangram("This sentence is certainly not a pangram"));

    }
}
