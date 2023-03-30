import java.util.Arrays;

class Solution {
    public int maxProfit(int[] prices) {

        /*
        Simple Brute Force solution but it exceeds time limit:
        int max = 0;        
        int i, j;
        for (i = 0; i < prices.length; i++)
            for (j = i + 1; j < prices.length; j++)
                max = (prices[j] - prices[i] > max) ? (prices[j] - prices[i]) : max; 
        
        System.out.println(max);
        return max;
        */

        //We will use dynamic programming. Starting from the index 1, we check each time 
        //What is the maximum possible profit from this subproblem
        int dpArray[] = new int[prices.length];

        int min = prices[0];

        for (int i = 1; i < prices.length; i++)
        {
            dpArray[i] = Math.max(prices[i] - min, dpArray[i-1]);
            if (prices[i] < min)
                min = prices[i];
                //We update minimum index after calculating profit. 
        }
        return dpArray[prices.length - 1];
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.maxProfit(new int[]{7, 1, 5, 3, 6, 4});
    }
}