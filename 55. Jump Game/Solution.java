class Solution {

    //link = "https://leetcode.com/problems/jump-game/description/"

    public boolean canJump(int[] nums) {
        
        //Greedy solution:

        //goal index keeps the index that we want to reach:
        
        int goalIndex = nums.length - 1;

        for (int i = nums.length - 1; i >= 0; i--)
        {
            if (i + nums[i] >= goalIndex)
            {
                goalIndex = i; //If can reach to our goal index from index i via jumping,
                //Then we can continue solving our problem for index i.
            } 
        }
        return goalIndex == 0;

    }


    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.canJump(new int[]{2, 0, 0}));
    }

}