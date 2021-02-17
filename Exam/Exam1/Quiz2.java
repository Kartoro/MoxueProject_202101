public class Quiz2 {

    public static void main (String[] args) {

        String input = "3+2*2";

        Exam1.Quiz2 quiz2 = new Exam1.Quiz2();
        System.out.println(quiz2.method(input));

    }

    public int method (String input){
        if (input == null || input.length() == 0){
            return 0;
        }

        String trimString = input.replace(" ", "");
      

    public int process (String left, char operator, String right){
        int result = 0;
        if (operator == '*'){
            result = Integer.valueOf(left) * Integer.valueOf(right);
        }

        if (operator == '/'){
            result = Integer.valueOf(left) / Integer.valueOf(right);
        }
        return result;
    }
}