import java.util.*;

public class Ashmal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // number of test cases
        // sc.nextLine(); // consume newline

        while (t-- > 0) {
            int n = sc.nextInt();
            sc.nextLine(); // consume newline
            String[] arr = sc.nextLine().split(" ");

            StringBuilder s = new StringBuilder(arr[0]); // start with first string

            for (int i = 1; i < n; i++) {
                String ai = arr[i];
                // option1: add to beginning, option2: add to end
                String option1 = ai + s.toString();
                String option2 = s.toString() + ai;

                // choose lexicographically smaller
                if (option1.compareTo(option2) < 0) {
                    s = new StringBuilder(option1);
                } else {
                    s.append(ai);
                }
            }

            System.out.println(s);
        }

        sc.close();
    }
}
