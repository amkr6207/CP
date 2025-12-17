// https://leetcode.com/problems/powx-n/description/


public class Power {

    public double myPow(double x, int n) {
        if (n == 0) return 1;
        
        long N = n; // Convert to long to handle Integer.MIN_VALUE
        if (N < 0) {
            x = 1 / x;
            N = -N;      // Make power positive (to apply loop logic)
        }

        double result = 1;
        while (N > 0) {
            if (N % 2 == 1) {
                result *= x;
            }
            x *= x;
            N /= 2;
        }

        return result;
    }

    public static void main(String[] args) {
        Power sol = new Power();

        double x = 2.00000;
        int n = 10;

        double result = sol.myPow(x, n);
        System.out.println("Result: " + result);
    }
}
