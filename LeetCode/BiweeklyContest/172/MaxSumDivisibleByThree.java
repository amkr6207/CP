// https://leetcode.com/problems/maximum-sum-of-three-numbers-divisible-by-three/

import java.util.Arrays;

public class MaxSumDivisibleByThree {
    public int maximumSum(int[] nums) {
        // Top 3 numbers for remainder 0, 1, 2
        int[] r0 = new int[3];
        int[] r1 = new int[3];
        int[] r2 = new int[3];

        // Initialize arrays with 0
        Arrays.fill(r0, 0);
        Arrays.fill(r1, 0);
        Arrays.fill(r2, 0);

        for (int num : nums) {
            int rem = num % 3;
            if (rem == 0)
                insertTop3(r0, num);
            else if (rem == 1)
                insertTop3(r1, num);
            else
                insertTop3(r2, num);
        }

        int maxSum = 0;

        // Case 1: Three from r0
        if (r0[2] > 0)
            maxSum = Math.max(maxSum, r0[0] + r0[1] + r0[2]);
        // Case 2: Three from r1
        if (r1[2] > 0)
            maxSum = Math.max(maxSum, r1[0] + r1[1] + r1[2]);
        // Case 3: Three from r2
        if (r2[2] > 0)
            maxSum = Math.max(maxSum, r2[0] + r2[1] + r2[2]);
        // Case 4: One from each remainder
        if (r0[0] > 0 && r1[0] > 0 && r2[0] > 0)
            maxSum = Math.max(maxSum, r0[0] + r1[0] + r2[0]);

        return maxSum;
    }

    // Helper function to keep top 3 largest numbers
    private void insertTop3(int[] arr, int num) {
        if (num > arr[0]) {
            arr[2] = arr[1];
            arr[1] = arr[0];
            arr[0] = num;
        } else if (num > arr[1]) {
            arr[2] = arr[1];
            arr[1] = num;
        } else if (num > arr[2]) {
            arr[2] = num;
        }
    }
}
