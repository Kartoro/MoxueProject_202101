class Solution {

    public int minPathSum(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] minSum = new int[rows][cols];
        minSum[0][0] = grid[0][0];
        for (int row = 1; row < grid.length; row++){
            minSum[row][0] = minSum[row - 1][0] + grid[row][0];
        }

        for (int col = 1; col < grid[0].length; col++){
            minSum[0][col] = minSum[0][col-1] + grid[0][col];
        }

        for (int row = 1; row < grid.length; row++) {
            for (int col = 1; col < grid[0].length; col++){
                minSum[row][col] = grid[row][col] + Math.min(minSum[row-1][col], minSum[row][col-1]);
            }
        }

        return minSum[rows - 1][cols - 1];

    }
}