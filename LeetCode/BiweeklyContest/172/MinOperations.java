// https://leetcode.com/problems/minimum-number-of-operations-to-have-distinct-elements/

import java.util.*;

public class MinOperations {
    public int minimumOperations(int[] nums) {
        int n = nums.length;

        // Frequency map
        Map<Integer, Integer> freq = new HashMap<>();
        for (int x : nums) {
            freq.put(x, freq.getOrDefault(x, 0) + 1);
        }

        // Count how many values have duplicates
        int duplicateCount = 0;
        for (int count : freq.values()) {
            if (count > 1)
                duplicateCount++;
        }

        // If already all distinct
        if (duplicateCount == 0)
            return 0;

        int ops = 0;
        int i = 0;

        // Simulate operations
        while (i < n && duplicateCount > 0) {
            ops++;

            // Remove up to 3 elements
            for (int k = 0; k < 3 && i < n; k++, i++) {
                int val = nums[i];
                int count = freq.get(val);

                freq.put(val, count - 1);

                // If it was duplicate and now becomes unique
                if (count == 2) {
                    duplicateCount--;
                }
            }
        }

        return ops;
    }

}

// BruteForce Approach (Inefficient)

// import java.util.*;

// class Solution {
// public int minimumOperations(int[] nums) {
// List<Integer> list = new ArrayList<>();
// for (int num : nums)
// list.add(num);

// int operations = 0;

// while (!list.isEmpty()) {
// // Check if array has duplicates
// Set<Integer> set = new HashSet<>(list);
// if (set.size() == list.size()) {
// // all elements are distinct → stop
// break;
// }

// // Perform one operation: remove first 3 elements
// int removeCount = Math.min(3, list.size());
// for (int i = 0; i < removeCount; i++) {
// list.remove(0); // remove first element
// }
// operations++;
// }

// return operations;
// }

// // Testing the code
// public static void main(String[] args) {
// Solution sol = new Solution();
// System.out.println(sol.minimumOperations(new int[] { 3, 8, 3, 6, 5, 8 })); //
// Output: 1
// System.out.println(sol.minimumOperations(new int[] { 2, 2 })); // Output: 1
// System.out.println(sol.minimumOperations(new int[] { 4, 3, 5, 1, 2 })); //
// Output: 0
// }
// }
