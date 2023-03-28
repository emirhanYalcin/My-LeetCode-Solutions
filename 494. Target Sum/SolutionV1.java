import java.util.*;

class SolutionV1 {
    public int findTargetSumWays(int[] nums, int target) {

        /*
        We use binary binary tree structure. We have two trees, starting by 
        Positive and negative of first number. Each right child will be sum with
        positive of next number and left child will be sum with negative of it. 
        When we count target number in last line of this binary tree, we can achieve
        our result.
        */
        int[] tree1 = new int[(int) Math.pow(2, nums.length)];
        int[] tree2 = new int[(int) Math.pow(2, nums.length)];

        tree1[1] = -1 * nums[0]; tree2[1] = nums[0];

        for (int i = 0; i < nums.length - 1; i++){
            for (int j = (int) Math.pow(2, i); j < (int) Math.pow(2,i + 1); j++){

                tree1[2*j] = tree1[j] + (nums[i+1] * -1); //Left child
                tree1[2*j+1] = tree1[j] + (nums[i+1]); //right child

                tree2[2*j] = tree2[j] + (nums[i+1] * -1); //Left child
                tree2[2*j + 1] = tree2[j] + (nums[i+1] * 1); //Right child
            }            
        }
        int counter = 0;
        for (int i = ((int) Math.pow(2, nums.length))/2; i < (int) Math.pow(2, nums.length); i++)
        {
            if (tree1[i] == target) counter++;
            if (tree2[i] == target) counter++;
        }
        return counter;
    }


    public static void main(String[] args) {
        SolutionV1 sol = new SolutionV1();
        System.out.println(sol.findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
    }

}