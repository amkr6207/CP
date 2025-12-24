import java.io.*;
import java.util.*;

public class CountingOptimalArrays {

    static final long MOD = 998244353;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();
        StringBuilder out = new StringBuilder();

        int T = fs.nextInt();
        while (T-- > 0) {
            long N = fs.nextLong();
            long M = fs.nextLong();

            // Case N = 1
            if (N == 1) {
                out.append((M + 1) % MOD).append('\n');
                continue;
            }

            // Compute highest power of 2 <= M
            long highestBit = 1L << (63 - Long.numberOfLeadingZeros(M));

            // Maximum possible XOR
            long Xmax = (highestBit << 1) - 1;

            // Count valid starting values x
            long left = Math.max(0, Xmax - M);
            long right = Math.min(M, Xmax);

            long ans = Math.max(0, right - left + 1);
            out.append(ans % MOD).append('\n');
        }

        System.out.print(out.toString());
    }

    // Fast input reader
    static class FastScanner {
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;
        private final InputStream in = System.in;

        private int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0)
                    return -1;
            }
            return buffer[ptr++];
        }

        long nextLong() throws IOException {
            int c;
            do {
                c = read();
            } while (c <= ' ');

            boolean neg = false;
            if (c == '-') {
                neg = true;
                c = read();
            }

            long val = 0;
            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = read();
            }
            return neg ? -val : val;
        }

        int nextInt() throws IOException {
            return (int) nextLong();
        }
    }
}
