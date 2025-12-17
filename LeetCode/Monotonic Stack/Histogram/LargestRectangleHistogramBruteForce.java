// https://leetcode.com/problems/largest-rectangle-in-histogram/description/


import java.util.*;



public class LargestRectangleHistogramBruteForce {

//     public int[] largestRectangleArea(int[] heights) {
//         int n = heights.length;
//         int[] areaList = new int[n * (n + 1) / 2]; // Store all sub-rectangle areas
//         int idx = 0;

//         for (int i = 0; i < n; i++) {
//             int minHeight = heights[i];
//             for (int j = i; j < n; j++) {
//                 minHeight = Math.min(minHeight, heights[j]);
//                 int width = j - i + 1;
//                 int area = minHeight * width;
//                 areaList[idx++] = area;
//             }
//         }

//         return Arrays.copyOf(areaList, idx); // return only the filled portion
//     }

//     public static void main(String[] args) {
//         LargestRectangleHistogram lr = new LargestRectangleHistogram();
//         int[] arr = {2, 1, 5, 6, 2, 3};
//         int[] allAreas = lr.largestRectangleArea(arr);

//         System.out.println("All sub-rectangle areas: ");
//         System.out.println(Arrays.toString(allAreas));

//         int max = Arrays.stream(allAreas).max().getAsInt();
//         System.out.println("Maximum Area = " + max);
//     }
// }





//public class HistogramBruteForce {
    public static int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int maxArea = 0;

        for (int i = 0; i < n; i++) {
            int minHeight = heights[i];

            // Expand from i to the left and right
            for (int j = i; j < n; j++) {
                minHeight = Math.min(minHeight, heights[j]);
                int width = j - i + 1;
                int area = minHeight * width;
                maxArea = Math.max(maxArea, area);
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {
        int[] heights = {2, 1, 5, 6, 2, 3};
        System.out.println("Largest Rectangle Area: " + largestRectangleArea(heights));
    }
}
