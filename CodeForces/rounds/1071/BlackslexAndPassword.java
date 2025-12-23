import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BlackslexAndPassword {
    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();
        StringBuilder sb = new StringBuilder();

        int t = fs.nextInt();
        while (t-- > 0) {
            int k = fs.nextInt();
            int x = fs.nextInt();

            // Minimal n where no valid string exists
            int n = k * x + 1;
            sb.append(n).append('\n');
        }

        System.out.print(sb.toString());
    }

    // Fast input reader for competitive programming
    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String next() throws IOException {
            while (st == null || !st.hasMoreElements()) {
                st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }
}

// import java.util.Scanner;

// public class Main {
// public static void main(String[] args) {
// Scanner sc = new Scanner(System.in);

// int tests = sc.nextInt();
// while (tests-- > 0) {
// int k = sc.nextInt();
// int x = sc.nextInt();

// // smallest length where condition breaks
// int result = (k + 1) * x - (x - 1);
// System.out.println(result);
// }
// }
// }
