// https://leetcode.com/problems/climbing-stairs/description/

public class ClimbStairs {
    public static int climbStairs(int n) {
        if (n <= 2)
            return n;
        int prev2 = 1; // ways to climb 1 step
        int prev1 = 2; // ways to climb 2 step

        for (int i = 3; i <= n; i++) {
            int nextStairs = prev2 + prev1;
            prev2 = prev1;
            prev1 = nextStairs;

        }
        return prev1;
    }

    public static void main(String[] args) {
        int ways = climbStairs(4);
        System.out.println(ways);
    }
}