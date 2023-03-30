import java.util.Arrays;

class Solution {

    //link = https://leetcode.com/problems/longest-increasing-subsequence/description/

    public int lengthOfLIS(int[] nums) {
        
        int N = nums.length;
      
        int[] dpArray = new int[N];
        Arrays.fill(dpArray, 1);
        int i, j;
        for (i = 1; i < N; i++)
        {
            for (j = 0; j < i; j++)
            {
                //First statement: if there is a increasing sequence
                //Second statement: if we have already counted those numbers.
                if (nums[j] < nums[i] && dpArray[i] < dpArray[j] + 1)
                    dpArray[i] = dpArray[j] + 1;
                //Note: using double ampersand is more efficient &&
                //Because if first expression is false, it stops evaluating
            }
        }
   
        int max = Integer.MIN_VALUE;
        for (int num : dpArray) if (num > max) max = num;
        return max;
    }

    public static void main(String[] args) {

        Solution sol = new Solution();
        sol.lengthOfLIS(new int[]{10,9,2,5,3,7,101,18});
        sol.lengthOfLIS(new int[]{0,1,0,3,2,3});
    }

}