/*
643. 子数组最大平均数 I
-----------------
想法：
①	当长度k已知，求最大平均数相当于求定长子数组的最大和
②	For循环从第一个到第length-k+1个（索引号为0到length-k，包括最后一个，左右两边界都包括），然后再用一个for循环求包括它到后面k个元素的和。找出最大的和，求平均
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

/*
1590. 使数组和能被 P 整除
-----------------
想法：
①	计算数组和，如果结果小于p返回-1；如果结果≥p，用结果%p，如果余数为0返回0；如果余数≠0，应该去掉余数+np（n为非负整数）
②	问题就变成了数组中有没有子数组的和减去余数后%p结果为0，而且要是最短的
③	外部for循环，子数组长度L从1开始到数组总长（不包括数组总长），遍历
④	内部for循环，索引从0到[数组总长-子数组长度L]（可以等于），计算长为L的子数组的数字和。每一个和计算完，减去余数再%p，如果结果为0，返回L。
⑤	直到循环结束还没有，返回-1
*/
// 碰到很长很长的输入超时了
class Solution {
    public int minSubarray(int[] nums, int p) {
        int len = nums.length;
        long sum = 0L; // 因为1 <= nums[i] <= 10^9，加起来已经超出int范围，所以要用long
        
        for (int i=0; i<len;i++){
            sum = sum + nums[i];
        }

        if (sum < p){
            // System.out.print(sum); 之前int溢出的时候为了测试是哪里出错
            return -1;
        }

        else{
            long remain = sum % p; // 因为和sum计算，所以也要是long
            if (remain == 0){
                return 0;
            }

            else{
                for (int sublen=1; sublen<len; sublen++){
                    for (int i=0; i<=len-sublen; i++){
                        int subsum = 0;
                        for (int j=i; j<i+sublen; j++){
                            subsum = subsum + nums[j];
                        }

                        if ((subsum-remain)%p == 0){
                            return sublen;
                        }
                    }
                }
            }
        }
        return -1;
    }
}