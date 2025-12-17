// https://leetcode.com/problems/single-number/description/


public class SingleNumberFinder {

    public static int singleNumber(int[] nums) {
        int result = 0;

        // XOR all numbers using for-each loop
        for (int num : nums) {
            System.out.println("Before XOR: " + result + " ^ " + num + " = " + (result ^ num));
            result ^= num;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 4, 5, 6, 2, 4, 3, 7, 5, 6};

        int unique = singleNumber(nums);
        System.out.println("\nThe number that appears only once is: " + unique);
    }
}
