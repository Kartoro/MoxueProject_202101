import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class H_20210224 {
    public static void main(String[] args) {


    }

    //lc 844
    public boolean backspaceCompare(String S, String T) {
        Stack<Character> s1 = new Stack<>();
        Stack<Character> s2 = new Stack<>();

        char[] sChars = S.toCharArray();
        char[] tChars = T.toCharArray();

        for (int i = 0; i < sChars.length; i++) {
            if (sChars[i] == '#') {
                if (!s1.isEmpty()) {
                    s1.pop();
                }
            } else {
                s1.push(sChars[i]);
            }
        }

        for (int j = 0; j < tChars.length; j++) {
            if (tChars[j] == '#') {
                if (!s2.isEmpty()) {
                    s2.pop();
                }
            } else {
                s2.push(tChars[j]);
            }
        }

        if (s1.size() != s2.size()) {
            return false;
        }

        List<Character> s1List = new ArrayList<Character>(s1);
        List<Character> s2List = new ArrayList<Character>(s2);


        for (int k = 0; k < s1List.size(); k++) {
            if (s1List.get(k) != s2List.get(k)) {
                return false;
            }
        }

        return true;


    }

    //lc 1021
    public String removeOuterParentheses(String S) {
        StringBuilder sb = new StringBuilder();
        int level = 0;
        for (char c : S.toCharArray()) {
            if (c == ')') {
                --level;
            }
            if (level >= 1) {
                sb.append(c);
            }
            if (c == '(') {
                ++level;
            }
        }
        return sb.toString();

    }


}
