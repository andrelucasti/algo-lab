package com.algo.stack;

import java.util.Stack;

public class DecimalToBinary {
    private static final int DIVISOR = 2;
    public static String decimalToBinary(int num) {
        StringBuilder sb = new StringBuilder();
        Stack<Integer> binaryStack = new Stack<>();

        int dividend = num;

        while (dividend >= DIVISOR){
            int rest = dividend % DIVISOR;
            binaryStack.push(rest);

            dividend = dividend / DIVISOR;
        }

        int lastQuotientValue = dividend;
        binaryStack.push(lastQuotientValue);

        while (!binaryStack.isEmpty()) {
            sb.append(binaryStack.pop());
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(DecimalToBinary.decimalToBinary(2));//Output: "10"
        System.out.println(DecimalToBinary.decimalToBinary(7));//Output: "111"
        System.out.println(DecimalToBinary.decimalToBinary(18));//Output: "10010"
    }
}
