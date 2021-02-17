import java.util.Stack;

public class H_20210217 {
    public static void main(String[] args){




    }

    //q1.最大重复子字符串
    public static int maxRepeatableSub(String s, String w){
        int count = 0;
        StringBuilder sb = new StringBuilder(w);
        while(s.contains(sb)){
            count++;
            sb.append(w);
        }

        return count;
    }

    //q2.基本计算器
    public static int basicCalculator(String s){
        s = s.replaceAll(" ", "");

        char[] charArray = s.toCharArray();
        int result = 0;

        Stack<Integer> calStack = new Stack<>();

        for(int i = 0; i < charArray.length; i++){
            if (Character.isDigit(charArray[i])){
                calStack.push(Integer.parseInt(String.valueOf(charArray[i])));
            }else if (charArray[i] == '+'){
                continue;
            }else if (charArray[i] == '-'){
                int nextNumber = Integer.parseInt(String.valueOf(charArray[i+1]));
                nextNumber *= -1;
                calStack.push(nextNumber);
                i ++;

            }else if (charArray[i] == '*'){
                int preNumber = calStack.pop();
                int nextNumber = Integer.parseInt(String.valueOf(charArray[i+1]));
                nextNumber = preNumber * nextNumber;
                calStack.push(nextNumber);
                i++;

            }else if (charArray[i] == '/'){
                int preNumber = calStack.pop();
                int nextNumber = Integer.parseInt(String.valueOf(charArray[i+1]));
                nextNumber = preNumber / nextNumber;
                calStack.push(nextNumber);
                i++;
            }

        }

        for (Integer j : calStack){
            result += j;
        }

        return result;

    }


}
