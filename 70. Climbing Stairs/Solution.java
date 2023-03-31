class Solution {

    //link = https://leetcode.com/problems/climbing-stairs/

    public static int climbStairs(int n) {
        

        /* 
          Let's say we want to find different ways for 5 stair
          Let's say you had X different ways to climb 4 stair. If you climb 1 
          stair after each way of X, you will be climded stair 5.
          Same thing true for the ways of 3 if you climb 2 stair.

          So basically f(5) = f(4) + f(3)
        */

        int dpArray[] = new int[n+3];
        dpArray[0] = 0; dpArray[1] = 1; dpArray[2] = 2;

        for (int i = 3; i <= n; i++)
        {
            dpArray[i] = dpArray[i-1] + dpArray[i-2];
        }
 
        return dpArray[n];
    }

    public static void main(String[] args) {
        Solution.climbStairs(3);
    }

}