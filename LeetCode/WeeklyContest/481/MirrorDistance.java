// https://leetcode.com/contest/weekly-contest-481/problems/mirror-distance-of-an-integer/description/

class Solution {
    public int mirrorDistance(int n) {
        int original = n;
        int reversed = 0;

        while (n > 0) {
            reversed = reversed * 10 + (n % 10);
            n /= 10;
        }

        return Math.abs(original - reversed);
    }
}
