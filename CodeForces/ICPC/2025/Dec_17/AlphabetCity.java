import java.io.*;
import java.util.*;

public class AlphabetCity {

    static int n;
    static long m;
    static int[][] cnt; // cnt[i][c] = count of char c in s_i
    static long[] total; // total count of each character across all strings

    // Check feasibility for fixed l (index) and k
    static boolean canBuild(int l, long k) {
        long mk = m - k;
        int[] cntL = cnt[l];

        for (int c = 0; c < 26; c++) {
            long others = total[c] - cntL[c];
            // (m - k) * (total[c] - cnt[l][c]) >= cnt[l][c]
            if (mk * others < cntL[c]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Long.parseLong(st.nextToken());

        cnt = new int[n][26];
        total = new long[26];

        // Read strings and count letters
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < s.length(); j++) {
                int c = s.charAt(j) - 'A';
                cnt[i][c]++;
                total[c]++;
            }
        }

        StringBuilder out = new StringBuilder();

        // Process each missing index l
        for (int l = 0; l < n; l++) {

            // First check k = 0 feasibility
            boolean ok = true;
            for (int c = 0; c < 26; c++) {
                long available = m * (total[c] - cnt[l][c]);
                if (available < cnt[l][c]) {
                    ok = false;
                    break;
                }
            }

            if (!ok) {
                out.append("-1\n");
                continue;
            }

            // Binary search for maximum k
            long low = 0, high = m;
            while (low < high) {
                long mid = (low + high + 1) >> 1;
                if (canBuild(l, mid)) {
                    low = mid;
                } else {
                    high = mid - 1;
                }
            }

            out.append(low).append('\n');
        }

        System.out.print(out.toString());
    }
}
