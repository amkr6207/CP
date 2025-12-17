// https://codeforces.com/contest/2157/problem/A

import java.util.Scanner;

public class Count {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of tests:");
        int t = sc.nextInt();

        while (t-- > 0) {

            System.out.println("Enter the size of the array:");
            int n = sc.nextInt();
            int[] freq = new int[n + 1]; // frequencies of numbers 0..n

            System.out.println("Enter the elements:");

            // Step 1: Read input array
            for (int i = 0; i < n; i++) {
                int x = sc.nextInt();

                // count only values in the valid range [0, n]
                if (x >= 0 && x <= n) {
                    freq[x]++;
                }
            }

            // Step 2: Count how many elements we can keep
            int keep = 0;
            for (int v = 1; v <= n; v++) {
                if (freq[v] >= v) {
                    keep += v;
                }
            }

            // Step 3: Output result
            int answer = n - keep;

            System.out.println("Minimum elements to remove = " + answer);
        }

        sc.close();
    }
}

// import java.util.*;

// public class Main {
// public static void main(String[] args) {
// Scanner sc = new Scanner(System.in);
// int t = sc.nextInt();

// while (t-- > 0) {
// int n = sc.nextInt();
// int[] freq = new int[n + 1]; // frequencies of numbers 0..n

// // Step 1: Count frequencies
// for (int i = 0; i < n; i++) {
// int x = sc.nextInt();
// if (x >= 0 && x <= n) {
// freq[x]++;
// }
// }

// // Step 2: Count how many elements we can keep
// int keep = 0;
// for (int v = 1; v <= n; v++) {
// if (freq[v] >= v) { // can we keep exactly v copies?
// keep += v;
// }
// }

// // Step 3: Answer = total - kept
// System.out.println(n - keep);
// }
// }
// }
