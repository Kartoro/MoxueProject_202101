import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class duijiaoxianbianli {
    public static void main(String[] args){

        int [ ][ ]  arr={{1,2,3},{4,5,6},{7,8,9},};
        System.out.println(findDiagonalOrder(arr));
    }

    public static int[] findDiagonalOrder(int[][] matrix) {
        int i =0;
        int j=0;
        int m = matrix.length;
        int n= matrix[0].length;
        int pos =0;
        int[] res = new int[m*n];
        while(i<=m &&j<=n){
           res[pos] = matrix[i][j];
           pos = pos+1;
            if(i==0 && j==0){
                j=j+1;

            }else if(i!=0 &&j==0){
                j = i+1;
                i=0;
            }else if(i==m && j!=0){
               i=j;
               j=n;
            }else{
                i=i+1;
                j=j+1;
            }

        }

        return res;

    }
}
