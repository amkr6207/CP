// https://www.codechef.com/problems/TOYS

import java.util.*;

public class PlayingToys {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        System.out.println(Math.max(0, N - M));

    }
}
