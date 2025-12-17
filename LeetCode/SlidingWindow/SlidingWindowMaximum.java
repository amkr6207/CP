// https://leetcode.com/problems/sliding-window-maximum/description/



import java.util.*;

public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k <= 0) return new int[0];

        int n = nums.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> deque = new ArrayDeque<>(); // Store indices
        // int ri=0;

        for (int i = 0; i < n; i++) {

            // 1. Remove indices out of the current window (from front);
            // Remove elements from front if they are out of the current window (i - k).
            if (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }

            // 2. Remove indices of elements smaller than current (from back)
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            // 3. Add current index to the back
            deque.offerLast(i);

            // 4. If window has hit size k, record the max (which is at front)
            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peekFirst()];
            }

            // if (i >= k - 1) {
            //     result[ri++] = nums[deque.peek()]; 
            // } same as if statement above
        }
        

        return result;
    }

    // Main method to test
    public static void main(String[] args) {
        SlidingWindowMaximum swm = new SlidingWindowMaximum();
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        System.out.println(Arrays.toString(swm.maxSlidingWindow(nums, k)));
    }
}
