import java.util.Stack;

public class quizz02 {
    //1
    public int maxString(String sequence,String word){
        int result = 0;
        if(word.length()>sequence.length())
            return 0;
        int count = 0;
        int index = 0;
        int wordLength = word.length();
        for(int i = 0; i<sequence.length();i++){
            if(sequence.charAt(i)==word.charAt(index)&&index!=wordLength-1){
                index = index+1;
            }else if(sequence.charAt(i)!=word.charAt(index)){
                index = 0;
                result = Math.max(count,result);
                count = 0;
            }else if(sequence.charAt(i)==word.charAt(index)&&index==wordLength-1){
                index = 0;
                count = count+1;
            }
        }
        return result;
    }

    //2
    public int calculator(String s) {
        Stack<Integer> numStack = new Stack<>();
        char sign = '+';
        int num = 0,result = 0;
        for(int i = 0; i < s.length(); i++){
            char cur = s.charAt(i);
            if(Character.isDigit(cur)){
                if(num!=0){
                    num = num * 10+ Integer.parseInt(String.valueOf(cur));
                }else{
                    num = num + Integer.parseInt(String.valueOf(cur));

                }
            }
            if(!Character.isDigit(cur)|| i == s.length()-1){
                switch(sign){
                    case '+': numStack.push(num);break;
                    case '-': numStack.push(-num);break;
                    case '*': numStack.push(numStack.pop()*num);break;
                    case '/': numStack.push(numStack.pop()/num);break;
                }
                sign = cur;
                num = 0;
            }
        }
        while(!numStack.isEmpty()){
            result += numStack.pop();
        }
        return result;
    }

    //3
    public int task(String[] task) {
        return 0;
    }
}
