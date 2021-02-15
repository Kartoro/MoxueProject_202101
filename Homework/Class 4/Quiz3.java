// Leetcode.1590 使数组和能被P整除
class Solution {
    public int minSubarray(int[] nums, int p) {
        
        long sum = 0;
        int n = nums.length;

        for (int each : nums) {
            sum += each;
        }

        long remainder = sum % p;
        
        if (remainder == 0){
            return 0;
        }

        int[] prefixSum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
        }

        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < prefixSum.length; i++){
            for (int j = i + 1; j < prefixSum.length; j++){
                if ((prefixSum[j] - prefixSum[i]) % p == remainder){
                    answer = Math.min(answer, j - i);
                }
            }
        }
        if (answer == Integer.MAX_VALUE || answer == n){
            return -1;
        }
        return answer;
    }
}