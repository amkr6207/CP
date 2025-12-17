/* https://leetcode.com/problems/contains-duplicate/description/   */


import java.util.*;

public class Duplicate {

    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            }
            set.add(num);
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the size of any array");
        int n = sc.nextInt();

        int nums[] = new int[n];
        System.out.println("Enter the elements of the array");

        for (int i = 0; i < nums.length; i++) {
            nums[i] = sc.nextInt();
        }
        
        sc.close();

        Duplicate b = new Duplicate();
        System.out.println(b.containsDuplicate(nums));
    }
}
