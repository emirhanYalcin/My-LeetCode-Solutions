import java.util.*;
import java.lang.*;

class Solution {

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        
        //We will keep our jobs in a Nx3 multidimentional array, since our jobs has 3 property.
        int N = startTime.length; // Number of jobs
        int[][] jobs = new int[N][3]; //N rows for N jobs

        //Initializing our jobs.
        for (int i = 0; i < N; i++)
            jobs[i] = new int[]{startTime[i], endTime[i], profit[i]};

        //We should sort the jobs with respect to end time in ascending order:
        Arrays.sort(jobs, (a, b) -> (a[1] - b[1]));

        //This is a dynamic programming problem and 
        //We will use a TreeMap for memoization. Advantage of TreeMap keeps keys in sorted
        //And we can access maximum key.
        
        //Our key will be end time of our current last job that we choose
        //And value will be total profit that we collected with current choices.
        TreeMap<Integer, Integer> memoization = new TreeMap<>();

        //Initial key and value:
        memoization.put(0, 0);
        
        int profitValue;
        for (int[] job : jobs){
            profitValue = job[2] + memoization.floorEntry(job[0]).getValue(); //New possible max profit

            //In our TreeMap, last entry keeps maximum key (key is end-time).
            //If the calculated profit is bigger than the last entry, we will put new end-time and profit.
            if (profitValue > memoization.lastEntry().getValue())
                memoization.put(job[1], profitValue);
        }

        //Last entry will keep our maximum profit:
        return memoization.lastEntry().getValue();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.jobScheduling(new int[]{1,2,3,4,6}, new int[]{3, 5, 10, 6, 9}, new int[]{20, 20, 100, 70, 60});
    }
}