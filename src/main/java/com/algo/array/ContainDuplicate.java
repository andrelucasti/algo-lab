package com.algo.array;

import java.util.Arrays;
import java.util.HashSet;

public class ContainDuplicate {

    //O(n^2)
    public boolean containsDuplicate(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int current = nums[i];
                int next = nums[j];

                if (current == next){
                    return true;
                }
            }
        }

        return false;
    }

    //O(n)
    public boolean containsDuplicateHashSet(int[] nums){
        HashSet<Integer> numsNoDuplicated = new HashSet<>();
        for (int num : nums) {
            if (!numsNoDuplicated.add(num)) {
                return true;
            }
        }

        return false;
    }


    //O(N * logN)
    public boolean containsDuplicateSorting(int[] nums){
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[ i + 1]){
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        ContainDuplicate solution = new ContainDuplicate();

        int[] nums1 = {1, 2, 3, 4};
        System.out.println(solution.containsDuplicate(nums1)); // Expected output: false
        System.out.println(solution.containsDuplicateHashSet(nums1)); // Expected output: false
        System.out.println(solution.containsDuplicateSorting(nums1)); // Expected output: false

        int[] nums2 = {1, 2, 3, 1};
        System.out.println(solution.containsDuplicate(nums2)); // Expected output: true
        System.out.println(solution.containsDuplicateHashSet(nums2)); // Expected output: true
        System.out.println(solution.containsDuplicateSorting(nums2)); // Expected output: true

        int[] nums3 = {};
        System.out.println(solution.containsDuplicate(nums3)); // Expected output: false
        System.out.println(solution.containsDuplicateHashSet(nums3)); // Expected output: false
        System.out.println(solution.containsDuplicateSorting(nums3)); // Expected output: false

        int[] nums4 = {1, 1, 1, 1};
        System.out.println(solution.containsDuplicate(nums4)); // Expected output: true
        System.out.println(solution.containsDuplicateHashSet(nums4)); // Expected output: true
        System.out.println(solution.containsDuplicateSorting(nums4)); // Expected output: true
    }
}
