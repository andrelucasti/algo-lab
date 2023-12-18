package com.algo.array;

public class SumArray {
    public int[] runningSum(int[] nums) {
        int sum = 0;
        int[] result = new int[nums.length];

        for (int i = 0; i < nums.length; i++){
            sum = sum + nums[i];
            result[i] = sum;
        }

        return result;
    }

    public static void main(String[] args) {
        SumArray solution = new SumArray();

        // Test cases
        int[][] testInputs = {
                {1,2,3,4},
                {3,1,4,2,2},
                {-1,-2,-3,-4,-5}
        };

        for (int[] input : testInputs) {
            int[] output = solution.runningSum(input);

            // Print the output array
            for (int val : output) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}
