// Leetcode.1021 删除最外层的括号

class Solution {
    public String removeOuterParentheses(String S) {

        Stack<Character> stack = new Stack<>();
        int start = 0;
        int end = 0;
        StringBuffer stringBuffer = new StringBuffer();

        for (char each : S.toCharArray()){
            end++;
            if (!stack.empty() && stack.peek() == '(' && each == ')'){
                stack.pop();
            } else {
                stack.push(each);
            }
            if (stack.empty()){
                String current = S.substring(start, end);
                stringBuffer.append(current.substring(1, current.length() - 1));
                start = end;
            }
        }

        return stringBuffer.toString();

    }
}