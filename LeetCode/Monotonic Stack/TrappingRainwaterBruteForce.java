// https://leetcode.com/problems/trapping-rain-water/description/



public class TrappingRainwaterBruteForce {
    public static int trap(int[] height) {
        int n = height.length;
        int totalWater = 0;

        // Loop through each bar (excluding the first and last)
        for (int i = 1; i < n - 1; i++) {
            int maxLeft = 0;
            int maxRight = 0;

            // Find the tallest bar on the left of current index
            for (int j = 0; j <= i; j++) {
                maxLeft = Math.max(maxLeft, height[j]);
            }

            // Find the tallest bar on the right of current index
            for (int j = i; j < n; j++) {
                maxRight = Math.max(maxRight, height[j]);
            }

            // Water trapped at index i
            int waterAtI = Math.min(maxLeft, maxRight) - height[i];

            // Add to total only if it's positive
            if (waterAtI > 0) {
                totalWater += waterAtI;
            }
        }

        return totalWater;
    }

    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println("Trapped Water: " + trap(height)); // Output: 6
    }
}
