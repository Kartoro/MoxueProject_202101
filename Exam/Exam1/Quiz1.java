// Leetcode.1668 最大重复子字符串
class Solution {
    public int maxRepeating(String sequence, String word) {
        
        if (sequence == null || sequence.length() == 0){
            return 0;
        }

        if (word == null || word.length() == 0){
            return 0;
        }

        int slow = 0;
        int fast = 0;
        int wordIndex  = 0;
        int count = 0;
        int maxCount = 0;
        while (fast < sequence.length()){
            if (sequence.charAt(fast) == word.charAt(wordIndex)){
                while (fast < sequence.length() && sequence.charAt(fast) == word.charAt(wordIndex)){
                    fast++;
                    wordIndex++;
                    if (wordIndex == word.length()){
                        count += 1;
                        maxCount = Math.max(maxCount, count);
                        wordIndex = 0;
                    }
                }
                count = 0;
                wordIndex = 0;
                //使index逐位递进
                slow++;
                fast = slow;
            } else {
                fast++;
            }
        }
        return maxCount;
    }
}