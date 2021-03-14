// Leetcode.1052 爱生气的书店老板

class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {

        int start = 0;
        int maxCustomers = Integer.MIN_VALUE;
        
        ArrayList<Integer> customersList = new ArrayList<>();

        // 找到在连续不生气区间中的最大满意人数
        while (start + X <= customers.length){

            int currentCustomers = 0;

            for (int i = start; i < start + X; i++){
                if (grumpy[i] == 1){
                    currentCustomers += customers[i];
                }
            }

            customersList.add(currentCustomers);
            maxCustomers = Math.max(maxCustomers, currentCustomers);

            start += 1;

        }

        // 找到在连续不生气区间中最大满意人数的index
        int maxIndex = 0;
        for (int j = 0; j < customersList.size(); j++){
            if (customersList.get(j) == maxCustomers){
                maxIndex = j;
            }
        }

        // 计算最大满意人数
        int result = 0;
        for (int k = 0; k < customers.length; k++){
            if (grumpy[k] == 1 && (k < maxIndex || k >= maxIndex + X)){
                customers[k] = 0;
            }
            result += customers[k];

        }

        return result;

    }

}