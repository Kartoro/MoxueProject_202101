// 844
class Solution {
    public boolean backspaceCompare(String S, String T) {
        Stack<Character> stack1=new Stack<>();
        Stack<Character> stack2=new Stack<>();
        for(char cc:S.toCharArray()){
            if(cc=='#'){
                if(!stack1.isEmpty()){
                    stack1.pop();
                }
            }else {
                stack1.push(cc);
            }
        }
        for(char cc:T.toCharArray()){
            if(cc=='#'){
                if(!stack2.isEmpty()){
                    stack2.pop();
                }
            }else {
                stack2.push(cc);
            }
        }
        if(stack1.size()!=stack2.size()){
            return false;
        }
        while (!stack1.isEmpty()){
            if(stack1.pop()!=stack2.pop()){
                return false;
            }
        }
        return true;
    }
}

//1021
class Solution {
    public String removeOuterParentheses(String S) {
        StringBuilder result = new StringBuilder();
        int depth = 0;
        for (int i = 0; i < s.Length; i++)
        {
            if (s[i] == '(')
            {
                ++depth;
                if (depth > 1)
                    result.Append(s[i]);
            }
            else
            {
                if (depth > 1)
                    result.Append(s[i]);
                --depth;
            }
        }

        return result.ToString();
    }
}

//933
class RecentCounter {
    List<Integer> list;
    public RecentCounter() {
        list = new ArrayList<Integer>();
    }
    
    public int ping(int t) {
        list.add(t);
    Integer a = list.get(list.size()-1);
    for(int i = 0; i < list.size(); i++){
        if(list.get(i)<(a-3000)){
            list.remove(i);
            i--;
        }
    }
    return list.size();
    }
}

//394



//994

