import java.util.Arrays;

public class J_643 {
    public static void main(String[] args){

        int [] nums = {1,12,-5,-6,50,3};
        System.out.println(findMaxAverage(nums,4));
    }
    public static double findMaxAverage(int[] nums, int k) {
        double sumMax = 0.0;
        double tem = 0.0;
        for(int i = 0; i < k;i++){
            tem = tem + nums[i];
        }
        sumMax = tem;
        for(int i = k; i < nums.length; i++){

            tem = tem - nums[i-k] + nums[i];
            if(tem > sumMax){
                sumMax = tem;
            }
        }
        return sumMax/k;


    }

}
