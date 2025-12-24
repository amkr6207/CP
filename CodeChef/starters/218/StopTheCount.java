import java.io.*;
import java.util.*;

public class StopTheCount {
    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();
        StringBuilder sb = new StringBuilder();

        int T = fs.nextInt();
        while (T-- > 0) {
            int N = fs.nextInt();
            String S = fs.next();

            int countOnes = 0;
            int ways = 0;

            for (int k = 1; k <= N; k++) {
                if (S.charAt(k - 1) == '1') {
                    countOnes++;
                }
                if (2 * countOnes > k) {
                    ways++;
                }
            }

            sb.append(ways).append('\n');
        }

        System.out.print(sb.toString());
    }

    // Fast input Reader ; Here we used different ways from the previous (i.e Q2
    // )due to requirements of String & int
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
