public class Search {
    public static void main(String[] args) {

    }


    /**
     * 二维数组中的查找
     * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
     * 每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，
     * 判断数组中是否含有该整数。
     */

    // sol 1
    public boolean Find0(int target, int[][] array) {
        int l = array.length;
        int w = array[0].length;
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < w; j++) {
                if (array[i][j] == target) {
                    return true;
                }
            }
        }

        return false;


    }

    // sol 2, effective
    public boolean Find(int target, int[][] array) {
        int row = 0;
        int col = array[0].length - 1;

        while (row <= array.length - 1 && col >= 0) {
            if (target == array[row][col]) {
                return true;

            } else if (target > array[row][col]) {
                row++;
            } else {
                col--;
            }
        }

        return false;


    }
}
