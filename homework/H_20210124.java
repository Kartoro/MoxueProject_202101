public class H_20210124 {

    public static void main(String[] args) {

        System.out.println(searchInsertLocation(new int[]{1, 3, 5, 6}, 2));


    }

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

}
