/* Questions:  https://leetcode.com/problems/two-sum/description/?envType=problem-list-v2&envId=array
 * 
 */




import java.util.Scanner;

public class SumTwo {

    // Static method to allow direct call from main 
    public  int[] twoSum(int[] nums, int target) {
        // Brute-force approach: check all pairs
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] {i, j}; // return as array
                }
            }
        }
        return new int[] {-1, -1}; // return if no solution found
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter the size of the array:");
        int size = sc.nextInt();
        int arr[] = new int[size];

        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("Enter the target sum:");
        int target = sc.nextInt();
        SumTwo p = new SumTwo();

        int[] result = p.twoSum(arr, target);

        if (result[0] == -1) {
            System.out.println("No two elements add up to the target.");
        } else {
            System.out.println("Indices: " + result[0] + " and " + result[1]);
            System.out.println("Values: " + arr[result[0]] + " + " + arr[result[1]] + " = " + target);
        }

        sc.close();
    }
}










/*
 * 
 * import java.util.HashMap;

public class Solution {
    public static int[] twoSum(int[] nums, int target) {
        // Map to store value -> index
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            // If complement already exists, return both indices
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }

            // Otherwise, store current number and its index
            map.put(nums[i], i);
        }

        // Return empty if no solution found (though it's guaranteed to have one)
        return new int[0];
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        int[] result = twoSum(nums, target);
        if(result.length ==2){
            System.out.println("Output: [" + result[0] + "," + result[1] + "]");
        }
        else{
            System.out.println("Target not found");
        }
        
    }
}

 */