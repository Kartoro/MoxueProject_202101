// Leetcode.1052 爱生气的书店老板

class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {

        int start = 0;
        int end = 0;

        int currentAngryCustomers = 0;
        int maxAngryCustomers = Integer.MIN_VALUE;

        // 找到在连续不生气区间中的最大满意人数
        while (end < customers.length){

            if (grumpy[end] == 1){
                currentAngryCustomers += customers[end];
            }

            maxAngryCustomers = Math.max(maxAngryCustomers, currentAngryCustomers);

            end++;

            // 滑动窗口拓展
            if (end - start >= X){
                if (grumpy[start] == 1) {
                    currentAngryCustomers -= customers[start];
                }
                start++;
            }

        }

        // 计算老板不生气时的顾客数量
        int noAngryCustomers = 0;
        for (int j = 0; j < customers.length; j++){
            if (grumpy[j] == 0){
                noAngryCustomers += customers[j];
            }
        }

        return maxAngryCustomers + noAngryCustomers;

    }

}