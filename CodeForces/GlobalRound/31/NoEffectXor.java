import java.util.Scanner;

public class NoEffectXor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt())
            return;
        int t = sc.nextInt();

        while (t-- > 0) {
            long l = sc.nextLong();
            long r = sc.nextLong();

            long n = r - l + 1;

            // Condition 1: n must be a power of 2
            // Check if n > 0 and (n & (n - 1)) == 0
            if (n > 0 && (n & (n - 1)) == 0) {

                // Case A: l is aligned with the block size n
                if (l % n == 0) {
                    System.out.println(n - 1);
                }
                // Case B: The range is a "mirrored" block (like l=1, r=2)
                else if ((l ^ r) == (n + (n - 1))) {
                    // Note: In some cases like 1, 2, the XOR sum is 3 (n + n - 1)
                    // But simpler check: if l ^ x is in range for all i.
                    // For l=1, r=2, n=2: 1^3=2, 2^3=1. x=3 works.
                    // This happens if l and r share all high bits except
                    // the ones making up the range and the one bit above.
                    if (isValid(l, r, l ^ r)) {
                        System.out.println(1);
                    } else {
                        System.out.println(0);
                    }
                } else {
                    // Final check for the single x = l ^ r case
                    if (isValid(l, r, l ^ r)) {
                        System.out.println(1);
                    } else {
                        System.out.println(0);
                    }
                }
            } else {
                // If n is not a power of 2, it's impossible for x > 0
                System.out.println(0);
            }
        }
        sc.close();
    }

    // Helper to verify if a specific x keeps all frogs in [l, r]
    // Since XOR is its own inverse, we only need to check the boundaries
    private static boolean isValid(long l, long r, long x) {
        if (x <= 0)
            return false;
        long resL = l ^ x;
        long resR = r ^ x;
        // For a continuous range to map to itself via XOR,
        // the min and max must simply swap or stay put.
        return Math.min(resL, resR) == l && Math.max(resL, resR) == r;
    }
}