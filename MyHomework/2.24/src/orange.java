import java.util.LinkedList;
import java.util.Queue;

public class orange {
    public static void main(String[] arg){
        int[][] tem = new int[1][2];
        System.out.println(orangesRotting(tem));
    }

    public static int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int minute =0;
        int fresh =0;
        for(int i=0; i<m;i++){
            for(int j=0; j <n;j++){
                if(grid[i][j] == 2){
                    queue.add(new int[]{i,j});
                }else if(grid[i][j]==1){
                    fresh++;
                }
            }
        }
        while(fresh>0 && !queue.isEmpty()){
            minute++;
            int s= queue.size();
            for(int id = 0; id<s;id++){
                int[] orange = queue.poll();
                int r = orange[0];
                int c = orange[1];
                if(r-1>0 && grid[r-1][c] == 1){
                    fresh--;
                    grid[r-1][c] =2;
                    queue.add(new int[]{r-1,c});
                }
                if(r+1<m && grid[r+1][c] == 1){
                    fresh--;
                    grid[r+1][c] =2;
                    queue.add(new int[]{r+1,c});
                }
                if(c-1>0 && grid[r][c-1] == 1){
                    fresh--;
                    grid[r][c-1] =2;
                    queue.add(new int[]{r,c-1});
                }
                if(c+1<n && grid[r][c+1] == 1){
                    fresh--;
                    grid[r][c+1] =2;
                    queue.add(new int[]{r,c+1});
                }
            }

        }
        if(fresh >0){
            return -1;
        }else{
            return minute;
        }
    }
}
