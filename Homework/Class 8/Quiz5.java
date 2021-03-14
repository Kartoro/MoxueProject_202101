// Leetcode.6 Z字形变换

class Solution {

    StringBuffer stringBuffer = new StringBuffer();

    public String convert(String s, int numRows) {

        if (s.length() == 1 || numRows == 1){
            return s;
        }

        process (s, numRows, 0);

        return stringBuffer.toString();

    }

    public void process (String s, int numRows, int remainder){

        for (int i = 0; i < s.length(); i++){
            if (i % (numRows + numRows - 2) == remainder || i % (numRows + numRows - 2) == numRows + numRows - 2 - remainder){
                stringBuffer.append(s.charAt(i));
            }
        }

        if (remainder == (numRows + numRows - 2) / 2) {
            return;
        }

        process(s, numRows, remainder + 1);

    }

}