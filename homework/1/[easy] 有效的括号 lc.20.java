class Solution {
    public boolean isValid(String s) {
        if(s.isEmpty()){
            return true;
        }//空串
        Stack<Character> stack=new Stack<Character>();//用栈保存
        for(char c:s.toCharArray()){//增强for循环遍历数组
            if(c=='('){
                stack.push(')');
            }
            else if(c=='['){
                stack.push(']');
            }
            else if(c=='{'){
                stack.push('}');
            }
            else if(stack.empty()||c!=stack.pop()){
                return false;
            }
        }
        if(stack.empty()){
            return true;
        }
        else{
            return false;
        }


    }
}