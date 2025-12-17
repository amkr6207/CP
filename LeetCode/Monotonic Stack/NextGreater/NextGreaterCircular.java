// https://leetcode.com/problems/next-greater-element-ii/description/



import java.util.Stack;
import java.util.Arrays;


public class NextGreaterCircular {
    public static int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();  // stores indices
        Arrays.fill(result, -1);  // default is -1

        // Traverse the array 2*n times in reverse order
        for (int i = 2 * n - 1; i >= 0; i--) {
            int currIndex = i % n;

            // Remove all smaller elements from the stack
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[currIndex]) {
                stack.pop();
            }

            // If stack is not empty, top is the next greater element
            if (!stack.isEmpty()) {                                           // or result[currIndex] = stack.isEmpty() ? -1 : nums[stack.peek()];
                result[currIndex] = nums[stack.peek()];     
            }

            // Push current index to stack
            stack.push(currIndex);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 1};
        int[] result = nextGreaterElements(nums);

        System.out.println("Next Greater Elements: " + Arrays.toString(result));
    }
}


