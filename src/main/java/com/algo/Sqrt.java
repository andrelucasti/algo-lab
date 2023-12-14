package com.algo;

public class Sqrt {

    public int mySqrt(int x) {
        // TODO: Write your code here

        double sqrt = Math.sqrt(x);
        return (int) sqrt;
    }

    public static void main(String[] args) {

        Sqrt sqrt = new Sqrt();
        System.out.println(sqrt.mySqrt(4));
        System.out.println(sqrt.mySqrt(8));
        System.out.println(sqrt.mySqrt(9));
        System.out.println(sqrt.mySqrt(15));
    }
}
