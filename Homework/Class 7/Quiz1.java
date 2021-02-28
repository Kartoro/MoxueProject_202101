// Leetcode.844 比较含退格的字符串

class Solution {
    public boolean backspaceCompare(String S, String T) {
        
        StringBuffer stringBufferS = new StringBuffer();
        StringBuffer stringBufferT = new StringBuffer();


        for (int i = 0; i < S.length(); i++){
            if (S.charAt(i) == '#' && stringBufferS.length() == 0){
                continue;
            }
            if (S.charAt(i) == '#' && stringBufferS.length() != 0){
                stringBufferS.append("#");
                stringBufferS.deleteCharAt(stringBufferS.indexOf("#") - 1);
                stringBufferS.deleteCharAt(stringBufferS.indexOf("#"));
            } else {
                stringBufferS.append(S.charAt(i));
            }
        }

        for (int j = 0; j < T.length(); j++){
            if (T.charAt(j) == '#' && stringBufferT.length() == 0){
                continue;
            }
            if (T.charAt(j) == '#' && stringBufferT.length() != 0){
                stringBufferT.append("#");
                stringBufferT.deleteCharAt(stringBufferT.indexOf("#") - 1);
                stringBufferT.deleteCharAt(stringBufferT.indexOf("#"));
            } else {
                stringBufferT.append(T.charAt(j));
            }
        }

        return stringBufferS.toString().equals(stringBufferT.toString());

    }
}