class Solution {

    //leetcode problem 200 
    //link = https://leetcode.com/problems/number-of-islands/

    public int numIslands(char[][] grid) {
        int rowNumber = grid.length;
        int columnNumber = grid[0].length;
        int counter = 0;
        for (int r = 0; r < rowNumber; r++)
            for (int c = 0; c < columnNumber; c++)
                if (grid[r][c] == '1'){
                    counter++;
                    depthFirstSearch(r, c, grid);
                }
        return counter;
        
    }


    public void depthFirstSearch(int row, int column, char[][] grid){
        if (row >= grid.length || row < 0 || column >= grid[0].length || column < 0 || grid[row][column] == '0')
            return;
        
        grid[row][column] = '0'; 
        depthFirstSearch(row-1, column, grid);
        depthFirstSearch(row+1, column, grid);
        depthFirstSearch(row, column-1, grid);
        depthFirstSearch(row, column+1, grid);
    }

}