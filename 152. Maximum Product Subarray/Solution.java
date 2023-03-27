import java.util.*;

public class Solution {

    public int maxProduct(int[] nums) {
        int minProduct = 1;
        int maxProduct = 1;
        int result = Integer.MIN_VALUE;
    
        //Finding maximum element in the array.
        for (int i : nums) if (i > result) result = i;
        
        int temp;
        for (int n : nums)
        {
            temp = minProduct; //Temp variable is needed since value of minProduct will be used on the next line.
            minProduct = Math.min(Math.min(n, n * minProduct), n *  maxProduct);
            maxProduct = Math.max(Math.max(n, n * temp), n *  maxProduct);
            result = Math.max(maxProduct, result);
        }
        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.maxProduct(new int[]{-2, 0, -1});
    }

}