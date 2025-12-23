import java.io.*;
import java.util.*;

public class BlackslexAndPenguinCivilization {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        try {
            int testCases = Integer.parseInt(br.readLine().trim());
            for (int tc = 0; tc < testCases; tc++) {
                int n = Integer.parseInt(br.readLine().trim());
                int[] result = generateSacredPermutation(n);
                for (int i = 0; i < result.length; i++) {
                    out.print(result[i] + (i == result.length - 1 ? "" : " "));
                }
                out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        out.flush();
    }

    // Iterative method to construct lexicographically minimal sacred permutation
    static int[] generateSacredPermutation(int n) {
        int[] permutation = { 0 }; // base case
        for (int k = 0; k < n; k++) {
            int len = permutation.length;
            int[] nextPerm = new int[len * 2];

            // First half: map previous numbers to odd indices
            for (int i = 0; i < len; i++) {
                nextPerm[i] = permutation[i] * 2 + 1;
            }

            // Second half: even numbers in ascending order
            for (int i = 0; i < len; i++) {
                nextPerm[len + i] = i * 2;
            }

            permutation = nextPerm;
        }
        return permutation;
    }
}
