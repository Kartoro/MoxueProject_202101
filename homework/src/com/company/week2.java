package com.company;

public class week2{

    public boolean isPalindrome(String s) {
        String s1 = s.toLowerCase();
        StringBuffer s2 = new StringBuffer();
        char c2;
        for(int n = 0; n<s1.length();n++){
            c2 = s1.charAt(n);
            if(Character.isLetterOrDigit(c2)){
                s2.append(c2);
            }
        }
        for(int n = 0; n<s2.length()/2;n++)
        {
            if(s2.charAt(n)!= s2.charAt(s2.length()-1-n))
                return false;
        }
        return true;
    }

    public int firstUniqChar(String s) {
        if(s.length() == 1)
            return 0;
        for(int n = 0;n<s.length();n++)
        {
            char c = s.charAt(n);
            for(int l = 0;l<s.length();l++)
            {
                char c1 = s.charAt(l);
                if (l != n && c == c1)
                    break;
                if (l == s.length()-1)
                    return n;
            }
        }
        return -1;
    }
}
