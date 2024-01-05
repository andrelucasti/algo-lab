package com.algo.stack;

import java.util.Stack;

// The time complexity of this algorithm is O(log(n)) due to the division by 2 at each step.
// The space complexity is also O(log(n)) because in each step we will be pushing an element on the stack, and there are a total of log(n) steps.
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
