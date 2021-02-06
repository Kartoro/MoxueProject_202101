import jdk.jfr.StackTrace;

import java.util.*;

public class phone_17 {
    private static List<String> res = new ArrayList<>();
    private static Map<String,String> phoneMap = new HashMap<String,String>(){{
        put("2","abc");
        put("3","def");
        put("4","ghi");
        put("5","jkl");
        put("6","mno");
        put("7","pqrs");
        put("8","tuv");
        put("9","wxyz");
    }};

    public static void main(String[] args){
        letterCombinations("23");
        System.out.println(res);
    }

    public static List<String> letterCombinations(String digits){

        //用map将数字与对应的字母进行存储

        if(digits.length() == 0){
            return res;

        } else{
            StringBuffer sb = new StringBuffer();

            dfs(digits,sb);
            res.add(sb.toString());
        }

        return res;
    }

    private static void dfs(String digits, StringBuffer sb){

        for(int i = 0;i < digits.length()-1;i++){
            char[] c = phoneMap.get(i).toCharArray();
            for(char ele: c){
                sb.append(ele);
                String tem = digits.substring(i,i+1);
                dfs(tem,sb);
            }

        }
    }
}



