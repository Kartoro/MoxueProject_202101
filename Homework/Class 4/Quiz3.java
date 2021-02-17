// Leetcode.1590 使数组和能被P整除
class Solution {
    public int minSubarray (int[] nums, int p) {

        long sum = 0;
        for (int each : nums) {
            sum += each;
        }
        long remainder = sum % p;

        if (remainder == 0) {
            return 0;
        }

        long prefixSum = 0;
        int result = Integer.MAX_VALUE;
        HashMap<Long, Integer> hashMap = new HashMap<>();
        hashMap.put((long) 0, -1);

        /*  1. 数列(0 ~ j) + 子数列(j ~ k) = 数列(0 ~ k)
            2. 数列(0 ~ j)余数 + 子数列(j ~ k)余数 (若余数和 > p, 需减掉p) = 数列(0 ~ k)余数
                => (数列(0 ~ j)余数 + 子数列(j ~ k)余数) % p = 数列(0 ~ k)余数
            3. 为保证新数列能被p整除, 必须满足: 子数列余数 = 原数列余数
            4. 即, 数列(0 ~ j)余数 + 原数列余数 (若余数和 > p, 需减掉p) = 数列(0 ~ k)余数
                => (数列(0 ~ j)余数 + 原数列余数) % p = 数列(0 ~ k)余数
            5. 即, 数列(0 ~ j)余数 = 数列(0 ~ k)余数 - 原数列余数 (若余数差 < 0, 需加上p)
                => 数列(0 ~ j)余数 = (数列(0 ~ k)余数 - 原数列余数 + p) % p
        */
        // 设数列(0 ~ j)余数为formerPrefixRemainder, 设数列(0 ~ k)余数为latterPrefixRemainder
        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            long latterPrefixRemainder = prefixSum % p;
            long formerPrefixRemainder = (latterPrefixRemainder - remainder + p) % p;
            if (hashMap.get(formerPrefixRemainder) != null) {
                result = Math.min(result, i - hashMap.get(formerPrefixRemainder));
            }
            hashMap.put(latterPrefixRemainder, i);
        }
        return result >= nums.length ? -1 : result;
    }
}