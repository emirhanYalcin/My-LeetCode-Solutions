import java.util.Arrays;

class Solution {
    public int numTrees(int n) {

        /*
            Number of trees has this structure:
            
            f(0) = 1, f(1) = 1
            ------------------------------------------
            f(2):
                (1)                         (1)
               /   \           and         /   \
            f(1)   f(0)                 f(0)   f(1)

            1*1 + 1*1 = 2
            ------------------------------------------
            f(3):

                (1)               (1)               (1)
               /   \             /   \             /   \
            f(2)   f(0)       f(1)   f(1)        f(0)  f(2)
            
            2*1 + 1*1 + 2*1 = 5
            -------------------------------------------
            f(n) = (f(n-1) + f(0)) + (f(n-2) + f(1)) + ... + (f(0) + f(n-1))

        */

        int[] dp = new int[n+1];

        dp[0] = 1; dp[1] = 1;
        for (int i = 2; i <=n; i++)
        {
            for (int j = i-1; j >= 0; j--){
                dp[i] += dp[j] * dp[i-j-1];
            }
            
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        sol.numTrees(5);

    }
}