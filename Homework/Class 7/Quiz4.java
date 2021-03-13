// Leetcode.394 字符串解码

class Solution {

    public String decodeString(String s) {

        if (s == null || s.length() == 0){
            return "";
        } else if (s.length() == 1){
            return s;
        } else {
            return process(s);
        }
    }


    public String process (String s) {

        StringBuffer result = new StringBuffer();
        int times = 0;
        Stack<Integer> intStack = new Stack<Integer>();
        Stack<String> stringStack = new Stack<String>();

        StringBuffer intBuffer = new StringBuffer();

        for (int i = 0; i < s.length(); i++){
        	// when digit
            if (Character.isDigit(s.charAt(i))) {

                times = times * 10 + Integer.valueOf(String.valueOf(s.charAt(i)));

            } 
            // when letter
            else if (Character.isLetter(s.charAt(i))){

                result.append(s.charAt(i));

            } 
            // when '['
            else if (s.charAt(i) == '['){

                intStack.push(Integer.valueOf(times));
                stringStack.push(result.toString());
                times = 0;
                result.setLength(0);

            } 
            // when ']'
            else {

                StringBuffer currentBuffer = new StringBuffer();
                int currentTimes = intStack.pop();
                for (int j = 0; j < currentTimes; j++){
                    currentBuffer.append(result);
                }
                
                result = new StringBuffer(stringStack.pop() + currentBuffer);

            }
        }

        return result.toString();
    }

}