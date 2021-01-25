import java.util.HashMap;

public class JianZhiQuestion_1_25 {
    //剑指 Offer 10- I. 斐波那契数列
    public int fib(int n) {
        int fa = 0;
        int fb = 1;
        int result;

        for(int i=0;i<n;i++){
            result = (fa + fb) % 1000000007;
            fa = fb;
            fb = result;
        }
        return fa;

    }

    //剑指 Offer 03. 数组中重复的数字
    //hashmap解法
    public int findRepeatNumber(int[] nums) {
        HashMap<Integer,Integer> numberCounts = new HashMap<>();
        for(int i : nums){
            if(!numberCounts.containsKey(i))
                numberCounts.put(i,1);
            else
                return i;
        }

        return -1;
    }

    //使用换位
    public int findRepeatNumber2(int[] nums) {
        int[] array = new int[nums.length];
        for(int i : nums){
            if(array[i]==0)
                array[i]=i+1;
            else
                return i;
        }
        return -1;
    }
    //剑指 Offer 04. 二维数组中的查找
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0 || (target == 0 &&  matrix[0][0]!=0)) {
            return false;
        }
        if (target < matrix[0][0] || target > matrix[matrix.length - 1][matrix[0].length - 1]) return false;

        int m = 0, n = matrix[0].length -1;
        while (m<matrix.length && n >= 0){
            if (target<matrix[m][n]){
                n = n -1;
            }else if(target>matrix[m][n]){
                m = m +1;
            }else{
                return true;
            }

        }
        return false;
    }

    //剑指 Offer 10- II. 青蛙跳台阶问题
    //解法1
    public int numWays(int n) {
        if(n==0)
            return 1;
        else if(n==1)
            return 1;
        int[] arrayCount = new int[n+1];
        arrayCount[0]=1;
        arrayCount[1]=1;
        return process(arrayCount,n);

    }
    int process(int[] counter,int n){
        if(counter[n]==0){
            counter[n] = (process(counter,n-1)+process(counter,n-2))%1000000007;
        }else{
            return counter[n];
        }
        return counter[n];
    }
    //解法2
    public int numWays2(int n) {
        int a = 1;
        int b = 1;
        int sum;
        for(int i =0; i<n;i++){
            sum = (a + b)%1000000007;
            a = b;
            b = sum;
        }
        return a;

    }
}
