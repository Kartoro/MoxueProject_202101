// Leetcode.621 任务调度器
class Solution {
    public int leastInterval(char[] tasks, int n) {

     int[] charCount = new int[26];
        for (char each : tasks){
            charCount[each - 'A']++;
        }

        int maxCount = Integer.MIN_VALUE;
        int sum = 0;
        for (int each : charCount){
            maxCount = Math.max(maxCount, each);
            sum += each;
        }

        int sameMaxNumber = 0;
        for (int each : charCount){
            if (each == maxCount){
                sameMaxNumber++;
            }
        }

        return Math.max(((n + 1) * (maxCount - 1) + sameMaxNumber), sum);
    }
        
}