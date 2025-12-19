import java.util.*;
import java.io.*;

public class XORFactor {
    public static void main(String[] args) throws IOException {
        // Fast I/O using BufferedReader and StringTokenizer
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            StringJoiner sj = new StringJoiner(" ");

            if (k % 2 != 0) {
                // If k is odd, all elements can be n
                // n ^ n ^ ... ^ n (odd times) = n
                for (int i = 0; i < k; i++) {
                    sj.add(String.valueOf(n));
                }
            } else {
                // If k is even, k-1 elements can be n and the last one 0
                // (n ^ ... ^ n) (even times) ^ 0 = 0 ^ 0 = 0 (Incorrect)
                // Correct: (n ^ ... ^ n) (odd times) ^ 0 = n ^ 0 = n
                for (int i = 0; i < k - 1; i++) {
                    sj.add(String.valueOf(n));
                }
                sj.add("0");
            }

            out.println(sj.toString());
        }
        out.flush();
        out.close();
    }
}