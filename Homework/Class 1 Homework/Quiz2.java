import java.util.ArrayList;
import java.util.Scanner;

public class Quiz2 {
    public static void main (String[] args) {
        ArrayList<Integer> arrayListInteger = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        String string = String.valueOf(input.nextLine());
        String[] arrayString = string.split(",");
        for (String a : arrayString){
            arrayListInteger.add(Integer.parseInt(a));
        }

        ArrayList<Integer> arrayListIntegerSort = new ArrayList<>();

        for (int i = 0; i < arrayListInteger.size(); i++){

            int b = arrayListInteger.get(0);
            int flag = 0;
            for (int each : arrayListIntegerSort){
                if (arrayListInteger.get(i) == each){
                    flag = 1;
                    break;
                }
            }
            if (flag == 0){
                arrayListIntegerSort.add(arrayListInteger.get(i));
            }
        }

        ArrayList<Integer> arrayListCount = new ArrayList<>();

        for (int each1 : arrayListIntegerSort){
            int count = 0;

            for (int each2 : arrayListInteger) {
                if (each1 == each2) {
                    count += 1;
                }
            }
            arrayListCount.add(count);
        }

        int index = 0;

        for (int i = 0; i < arrayListCount.size(); i++){
            if (arrayListCount.get(i) > arrayListInteger.size()/2) {
                index = i;
            }
        }

        System.out.println("Sorted elements: " + arrayListIntegerSort);
        System.out.println("Count each element: " + arrayListCount);


        if (index != 0) {
            System.out.println("Yes, it is " + arrayListIntegerSort.get(index));
        } else {
            System.out.println("No");
        }

    }
}
