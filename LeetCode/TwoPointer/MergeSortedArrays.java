import java.util.Arrays;

public class MergeSortedArrays {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;           // Pointer for nums1
        int p2 = n - 1;           // Pointer for nums2
        int p = m + n - 1;        // Pointer for the end of nums1

        // Merge from the back
        while (p1 >= 0 && p2 >= 0) {
            if (nums1[p1] > nums2[p2]) {
                nums1[p] = nums1[p1];
                p1--;
            } else {
                nums1[p] = nums2[p2];
                p2--;
            }
            p--;
        }

        // If any elements left in nums2, copy them
        while (p2 >= 0) {
            nums1[p] = nums2[p2];
            p2--;
            p--;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example input
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;

        int[] nums2 = {2, 5, 6};
        int n = 3;

        // Call merge
        solution.merge(nums1, m, nums2, n);

        // Print result
        System.out.println("Merged Array: " + Arrays.toString(nums1));  // [1, 2, 2, 3, 5, 6] 
    }
}
