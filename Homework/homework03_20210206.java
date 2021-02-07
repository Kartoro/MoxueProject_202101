/*
643. 子数组最大平均数 I
-----------------
想法：
当长度k已知，求最大平均数相当于求定长子数组的最大和
For循环从第一个到第length-k+1个（索引号为0到length-k，包括最后一个，左右两边界都包括），然后再用一个for循环求包括它到后面k个元素的和。找出最大的和，求平均
*/
class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double result = 0.0;
        int sum = -2147483648; // int类型中最小的数，最大的是2147483647
        int len = nums.length;
        for (int i=0; i<=len-k; i++){ 
// 是包括len-k的，不然数组只有一个数的时候出错。每次都要考虑特殊边界。比如数组只有一个元素的情况，循环到第一个数/最后一个数的情况，数组为空的情况
            int sum1 = 0;
            for (int j=0; j<k; j++){
                sum1 = sum1 + nums[i+j];
            }
            if (sum1 > sum){
                sum = sum1;
            }
        }
        result = (double)sum/k;
        return result;
    }
}