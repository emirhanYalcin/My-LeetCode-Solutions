import java.util.Arrays;

class Solution {

    //link = https://leetcode.com/problems/min-cost-climbing-stairs/description/

    public int minCostClimbingStairs(int[] cost) {
        
        //We use dynamic programming and iterate from last day to first day
        /*

        We have two change, buy 1 day or two day ticket and compute the min.
        At the end, we will get the minimum of first two days, regarding which
        day we started travelling
        
        */

        int dpArray[] = new int[cost.length + 2];

        for (int i = cost.length - 1; i > -1; i--)
        {
            dpArray[i] = Math.min(cost[i] + dpArray[i+1], cost[i] + dpArray[i+2]);
        }

        System.out.println(Arrays.toString(dpArray));
        return Math.min(dpArray[0], dpArray[1]);
    }


    public static void main(String[] args) {

        Solution sol = new Solution();
        System.out.println(sol.minCostClimbingStairs(new int[]{10, 15, 20}));
    }
}