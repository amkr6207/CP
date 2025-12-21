// https://leetcode.com/problems/maximum-score-after-binary-swaps/description/

import java.util.PriorityQueue;

class Solution {
    public long maximumScore(int[] nums, String s) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        long score = 0;

        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];

            if (s.charAt(i) == '0') {
                // value is available for future '1'
                maxHeap.offer(val);
            } else {
                // s[i] == '1'
                if (maxHeap.isEmpty()) {
                    score += val;
                } else {
                    int best = maxHeap.poll();
                    score += Math.max(best, val);

                    // leftover becomes available
                    maxHeap.offer(Math.min(best, val));
                }
            }
        }

        return score;
    }
}
