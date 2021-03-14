// Leetcode.567 字符串的排列

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