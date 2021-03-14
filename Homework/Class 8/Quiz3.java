// Leetcode.766 托普利茨矩阵

class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {

        for (int row = 0; row < matrix.length; row++){
            int currentRow = row + 1;
            int col = 1;
            while (currentRow < matrix.length && col < matrix[0].length){
                if (matrix[row][0] != matrix[currentRow][col]){
                    return false;
                }
                currentRow += 1;
                col += 1;
            }
        }

        for (int col = 0; col < matrix[0].length; col++){
            int row = 1;
            int currentCol = col + 1;

            while (row < matrix.length && currentCol < matrix[0].length){
                if (matrix[0][col] != matrix[row][currentCol]){
                    return false;
                }
                row += 1;
                currentCol += 1;
            }
        }

        return true;

    }
}