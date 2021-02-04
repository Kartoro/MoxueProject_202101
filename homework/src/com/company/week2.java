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
}
