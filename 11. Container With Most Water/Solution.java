class Solution {
    public int maxArea(int[] height) {
        
        int leftPointer, rightPointer;
        int area = 0;

        leftPointer = 0; rightPointer = height.length - 1;

        /*
        We use two pointers. If a left pointer is smaller than the pointer which is in the
        right side of it, we will move it right. (We want to find the max area)
        In other case we move right pointer to the left.
        */

        while (leftPointer < rightPointer)
        {
            area = Math.max(area, (rightPointer - leftPointer) * Math.min(height[leftPointer], height[rightPointer]));
        
            if (height[leftPointer] < height[rightPointer])
                leftPointer++;
            else
                rightPointer--;

        }
        return area;

    }


    public static void main(String[] args) {
        
        Solution sol = new Solution();

        System.out.println(sol.maxArea(new int[]{1,8,6,2,5,4,8,3,7}));

    }

}