class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        int[] chars = new int[26];
        int[] window = new int[26];
        for (char c : s1.toCharArray()) {
            chars[c - 'a']++;
        }
        int len = s1.length();
        for (int i = 0; i < len; i++) {
            window[s2.charAt(i) - 'a']++;
        }
        if (isSub(chars, window)) return true;
        for (int i = len; i < s2.length(); i++) {
            window[s2.charAt(i) - 'a']++;
            window[s2.charAt(i-len) - 'a']--;
            if (isSub(chars, window)) return true;
        }
        return false;
    }

    private boolean isSub(int[] c1, int[] c2) {
        for (int i = 0; i < c1.length; i++) {
            if (c1[i]!=c2[i]) return false;
        }
        return true;
    }
}
