//https://leetcode.com/problems/frog-jump/description/

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FJump {
    private int[] stones;
    private int n;
    // memo[i][k] = Boolean: have we already tried from stone i with lastJump = k ?
    private Boolean[][] memo;
    // map from position -> index in stones[]
    private Map<Integer, Integer> posMap;

    public boolean canCross(int[] stones) {
        this.stones = stones;
        this.n = stones.length;
        // Quick check: if second stone isn’t at position 1, cannot make the first jump
        if (n >= 2 && stones[1] != 1)
            return false;

        posMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            posMap.put(stones[i], i);
        }

        // memo table: size n × (n+1) to be safe
        memo = new Boolean[n][n + 1];

        // start from stone 0 with last jump = 0 → first real jump must be 1
        return dfs(0, 0);
    }

    private boolean dfs(int idx, int lastJump) {
        // If reached the last stone
        if (idx == n - 1)
            return true;

        // If already computed this state, return cached result
        if (memo[idx][lastJump] != null) {
            return memo[idx][lastJump];
        }

        int currPos = stones[idx];

        // Try possible next jumps
        for (int jump = lastJump - 1; jump <= lastJump + 1; jump++) {
            if (jump <= 0)
                continue; // must jump forward at least 1
            int nextPos = currPos + jump;
            if (posMap.containsKey(nextPos)) {
                int nextIdx = posMap.get(nextPos);
                if (dfs(nextIdx, jump)) {
                    memo[idx][lastJump] = true;
                    return true;
                }
            }
        }

        memo[idx][lastJump] = false;
        return false;
    }

    // ---------------- MAIN METHOD ----------------
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        FJump obj = new FJump();

        System.out.println("Enter number of stones: ");
        int n = sc.nextInt();

        int[] stones = new int[n];
        System.out.println("Enter stone positions (sorted, space-separated):"); // 0 1 3 5 6 8 12 17
        for (int i = 0; i < n; i++) {
            stones[i] = sc.nextInt();
        }

        boolean result = obj.canCross(stones);

        System.out.println("Can the frog cross? " + result);
    }
}
