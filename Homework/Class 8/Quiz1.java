// Leetcode.567 字符串的排列

// 方法一: 对窗口内字母排序
class Solution {

    public boolean checkInclusion(String s1, String s2) {

        int start = 0;
        int end = s1.length();


        char[] ar1 = s1.toCharArray();
        Arrays.sort(ar1);
        String s1Sorted = String.valueOf(ar1);

        while (end <= s2.length()){
            String s2SubString = s2.substring(start, end);
            char[] ar2 = s2SubString.toCharArray();
            Arrays.sort(ar2);
            s2SubString = String.valueOf(ar2);
            if (s1Sorted.equals(s2SubString)){
                return true;
            }
            start += 1;
            end += 1;
        }

        return false;
    }

}

// 方法二: 统计窗口中每个字母个数
class Solution {

    public boolean checkInclusion(String s1, String s2) {

        int[] s1Freq = new int[26];
        int[] s2Freq = new int[26];

        for (char each : s1.toCharArray()){
            s1Freq[each - 'a']++;
        }
        
        int start = 0;
        int end = 0;

        while (end < s2.length()){

            s2Freq[s2.charAt(end) - 'a']++;
            end++;

            if (Arrays.equals(s1Freq, s2Freq)) {
                return true;
            }

            // 滑动窗口拓展
            if (end - start >= s1.length()){
                s2Freq[s2.charAt(start) - 'a']--;
                start += 1;
            }

        }

        return false;

    }

}