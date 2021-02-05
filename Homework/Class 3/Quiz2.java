//Leetcode.387 字符串中的第一个唯一字符
class Solution {
    public int firstUniqChar(String s) {
        int slow = 0;
        boolean result = false;
        if (s.length() == 1){
            return 0;
        }
        while (slow < s.length()){
            result = false;
            for (int fast = 0; fast < s.length(); fast++){
                if (s.charAt(fast) == s.charAt(slow) && fast != slow){
                    slow++;
                    result = true;
                    break;
                }
            }
            if (result == false){
                return slow;
            }
        }
        return -1;
    }
}