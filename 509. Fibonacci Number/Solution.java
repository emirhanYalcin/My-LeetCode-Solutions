import java.util.Arrays;

class Solution {
    public int fib(int n) {
        
        //Using two variables:
        /*
        int f = 0; int g = 1; 
        for (int i = 0; i < n; i++)
        {
            g = f + g;
            f = g - f;
        }
        return f;
        */

        //Using DP Array:
        int dp[] = new int[n+2];

        dp[1] = 1;
        for (int i = 2; i <= n ; i++)
        {
            dp[i] = dp[i-1] + dp[i-2];
        }
        System.out.println(Arrays.toString(dp));
        return dp[n];

    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.fib(3));
    }

}