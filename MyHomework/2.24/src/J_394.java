import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import static java.lang.Character.isDigit;

public class J_394 {
    public static void main(String[] arg){
        System.out.println(decodeString("3[a2[c]]"));
    }
    public static String decodeString(String s) {
        Stack<Integer> num = new Stack<Integer>();
       //Stack<String> st = new Stack<String>();
        List<String> st = new ArrayList<String>();
        Stack<Character> op = new Stack<Character>();
        StringBuffer sb  = new StringBuffer();
        for(int i =0; i < s.length(); i ++){
            if(s.charAt(i) == '['){
                op.push(s.charAt(i));
            } else if(s.charAt(i) == ']'){

                    StringBuffer tem = new StringBuffer();
                    StringBuffer tem1 = new StringBuffer();
                    while(op.peek() != '['){
                        tem.append(op.pop().toString());
                    }
                    tem.append(sb.toString());
                    //tem1.append(tem);
                    op.pop();
                    for(int j =0; j <num.peek() ; j ++){
                        tem1.append(tem);

                    }
                    sb = tem1;
                    num.pop();


            }else if(Character.isDigit(s.charAt(i))){
                num.push(s.charAt(i)-'0');
            }else{
                op.add(s.charAt(i));
            }


        }
        return sb.toString();
    }
}
