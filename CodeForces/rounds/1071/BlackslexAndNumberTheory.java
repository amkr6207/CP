import java.io.*;
import java.util.*;

public class BlackslexAndNumberTheory {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();

        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr);
            int minVal = arr[0];

            int smallestGap = Integer.MAX_VALUE;
            boolean canUseGap = true;

            for (int i = 1; i < n; i++) {
                if (arr[i] <= 2 * minVal) {
                    canUseGap = false;
                    break;
                }
                smallestGap = Math.min(smallestGap, arr[i] - minVal);
            }

            if (!canUseGap) {
                out.append(minVal).append('\n');
            } else {
                out.append(Math.max(minVal, smallestGap)).append('\n');
            }
        }

        System.out.print(out.toString());
    }
}
