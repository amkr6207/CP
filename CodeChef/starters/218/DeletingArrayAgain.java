import java.util.Scanner;

public class DeletingArrayAgain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            int T = scanner.nextInt();
            while (T-- > 0) {
                solve(scanner);
            }
        }
        scanner.close();
    }

    private static void solve(Scanner scanner) {
        int N = scanner.nextInt();
        long[] A = new long[N];
        long[] C = new long[N];

        for (int i = 0; i < N; i++) {
            A[i] = scanner.nextLong();
        }
        for (int i = 0; i < N; i++) {
            C[i] = scanner.nextLong();
        }

        long totalCost = 0;
        long minC = Long.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            if (C[i] < minC) {
                minC = C[i];
            }
            totalCost += A[i] * minC;
        }

        System.out.println(totalCost);
    }
}

// Same code in modify version

// import java.util.Scanner;

// public class Prac {

// public static void main(String[] args) {
// Scanner scanner = new Scanner(System.in);

// int testCases = scanner.nextInt(); // Number of test cases
// while (testCases-- > 0) {
// solve(scanner);
// }

// scanner.close();
// }

// private static void solve(Scanner scanner) {
// int n = scanner.nextInt();
// long[] values = new long[n];
// long[] costs = new long[n];

// // Read the values array
// for (int i = 0; i < n; i++) {
// values[i] = scanner.nextLong();
// }

// // Read the cost array
// for (int i = 0; i < n; i++) {
// costs[i] = scanner.nextLong();
// }

// long minCostSoFar = Long.MAX_VALUE;
// long totalMinimumCost = 0;

// // Iterate over the arrays to compute minimum total cost
// for (int i = 0; i < n; i++) {
// // Update the minimum cost seen so far
// if (costs[i] < minCostSoFar) {
// minCostSoFar = costs[i];
// }
// // Add cost of deleting current balloon using the smallest cost seen
// totalMinimumCost += values[i] * minCostSoFar;
// }

// System.out.println(totalMinimumCost);
// }
// }
