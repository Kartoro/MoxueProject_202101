public class calculator {
    //没写完
    public static void main(String[] args){

        System.out.println(calculate("3+2*2"));
    }
    public static int calculate(String s) {
        String withoutSpace = s.replace(" ","");
        for(int i=1; i < s.length(); i++){
            if(s.charAt(i) == '*' ){
                int left = Integer.parseInt(String.valueOf(s.charAt(i-1)));
                int right = Integer.parseInt(String.valueOf(s.charAt(i+1)));
                int res = left * right;
                withoutSpace = withoutSpace.substring(0,i-1) + String.valueOf(res)  + withoutSpace.substring(i+2,s.length());
            } else if(s.charAt(i) == '/'){
                int left = Integer.parseInt(String.valueOf(s.charAt(i-1)));
                int right = Integer.parseInt(String.valueOf(s.charAt(i+1)));
                int res = left / right;
                withoutSpace = withoutSpace.substring(0,i-1) + String.valueOf(res) + withoutSpace.substring(i+2,s.length());
            } else if(s.charAt(i) == '+'){
                int left = Integer.parseInt(String.valueOf(s.charAt(i-1)));
                int right = Integer.parseInt(String.valueOf(s.charAt(i+1)));
                int res = left + right;
                withoutSpace = withoutSpace.substring(0,i-1) + String.valueOf(res) + withoutSpace.substring(i+2,s.length());
            } else{
                int left = Integer.parseInt(String.valueOf(s.charAt(i-1)));
                int right = Integer.parseInt(String.valueOf(s.charAt(i+1)));
                int res = left - right;
                withoutSpace = withoutSpace.substring(0,i-1) + String.valueOf(res) + withoutSpace.substring(i+2,s.length());
            }
        }
        return Integer.parseInt(withoutSpace);

    }
}
