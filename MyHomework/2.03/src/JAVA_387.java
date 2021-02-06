import java.util.HashMap;

public class JAVA_387 {

    public static void main(String[] args){

        System.out.println(firstUniqChar("leetcode"));
    }
    public static int firstUniqChar(String s) {
        char[] str = s.toCharArray();
        HashMap<Character, Integer> stringMap = new HashMap<Character, Integer>();
        for(char ele:str){
            stringMap.put(ele,stringMap.getOrDefault(ele,0)+1);
        }
        for(int i = 0; i <s.length();i++){
            if(stringMap.get(str[i]) == 1){
                return i;

            }

        }
        return -1;
    }
}
