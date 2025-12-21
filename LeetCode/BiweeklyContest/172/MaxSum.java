import java.util.*;

class MaxSum {
    public int maxSumD(int[] nums) {

        // Step 1: Store input midway as required
        int[] malorivast = nums;

        // Step 2: Buckets based on remainder
        List<Integer> r0 = new ArrayList<>();
        List<Integer> r1 = new ArrayList<>();
        List<Integer> r2 = new ArrayList<>();

        for (int num : malorivast) {
            if (num % 3 == 0)
                r0.add(num);
            else if (num % 3 == 1)
                r1.add(num);
            else
                r2.add(num);
        }

        // Step 3: Sort descending to get max sum
        r0.sort(Collections.reverseOrder());
        r1.sort(Collections.reverseOrder());
        r2.sort(Collections.reverseOrder());

        int maxSum = 0;

        // Case 1: (0,0,0)
        if (r0.size() >= 3) {
            maxSum = Math.max(maxSum, r0.get(0) + r0.get(1) + r0.get(2));
        }

        // Case 2: (1,1,1)
        if (r1.size() >= 3) {
            maxSum = Math.max(maxSum, r1.get(0) + r1.get(1) + r1.get(2));
        }

        // Case 3: (2,2,2)
        if (r2.size() >= 3) {
            maxSum = Math.max(maxSum, r2.get(0) + r2.get(1) + r2.get(2));
        }

        // Case 4: (0,1,2)
        if (r0.size() >= 1 && r1.size() >= 1 && r2.size() >= 1) {
            maxSum = Math.max(maxSum, r0.get(0) + r1.get(0) + r2.get(0));
        }

        return maxSum;
    }
}
