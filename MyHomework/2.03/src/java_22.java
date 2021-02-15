import java.util.ArrayList;
import java.util.List;

public class java_22 {
   private static List<String> res = new ArrayList<>();
    public static void main(String[] args){


        System.out.println(generateParenthesis(3));
    }
    public static List<String> generateParenthesis(int n) {
        int left = 0;
        int right = 0;

        //List<String> str = new ArrayList<String>();
        StringBuffer sb = new StringBuffer();
        dfs(n,left,right,0,sb);

        return res;
    }

    private static void dfs(int len, int left,int right, int pos,StringBuffer sb){


            if(len*2 == pos){
                if(isValid(sb)){
                    res.add(sb.toString());

                }
            }
            if(left < len){
                dfs(len,left+1, right,pos+1,sb.append("("));

            }
            if(right < len){
                dfs(len,left,right+1,pos+1,sb.append(")"));

            }


    }

    private static boolean isValid(StringBuffer str){
        int flag = 0;
        for(int i = 0; i < str.length();i++){

                char c = str.charAt(i);
               if(c == '('){
                  flag =flag + 1;
                } else{
                   flag = flag-1;
               }


        }
        if(flag == 0){
            return true;
        }
        return false;
    }
}