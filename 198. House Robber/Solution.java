import java.util.Arrays;

class Solution {

    //link = https://leetcode.com/problems/house-robber/submissions/924647866/

    public int rob(int[] nums) {

        int N = nums.length;

        /*
            We will use dynamic programming. We will solve each subproblem such that
            'What is the max profit in last x houses'?, starting from last 0 houses and last 1 house.

            Our main loop calculates the max profit at house index i to the end of the street.
        */

        int memoization[] = new int[N+1];
        memoization[N-1] = nums[N-1];

        /*
            Let max(i) function gives the maximum profit from house at index i to the end.

            We have two options each time. When we rob a house at index i, we have the profit
            of monet_at_i + max(i+2), since we can not row the house at index i+1 since they are
            adjacent.  Or we can skip house at index i and our profit will be max(i+1) direkcly.
            We will get maximum of these two cases. Zero index of the memoization array will be our answer.
        */

        for (int i = N - 2; i >= 0; i--)
        {
            memoization[i] = Math.max(nums[i] + memoization[i+2], memoization[i+1]);
        }
        return memoization[0];

    }

    public static void main(String[] args) {

        Solution sol = new Solution();
        sol.rob(new int[]{1, 2, 3, 1});
    }

}