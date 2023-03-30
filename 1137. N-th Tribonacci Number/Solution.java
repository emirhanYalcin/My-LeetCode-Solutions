class Solution {

    // link = https://leetcode.com/problems/n-th-tribonacci-number/description/?envType=study-plan&id=dynamic-programming-i

    public int tribonacci(int n) {
        
        
        //Using three variables:
        int t1, t2, t3, temp;
        t1 = 0;
        t2 = 1; t3 = 1;

        for (int i = 0; i < n; i++)
        {
            temp = t3;
            t3 = t3 + t2 + t1;
            t1 = t2;
            t2 = temp;
            
        }
        return t1;


        //Using Dynamic Programming:
        /* 
        int dpArray[] = new int[n + 3];
        dpArray[1] = 1; dpArray[2] = 1;

        for (int i = 3; i <= n; i++)
        {
            dpArray[i] = dpArray[i-1] + dpArray[i-2] + dpArray[i-3];
        }
        return dpArray[n];
        */
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        for (int i = 0; i < 10; i++)
            System.out.println("n: " + i + " " + sol.tribonacci(i));
    }
}