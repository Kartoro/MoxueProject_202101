import java.util.Scanner;

public class Quiz1 {
    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);
        int inputInt = Integer.parseInt(String.valueOf(input.nextLine()));
        int a = inputInt / 100;
        int b = (inputInt - a*100)/10;
        int c = inputInt - a*100 - b*10;

        if (inputInt == Math.pow(a,3) + Math.pow(b,3) + Math.pow(c,3)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        };
    }
}
