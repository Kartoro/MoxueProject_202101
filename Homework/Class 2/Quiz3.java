// Leetcode.73 矩阵置零
class Solution {
    public void setZeroes(int[][] matrix) {
        ArrayList<Integer> rows = new ArrayList<>();
        ArrayList<Integer> cols = new ArrayList<>();

        for (int row = 0; row < matrix.length; row++){
            for (int col = 0; col < matrix[0].length; col++){
                if (matrix[row][col] == 0){
                    rows.add(row);
                    cols.add(col);
                } 
            }
        }

        for (int row : rows){
            for (int col = 0; col < matrix[0].length; col++){
                matrix[row][col] = 0;
            }
        }

        for (int col : cols){
            for (int row = 0; row < matrix.length; row++){
                matrix[row][col] = 0;
            }
        }
    }
}