//https://leetcode.com/problems/find-the-duplicate-number/description/



public class FindDuplicate {
    public static int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];

        // Phase 1: Detect intersection point inside the cycle 
        do {
            slow = nums[slow];              // move slow 1 step
            fast = nums[nums[fast]];        // move fast 2 steps 
        } while (slow != fast);

        // Phase 2: Find the entrance to the cycle
        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];             // move slow 1 step
            fast = nums[fast];             // move fast 1 step
        }

        return slow;   // or fast
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 4, 2, 2}; // Input
        int duplicate = findDuplicate(nums);
        System.out.println("Duplicate number: " + duplicate);
    }
}
