// Leetcode.643 子数组最大平均数

//前缀和
class Solution {
    public double findMaxAverage(int[] nums, int k){
        if (nums == null || nums.length == 0 || k > nums.length) {
            return 0;
        }

        if (nums.length == 1){
            return nums[0];
        }

        int[] prefixSumList = new int[nums.length + 1];
        prefixSumList[0] = 0;
        for (int i = 0; i < nums.length; i++){
            prefixSumList[i + 1] = prefixSumList[i] + nums[i];
        }

        int max = Integer.MIN_VALUE;
        for (int i = k - 1; i < nums.length; i++){
            max = Math.max(max, prefixSumList[i + 1] - prefixSumList[i + 1 - k]);
        }
        return Double.valueOf(max) / Double.valueOf(k);
    }
}

//滑动窗口
class Solution {
    public double findMaxAverage(int[] nums, int k) {

        int max = Integer.MIN_VALUE;
        int currentSum = 0;

        int left = 0;
        int right = 0;
        while(right < nums.length){
            if (right - left + 1 == k){
                currentSum += nums[right];
                max = Math.max(max, currentSum);
                currentSum -= nums[left];
                left++;
                right++;
            } else {
                currentSum += nums[right];
                right++;
            }
        }

        return Double.valueOf(max) / Double.valueOf(k);
    }
}