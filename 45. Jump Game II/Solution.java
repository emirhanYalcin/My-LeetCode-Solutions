import java.util.Arrays;

class Solution {
    public int jump(int[] nums) {
        
        //We save each time minimum jump number from index i to last index.
        int dpArray[] = new int[nums.length];
        int i, j, min;
        for (i = nums.length - 2; i > -1; i--)
        {
            min = dpArray[i+1];
            for (j = i + 1; j < nums.length && j <= i + nums[i]; j++)
            {   
                if (dpArray[j] < min)
                    min = dpArray[j];
            }
            //We will add one additional jump each time to the minimum. Value 
            //of last index is 0 since there is no need to jump from last index to
            //itself.
            dpArray[i] = min + 1;
        }
        return dpArray[0];

    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        sol.jump(new int[]{2, 3, 1, 1, 4});
    }
}