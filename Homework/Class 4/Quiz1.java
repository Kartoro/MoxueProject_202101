// Leetcode.643 子数组最大平均数
class Solution {
    public double findMaxAverage(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k > nums.length) {
            return 0;
        }

        if (nums.length == 1 && k == 1){
            return nums[0];
        }

        double result = Integer.MIN_VALUE;
        for (int i = 0; i <= nums.length - k; i++){
            int sum = 0;
            for (int j = i; j < i + k; j++){
                sum += nums[j];
            }
            result = Math.max(result, Double.valueOf(sum) / Double.valueOf(k));
        }
        return result;
    }
}