public class J_844 {

    public static  void main(String[] args){

        System.out.println(backspaceCompare("ab##","c#d#"));


    }
    public static boolean backspaceCompare(String S, String T) {

        if(Finder(S,S.length()).equals(Finder(T,T.length()))){
            return true;
        }
        return false;
    }

    public static String Finder (String tem, int len){
        StringBuffer sb = new StringBuffer();
        int count = 0;
        for(int i =len-1; i >-1; i--){
            if(tem.charAt(i) == '#'){
                count ++;
            } else{
                if(count > 0){
                    count--;
                }else{
                    sb.append(tem.charAt(i));
                }
            }
        }
        return sb.toString();
    }

}
