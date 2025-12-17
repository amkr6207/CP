// https://leetcode.com/problems/next-greater-element-i/description/

import java.util.*;

public class NextGreaterElementOnlyStack {
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums2.length;
        int[] result = new int[nums1.length];
        int[] nextGreater = new int[n];
        Stack<Integer> stack = new Stack<>(); // value store from bottom to top in descending order

        // Step 1: Compute next greater element for each index in nums2
        for (int i = n - 1; i >= 0; i--) {
            // Maintain monotonic decreasing stack
            while (!stack.isEmpty() && stack.peek() <= nums2[i]) { // < will give wrong answer
                stack.pop();
            }

            // If stack is empty, no greater element to the right
            nextGreater[i] = stack.isEmpty() ? -1 : stack.peek();

            // Push current element to stack
            stack.push(nums2[i]);
        }

        // Step 2: Build result for nums1
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    result[i] = nextGreater[j];
                }

            }

        }

        return result;

    }

    // Test
    public static void main(String[] args) {
        int[] nums1 = { 4, 1, 2 };
        int[] nums2 = { 1, 3, 4, 2 };

        /*
         * This works because you're calling it from within the same class —
         * NextGreaterElement..., and from a static method (main) to another static
         * method (nextGreaterElement).
         * In Java, if you're inside the same class, you can call another static method
         * directly by name, without prefixing the class name.
         * 
         * 
         * 
         * suppose we have two methods in the same class, one method is static and other
         * is not , can we call static method inside non-static directly? yes
         */

        int[] result = nextGreaterElement(nums1, nums2);

        System.out.println(Arrays.toString(result)); // Output: [-1, 3, -1]; Arrays.deepToString(result) → prints
                                                     // elements for multi-D arrays.
    }
}
