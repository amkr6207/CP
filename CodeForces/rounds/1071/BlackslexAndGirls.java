import java.io.*;
import java.util.*;

public class BlackslexAndGirls {
    public static void main(String[] args) {
        FastReader sc = new FastReader();
        PrintWriter out = new PrintWriter(System.out);

        int t = 0;
        if (sc.hasNext()) {
            t = sc.nextInt();
        }

        while (t-- > 0) {
            int n = sc.nextInt();
            long x = sc.nextLong();
            long y = sc.nextLong();
            String s = sc.next();
            int[] p = new int[n];
            for (int i = 0; i < n; i++) {
                p[i] = sc.nextInt();
            }

            if (solve(n, x, y, s, p)) {
                out.println("YES");
            } else {
                out.println("NO");
            }
        }
        out.flush();
    }

    static boolean solve(int n, long x, long y, String s, int[] p) {
        long reqA = 0;
        long reqB = 0;
        boolean has0 = false;
        boolean has1 = false;

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '0')
                has0 = true;
            else
                has1 = true;

            int pi = p[i];
            // Calculate minimum requirements for this district
            long val = (pi / 2) + 1;

            if (c == '0') {
                // A wins: a >= b + 1
                // a = val, b = pi - val
                reqA += val;
                reqB += (pi - val);
            } else {
                // B wins: b >= a + 1
                // b = val, a = pi - val
                reqB += val;
                reqA += (pi - val);
            }
        }

        if (x < reqA || y < reqB) {
            return false;
        }

        if (has0 && has1) {
            return true;
        }

        if (has0) {
            // All 0s (A wins everywhere)
            // Condition: sum(a) - sum(b) >= n
            // Since sum(a) = x, sum(b) = y
            return (x - y) >= n;
        } else {
            // All 1s (B wins everywhere)
            // Condition: sum(b) - sum(a) >= n
            return (y - x) >= n;
        }
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        boolean hasNext() {
            try {
                // Check if there is more input, handling potential whitespace/empty lines
                if (st != null && st.hasMoreTokens())
                    return true;
                String line = br.readLine();
                while (line != null && line.trim().isEmpty()) {
                    line = br.readLine();
                }
                if (line == null)
                    return false;
                st = new StringTokenizer(line);
                return true;
            } catch (IOException e) {
                return false;
            }
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    String line = br.readLine();
                    if (line == null)
                        return null;
                    st = new StringTokenizer(line);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }
    }
}
