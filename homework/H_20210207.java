import java.util.Arrays;

public class H_20210207 {
    public static void main(String[] args) {

    }

    //lc643
    public static double findMaxAverage(int[] nums, int k) {
        if (nums.length < k){
            return 0;
        }

        double sum = 0;

        for (int j = 0; j < k; j++){
            sum += nums[j];
        }

        double tempSum = sum;

        for (int i = k; i < nums.length; i++){

            tempSum = tempSum - nums[i-k] + nums[i];

            sum = Math.max(tempSum, sum);

        }

        return sum/k;

    }



}
