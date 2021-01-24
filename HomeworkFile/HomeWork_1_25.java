import java.util.ArrayList;


public class HomeWork {
    //question 35
    public int searchInsert(int[] nums, int target) {
        int maxPos = nums.length - 1;
        int minPos = 0;
        while (maxPos-minPos>1){
            int midPos = (maxPos - minPos) / 2 + minPos;
            if (nums[midPos]>target){
                maxPos = midPos;
            }else if (nums[midPos]<target){
                minPos = midPos;
            }else{
                return midPos;
            }
        }
        if(nums[maxPos]<target)
            return maxPos +1;
        else if(nums[maxPos]>=target && nums[minPos]<target)
            return maxPos;
        else
            return minPos;

    }

    //question64
    public int minPathSum(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length==0){
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int[][] path =  new int[m][n];
        path[0][0] = grid[0][0];
        for (int i = 1; i< n;i++){
            path[0][i] = path[0][i - 1] + grid[0][i];
        }
        for (int j = 1; j< m;j++){

            path[j][0] = path[j - 1][0] + grid[j][0];
        }
        for (int x = 1; x< m;x++){
            for (int y = 1; y< n;y++){
                path[x][y] = path[x][y - 1]<path[x-1][y]?path[x][y - 1]+ grid[x][y]:path[x-1][y]+ grid[x][y];
            }
        }

        if(m==1 && n!=1)
            return path[0][n - 2] + grid[m -1][n-1];
        else if(n==1 && m!=1)
            return path[m - 2][0] + grid[m -1][n-1];
        else if(n==1 && m==1)
            return grid[m -1][n-1];
        else
            return path[m - 1][n - 2]<path[m-2][n - 1]?path[m - 1][n - 2]+ grid[m -1][n-1]:path[m-2][n - 1]+ grid[m -1][n-1];

    }
    //question73
    public void setZeroes(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length==0){
            return;
        }
        int m = matrix.length; //行数
        int n = matrix[0].length; //列数

        ArrayList<Integer> myIndex1 = new ArrayList<Integer>();
        ArrayList<Integer> myIndex2 = new ArrayList<Integer>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==0){
                    if(myIndex1.indexOf(i)== -1)
                        myIndex1.add(i);
                    if(myIndex2.indexOf(j)== -1)
                        myIndex2.add(j);
                }
            }
        }

        for(int i=0;i<myIndex1.size();i++){
            for(int j=0;j<n;j++){
                matrix[myIndex1.get(i)][j]=0;
            }
        }
        for(int i=0;i<myIndex2.size();i++){
            for(int j=0;j<m;j++){
                matrix[j][myIndex2.get(i)]=0;
            }
        }

    }
}
