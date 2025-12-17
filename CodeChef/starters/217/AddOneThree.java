import java.util.*;

class Codechef {
    public static void main(String[] args) throws java.lang.Exception {
        // your code goes here
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            long N = sc.nextInt();
            long M = sc.nextInt();

            if (M >= N && M <= 3 * N && (M % 2 == N % 2)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }

    }
}
