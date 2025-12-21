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
