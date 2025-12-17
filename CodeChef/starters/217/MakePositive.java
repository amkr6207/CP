// https://www.codechef.com/problems/ADDPOS

import java.util.*;

public class MakePositive {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int N = sc.nextInt();
            long sum = 0;

            for (int i = 0; i < N; i++) {
                sum += sc.nextInt();
            }

            if (sum >= 0) {
                System.out.println(0);
            } else {
                long X = (-sum + N - 1) / N; // ceiling division
                System.out.println(X);
            }
        }
    }
}
