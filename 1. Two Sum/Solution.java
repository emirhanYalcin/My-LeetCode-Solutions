import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        //link = https://leetcode.com/problems/two-sum/submissions/927656263/

        /*
            We use a remainings Hash Map. This map is used for this purpose:
            For example if your first number is 2 and your target is 9, you need 
            eleman 7 to have the target. Then if you find a number 7 in the array, you can
            sum it with element at the index 0.

            {
                7 : 0 #at index 0 there is number 2 which makes sum 9, the target
            }

            If you use a hashmap, we can solve this problem in linear time.
        */
        HashMap<Integer, Integer> remainings = new HashMap<>();

        int i;
        for (i = 0; i < nums.length; i++)
        {
            if (remainings.containsKey(nums[i]))
                return new int[]{remainings.get(nums[i]), i};
            remainings.put(target - nums[i], i);
            
        }
        return null;

    }
}