//import java.util.*;

// https://leetcode.com/problems/maximum-subarray/description/




public class MaxSubarraySumBruteForce {
    
   static int maxSum(int [] nums){
        int maxSum= Integer.MIN_VALUE;
        
        for (int i = 0; i < nums.length; i++) {
            int currSum=0;
            for (int j = i; j < nums.length; j++) {
                 currSum+= nums[j];
                 maxSum= Math.max(maxSum, currSum);
                
            }
        }
        return maxSum;
    }


    public static void main(String[] args) {
        int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println("Maximum sum is:  " + maxSum(arr));

    }
}
