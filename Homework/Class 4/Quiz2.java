// Leetcode.424 替换后的最长重复字符
class Solution {
    public int characterReplacement(String s, int k) {

        if (s.equals(null) || s.length() == 0) {
            return 0;
        }

        int left = 0;
        int right = 0;

        char[] letterList = s.toCharArray();

        int[] count = new int[26];
        int maxCount = Integer.MIN_VALUE;
        int maxLength = Integer.MIN_VALUE;

        count[letterList[right] - 'A']++;
        right++;
        while (left < right && right < s.length()){
            count[letterList[right] - 'A']++;
            maxCount = Math.max(maxCount, count[letterList[right] - 'A']);
             if (s.length() > k + maxCount){
                maxLength = Math.max(maxLength, maxCount + k);
            } else {
                maxLength = Math.max(maxLength, right - left + 1);
            }
            right++;

            if (right - left > maxCount + k){
                count[letterList[left] - 'A']--;
                left++;
            }
        }

        return maxLength;
    }
}