// https://leetcode.com/problems/next-greater-element-i/description/



import java.util.*;
import java.util.Stack;

public class NextGreaterElement {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();  // maps each num in nums2 to its next greater
        Stack<Integer> stack = new Stack<>();     // Monotonic decreasing stack    

        for (int num : nums2) {
            // Pop until current num > stack top (i.e., find next greater for stack top)
            while (!stack.isEmpty() && num > stack.peek()) {
                int top = stack.pop();
                map.put(top, num); // num is next greater for top
            }
            stack.push(num);
        }

        // Remaining stack elements have no next greater
        while (!stack.isEmpty()) {
            map.put(stack.pop(), -1);
        }

        // Build result for nums1
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            result[i] = map.get(nums1[i]);
        }

        return result;
    }

    public static void main(String[] args) {
        NextGreaterElement obj = new NextGreaterElement();

        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2};

        System.out.println(Arrays.toString(obj.nextGreaterElement(nums1, nums2)));
        // Output: [-1, 3, -1]
    }
}
