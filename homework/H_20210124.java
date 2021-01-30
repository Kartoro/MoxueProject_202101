import java.util.ArrayList;

public class H_20210124 {

    public static void main(String[] args) {

        System.out.println(searchInsertLocation(new int[]{1, 3, 5, 6}, 2));


    }

    // leetcode Q.35
    public static int searchInsertLocation(int[] nums, int target) {

        if (nums.length == 0) {
            return 0;
        }

        int small = 0;
        int high = nums.length - 1;

        while (small <= high) {
            int mid = (small + high) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                small = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return small;

    }

    // leetcode Q.64
    public int minPathSum(int[][] grid) {

        if (grid == null || grid.length == 0) {
            return 0;
        }

        int[][] dynamicMatrix = new int[grid.length][grid[0].length];

        for (int i = grid.length - 1; i > -1; i--) {
            for (int j = grid[0].length - 1; j > -1; j--) {
                if (i == grid.length - 1 && j != grid[0].length - 1) {
                    dynamicMatrix[i][j] = grid[i][j] + dynamicMatrix[i][j + 1];
                } else if (i != grid.length - 1 && j == grid[0].length - 1) {
                    dynamicMatrix[i][j] = grid[i][j] + dynamicMatrix[i + 1][j];
                } else if (i != grid.length - 1 && j != grid[0].length - 1) {
                    dynamicMatrix[i][j] = grid[i][j] + Math.min(dynamicMatrix[i][j + 1], dynamicMatrix[i + 1][j]);
                } else
                    dynamicMatrix[i][j] = grid[i][j];
            }
        }

        return dynamicMatrix[0][0];
    }


    // leetcode Q.73
    public void zeroMatrix(int[][] matrix) {


        ArrayList rowList = new ArrayList();
        ArrayList columnList = new ArrayList();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    rowList.add(i);
                    columnList.add(j);
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (rowList.contains(i) || columnList.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }

    }
}
