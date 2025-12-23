import java.io.*;
import java.util.*;

public class BlackslexAndShowering {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();

        int t = Integer.parseInt(br.readLine()); // No of test cases

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] a = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }

            long originalSum = 0;
            for (int i = 0; i + 1 < n; i++) {
                originalSum += Math.abs(a[i] - a[i + 1]);
            }

            long answer = originalSum;

            answer = Math.min(answer, originalSum - Math.abs(a[0] - a[1])); // Remove first element

            answer = Math.min(answer, originalSum - Math.abs(a[n - 2] - a[n - 1])); // Remove last element

            // Remove any middle element
            for (int i = 1; i + 1 < n; i++) {
                long reduced = originalSum
                        - Math.abs(a[i - 1] - a[i])
                        - Math.abs(a[i] - a[i + 1])
                        + Math.abs(a[i - 1] - a[i + 1]);

                answer = Math.min(answer, reduced);
            }

            out.append(answer).append('\n');
        }

        System.out.print(out);
    }
}
