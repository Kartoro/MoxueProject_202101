import java.util.Stack;

public class J_1021 {
    public String removeOuterParentheses(String S) {
        Stack st = new Stack();
        char[] sc = S.toCharArray();
        int begin = 1;
        String ans = "";

        for(int i =0; i < S.length(); i ++){

            if(sc[i] == '('){
                st.push(sc[i]);
            }else{
                st.pop();
                if(st.isEmpty()){
                    ans = ans + S.substring(begin, i);
                    begin = i +2;
                }

            }
        }
        return ans;
    }
}
