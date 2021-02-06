public class java_125 {

    public static void main(String[] args){

        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }
    public static boolean isPalindrome(String s) {
        int i =0;
        int j = s.length()-1;
        while(i<=j) {
            if (Character.isLetterOrDigit(s.charAt(i)) == false) {
                i++;
                continue;
            }
            if (Character.isLetterOrDigit(s.charAt(j)) == false) {
                j--;
                continue;
            }

            if (Character.toLowerCase(s.charAt(i)) == Character.toLowerCase(s.charAt(j))) {
                i++;
                j--;

            }else{
                return false;

            }
        }
        return true;
    }
}
