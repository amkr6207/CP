// https://leetcode.com/contest/weekly-contest-481/problems/minimum-swaps-to-avoid-forbidden-values/description/

import java.util.HashMap;

class Solution {
    public int minimumSwaps(int[] nums, int[] forbidden) {
        int n = nums.length;

        // Step 1: Count forbidden frequencies
        HashMap<Integer, Integer> forbCount = new HashMap<>();
        for (int x : forbidden) {
            forbCount.put(x, forbCount.getOrDefault(x, 0) + 1);
        }

        // Step 2: Count nums frequencies and check impossibility
        HashMap<Integer, Integer> numCount = new HashMap<>();
        for (int x : nums) {
            numCount.put(x, numCount.getOrDefault(x, 0) + 1);
        }

        for (int x : numCount.keySet()) {
            int cntNums = numCount.get(x);
            int cntForb = forbCount.getOrDefault(x, 0);
            if (cntNums > n - cntForb) {
                return -1;
            }
        }

        // Step 3: Identify bad indices
        boolean[] bad = new boolean[n];
        int badCount = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == forbidden[i]) {
                bad[i] = true;
                badCount++;
            }
        }

        if (badCount == 0)
            return 0;

        // Step 4: Build value -> index mapping for bad indices
        HashMap<Integer, Integer> valueToIndex = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (bad[i]) {
                valueToIndex.put(nums[i], i);
            }
        }

        // Step 5: Count cycles
        boolean[] visited = new boolean[n];
        int cycles = 0;

        for (int i = 0; i < n; i++) {
            if (bad[i] && !visited[i]) {
                int cur = i;
                boolean isCycle = true;

                while (!visited[cur]) {
                    visited[cur] = true;
                    int nextValue = forbidden[cur];
                    if (!valueToIndex.containsKey(nextValue)) {
                        isCycle = false;
                        break;
                    }
                    cur = valueToIndex.get(nextValue);
                }

                if (isCycle)
                    cycles++;
            }
        }

        return badCount + cycles;
    }
}
