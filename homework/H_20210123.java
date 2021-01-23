import java.util.Arrays;
import java.util.Stack;

public class H_20210123 {

    public static void main(String[] args) {
        q1();
        q2(new int[]{2, 2, 1, 3});
        System.out.println(q3("[([)]"));
    }

    public static void q1() {

        for (int i = 100; i < 1000; i++) {


            int a = i / 100 % 10;
            int b = i / 10 % 10;
            int c = i % 10;

            if (a * a * a + b * b * b + c * c * c == i) {
                System.out.println(i);
            }
        }
    }

    public static void q2(int[] inputArray) {
        Arrays.sort(inputArray);
        if (inputArray.length%2 != 0){
            System.out.println(inputArray[inputArray.length/2]);
        }else {
            System.out.println(inputArray[inputArray.length/2 -1]);
        }


    }


    public static boolean q3(String s) {
        Stack<Character> braceStack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char indexCharacter = s.charAt(i);
            if (indexCharacter == '[' || indexCharacter == '{' || indexCharacter == '(') {
                braceStack.push(indexCharacter);
            } else {
                if (braceStack.isEmpty()) {
                    return false;
                }
                char lastChar = braceStack.pop();

                if (lastChar == '[' && indexCharacter != ']') {
                    return false;
                }
                if (lastChar == '{' && indexCharacter != '}') {
                    return false;
                }
                if (lastChar == '(' && indexCharacter != ')') {
                    return false;
                }
            }

        }

        return braceStack.isEmpty();
    }


    public static int q4(int [] inputArray){

        String [] stringArray = new String[inputArray.length];
        String [] outputArray = new String[inputArray.length];

        for (int i = 0; i < inputArray.length; i++){
            stringArray[i] = String.valueOf(inputArray[i]);
        }

        int firstIndex = stringArray[0].indexOf(0);
        for (int i = 0; i < inputArray.length; i++){
            if (stringArray[i].indexOf(0) > firstIndex){

            }
        }


        return 0;
    }



}


