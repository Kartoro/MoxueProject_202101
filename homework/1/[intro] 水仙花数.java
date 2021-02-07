public class Main{
    public static void main(String[]args){
        for (int i = 100; i < 1000; i++){
            int h = 0;
            int t = 0;
            int s = 0;
            h = i/100;
            t = i/10%10;
            s = i%10;
            if (h*h*h+t*t*t+s*s*s == i){
                System.out.println(i);
            }

        }
    }
}