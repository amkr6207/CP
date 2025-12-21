// https://leetcode.com/contest/weekly-contest-481/problems/minimum-deletion-cost-to-make-all-characters-equal/description/

class Solution {
    public long minimumDeletionCost(String s, int[] cost) {
        long totalCost = 0;
        long[] charSum = new long[26];

        for (int i = 0; i < s.length(); i++) {
            totalCost += cost[i];
            charSum[s.charAt(i) - 'a'] += cost[i];
        }

        long maxKeep = 0;
        for (long sum : charSum) {
            maxKeep = Math.max(maxKeep, sum);
        }

        return totalCost - maxKeep;
    }
}
