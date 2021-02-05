// Leetcode.125 验证回文串
class Solution {
    public boolean isPalindrome(String s) {
        String string = s.toLowerCase().replaceAll("\\pP","").replaceAll(" ","").replaceAll("`","");
        int left = 0;
        int right = string.length() - 1;
        while (left < right) {
            if (string.charAt(left) != string.charAt(right)){
                return false;
            }
            left += 1;
            right -= 1;
        }
        return true;
    }
}