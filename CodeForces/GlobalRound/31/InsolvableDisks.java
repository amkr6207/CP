import java.util.Scanner;

public class InsolvableDisks {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        if (!sc.hasNextInt())
            return;
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            long[] x = new long[n];
            for (int i = 0; i < n; i++) {
                x[i] = sc.nextLong();
            }

            if (n < 2) {
                System.out.println(0);
                continue;
            }

            int chains = 1;
            double low = 0;
            double high = 2e9;

            int multiplier = 1;
            long offset = 0;

            for (int i = 0; i < n - 1; i++) {
                long d = x[i + 1] - x[i];

                int nextMultiplier = -multiplier;
                long nextOffset = d - offset;

                double currentLow = low;
                double currentHigh = high;

                if (nextMultiplier == 1) {
                    if (-nextOffset > currentLow)
                        currentLow = -nextOffset;
                } else {
                    if (nextOffset < currentHigh)
                        currentHigh = nextOffset;
                }

                if (currentLow >= currentHigh) {
                    chains++;

                    low = 0;
                    high = 2e9;
                    multiplier = 1;
                    offset = 0;

                    long newD = x[i + 1] - x[i];
                    multiplier = -1;
                    offset = newD;
                    high = newD;
                } else {
                    low = currentLow;
                    high = currentHigh;
                    multiplier = nextMultiplier;
                    offset = nextOffset;
                }
            }

            System.out.println(n - chains);
        }
        sc.close();
    }
}