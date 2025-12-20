import java.util.*;
import java.io.*;

public class XORFactor {
    public static void main(String[] args) throws IOException {
        // Fast I/O using BufferedReader and StringTokenizer
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        String firstLine = br.readLine();
        if (firstLine == null)
            return;
        int t = Integer.parseInt(firstLine.trim());

        while (t-- > 0) {
            String line = br.readLine();
            if (line == null)
                break;
            StringTokenizer st = new StringTokenizer(line);
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            int[] a = new int[k];

            if ((k & 1) != 0) {
                // If k is odd, setting all elements to n is the maximum possible.
                // (n ^ n ^ ... ^ n) odd times = n
                for (int i = 0; i < k; i++) {
                    a[i] = n;
                }
            } else {
                // If k is even, we use the Tight/Loose greedy approach.
                int p = 0; // Count of 'Loose' indices (numbers already < n)
                for (int i = 30; i >= 0; i--) {
                    int bitVal = (1 << i);
                    if (((n >> i) & 1) != 0) {
                        // n has a 1-bit: We can use k-1 ones.
                        // We skip the first 'Tight' index to make it 'Loose'.
                        int skipIndex = Math.min(p, k - 1);
                        for (int j = 0; j < k; j++) {
                            if (j != skipIndex) {
                                a[j] |= bitVal;
                            }
                        }
                        // The index we skipped is now Loose.
                        if (p < k)
                            p++;
                    } else {
                        // n has a 0-bit: Only 'Loose' indices can take a 1-bit.
                        // We take the largest even number of Loose indices.
                        int count = (p / 2) * 2;
                        for (int j = 0; j < count; j++) {
                            a[j] |= bitVal;
                        }
                    }
                }
            }

            // Print the sequence
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < k; i++) {
                sb.append(a[i]).append(i == k - 1 ? "" : " ");
            }
            out.println(sb.toString());
            // If u want individual prints then close the outer out.flush(); and
            // uncomment the below
            // out.flush();
        }
        out.flush();
        out.close();
    }
}