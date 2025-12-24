import java.io.*;
import java.util.*;

public class ColouredBalloons {
    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();
        StringBuilder sb = new StringBuilder();

        int T = fs.nextInt();
        while (T-- > 0) {
            int N = fs.nextInt();
            long totalCost = 0;

            for (int i = 1; i <= N; i++) {
                int Ai = fs.nextInt();
                totalCost += (long) i * Ai;
            }

            sb.append(totalCost).append('\n');
        }

        System.out.print(sb.toString());
    }

    // Fast Input Reader
    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int nextInt() throws IOException {
            while (st == null || !st.hasMoreElements()) {
                st = new StringTokenizer(br.readLine());
            }
            return Integer.parseInt(st.nextToken());
        }
    }
}
