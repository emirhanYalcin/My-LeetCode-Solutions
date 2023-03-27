
import java.util.*;

class Solution {

    public int coinChange(int[] coins, int amount) {

        //We will use dynamic programming in the solution of this problem. 
        //Creating an array for memoization:

        int[] dpArray = new int[amount+1];
        
        //We are filling the array with some value bigger than amount, we can not have 
        //number of ways bigger than amount. 
        Arrays.fill(dpArray, amount + 1);
        dpArray[0] = 0; //Minimum problem is 0. We can have 0 money with 0 coins.

        //For each amount from 1 until desired amount, we calculate the number of ways and save
        for (int i = 1; i <= amount; i++){

            //For every coin, we test the value. Chosing one coin and find how money ways exist for amount - coin
            //Answer is recorded in dpArray.
            for (int j = 0; j < coins.length; j++){
                if (coins[j] <= i)
                    dpArray[i] = Math.min(dpArray[i], 1 + dpArray[i - coins[j]]);
                    //Getting min function for finding optimal answer with optimal  coin.

            }


        }
        //If last value of the array is not changed, desired amount cannot be written by
        //sum of coins, then we return -1.
        return dpArray[amount] > amount ? -1 : dpArray[amount];
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.coinChange(new int[]{186,419,83,408}, 6249);
    }
}