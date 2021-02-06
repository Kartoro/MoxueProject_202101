import java.util.ArrayList;
import java.util.List;

public class java_22 {
    List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        int left = 0;
        int right = 0;

        List<String> str = new ArrayList<String>();
        StringBuffer sb = new StringBuffer();
        dfs(n,left,right,0,str,sb);
        res.add(str.toString());
        return res;
    }

    private List<String> dfs(int len, int left,int right, int pos,List<String> str,StringBuffer sb){
        if(len*2 == pos){
            if(isValid(str)){
                str.add(sb.toString());

            }
        }
        else if(left < len){
            dfs(len,left+1, right,pos+1,str,sb.append("("));

        }
        else if(right < len){
            dfs(len,left,right+1,pos+1,str,sb.append(")"));

        }
        return str;
    }

    private boolean isValid(List<String> str){
        int flag = 0;
        for(int i = 0; i < str.size();i++){
            for(int j=0;j < str.get(i).length(); j++){
                char c = str.get(i).charAt(j);
               if(c == '('){
                  flag =flag + 1;
                } else{
                   flag = flag-1;
               }

            }
        }
        if(flag == 0){
            return true;
        }
        return false;
    }
}