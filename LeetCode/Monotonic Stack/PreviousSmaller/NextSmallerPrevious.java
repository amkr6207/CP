import java.util.Arrays;
import java.util.Stack;

public class NextSmallerPrevious{
    public static int[] smallerElement(int[] nums){
        int n= nums.length;
        int[] nextSmaller = new int[n];
        Stack<Integer> stack = new Stack<>();   // values increases from bottom to top

        for (int i = 0; i < n; i++) {
            while(!stack.isEmpty() && stack.peek() >=nums[i]){
                stack.pop();
            }

            nextSmaller[i]= stack.isEmpty()? -1: stack.peek();
            stack.push(nums[i]);
            
        }
        return nextSmaller;
    }




    public static void main(String[] args) {
        int[] arr = {3,1,0,8,6};
        int[] result = smallerElement(arr);
        System.out.println(Arrays.toString(result));
      //  System.out.println("Output is: "  + Arrays.toString(result));       println doesn't support comma so we use +

    }
}