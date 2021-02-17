import java.lang.reflect.Array;
import java.util.Arrays;

public class J_480 {
    public double[] medianSlidingWindow(int[] nums, int k) {
        double[] res = new double[nums.length-k+1];
        int pos =0;
        int left =0;
        int right = k-1;
        while(right<nums.length){
            int[] tem = new int[k];
            for(int i = 0; i <k; i ++){
                tem[i] =nums[i+left];
            }
            Arrays.sort(tem);
            if(k%2 !=0){

                res[pos] = tem[(k-1)/2];
            }else{
                res[pos] = (tem[k/2] + tem[k/2+1])/2;

            }
            pos++;
            right++;
            left++;
        }
        return res;
    }
    }
}
