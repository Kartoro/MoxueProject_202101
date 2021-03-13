// Leetcode.844 比较含退格的字符串

class Solution {
    
    public boolean backspaceCompare(String S, String T) {
        
        return process(S).equals(process(T));

    }

     public String process (String string){

         StringBuffer stringBuffer = new StringBuffer();

         for (int i = 0; i < string.length(); i++){
             if (string.charAt(i) != '#'){
                 stringBuffer.append(string.charAt(i));
             } else {
                 if (stringBuffer.length() > 0){
                     stringBuffer.deleteCharAt(stringBuffer.length() - 1);
                 }
             }
         }

         return stringBuffer.toString();

     }

}