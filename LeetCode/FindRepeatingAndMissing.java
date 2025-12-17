// https://leetcode.com/problems/find-missing-and-repeated-values/description/



import java.util.*;

public class FindRepeatingAndMissing {
    public static int[] findErrorNums(int[][] grid) {
        int n = grid.length;  // number of rows i.e 3 here;  grid[0].length → number of columns in the first row
        //System.out.println(n);
        int N = n * n;
        Set<Integer> seen = new HashSet<>();
        int actualSum = 0;
        int repeating = -1;

        // Traverse grid to find repeating number and sum of elements
        for (int[] row : grid) {
          //  System.out.println(Arrays.toString(row));
            for (int num : row) {
                System.out.println(Arrays.toString(row));
                if (seen.contains(num)) {
                    repeating = num;
                } else {
                    seen.add(num);    // Storing unique element
                }
                actualSum += num;
            }
        }

        // Expected sum from 1 to n^2
        int expectedSum = N * (N + 1) / 2;

        // missing = expected - (actual - repeating)
        int missing = expectedSum - (actualSum - repeating);

        return new int[]{repeating, missing};
    }

    public static void main(String[] args) {
        int[][] grid = {
            {1, 2, 3},
            {4, 6, 5},
            {7, 8, 6}  // 6 is repeated, 9 is missing
        };

        int[] ans = findErrorNums(grid);
        System.out.println("Repeated: " + ans[0] + ", Missing: " + ans[1]);
    }
}
