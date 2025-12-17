import java.util.Arrays;

public class FibMemo {

    public static int climbStairs(int n) {
        int[] dp = new int[n + 1];
        if (n <= 2)
            return n;
        if (dp[n] != -1)
            return dp[n];

        dp[n] = climbStairs(n - 1) + climbStairs(n - 2);
        return dp[n];
    }

    public static void main(String[] args) {
        int n = -1;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        System.out.println(climbStairs(n));

    }

}
