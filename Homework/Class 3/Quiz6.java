// Leetcode.1737 满足三条件之一需改变的最少字符数
class Solution {
    public int minCharacters(String a, String b) {

        int[] countA = new int[26];
        int[] countB = new int[26];

        int aTotal = a.length();
        int bTotal = b.length();
        int aSum = 0;
        int bSum = 0;

        int result = Integer.MAX_VALUE;

        for (char each : a.toCharArray()){
            countA[each - 'a']++;
        }

        for (char each : b.toCharArray()){
            countB[each - 'a']++;
        }

        for (int i = 0; i < 25; i++){

            aSum += countA[i];
            bSum += countB[i];

            // 情况一: Math.min(result, aTotal - countA[i] + bTotal - countB[i])两个字符串全改成当前字符
            // 情况二: Math.min(aTotal - aSum + bSum, aSum + bTotal - bSum)设定不同边界, 边界两侧分别移动
            result = Math.min(Math.min(result, aTotal - countA[i] + bTotal - countB[i]), Math.min(aTotal - aSum + bSum, aSum + bTotal - bSum));
        }

        // 考虑Z的边界情况
        result = Math.min(result, aTotal - countA[25] + bTotal - countB[25]);

        return result;

    }
}