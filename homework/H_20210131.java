import java.util.*;

public class H_20210131 {
    public static void main(String[] args) {

        System.out.println(maxUniPre(new String[] {"flow", "flight", "flom"}));

    }


    public static String maxUniPre(String strs[]){

        String common = "";
        int minLength = strs[0].length();

        do {
            for (int i = 0; i < strs.length; i++) {
                if (strs[i].length() < minLength) {
                    minLength = strs[i].length();
                    common = strs[i].substring(0, minLength - 1);
                }

            }

            for (int j = 0; j < strs.length; j++) {
                if (!strs[j].substring(0, minLength - 1).equals(common)) {
                    minLength --;
                    break;
                }else {
                    return common;
                }
            }

        }while (minLength > 0);



        return "No such exists";
    }


    //lc.125(timeout_fixed)
    public static boolean palindromCheck(String s){

        s = s.toLowerCase();
        int leftPointer = 0;
        int rightPointer = s.length() - 1;

        while (leftPointer <= rightPointer){
            if (!Character.isLetterOrDigit(s.charAt(leftPointer))){
                leftPointer++;
                continue;
            }

            if (!Character.isLetterOrDigit(s.charAt(rightPointer))){
                rightPointer--;
                continue;
            }

            if (s.charAt(leftPointer) != s.charAt(rightPointer)){
                return false;
            }

            leftPointer++;
            rightPointer--;
        }

        return true;

    }

    //lc.387
    public static int firstCharacter(String s){
        Map<Character, Integer> dicMap = new HashMap<>();

        char[] chars = s.toCharArray();
        for (char charIndex: chars){
            dicMap.put(charIndex, dicMap.getOrDefault(charIndex, 0) + 1);
        }

        for (int i = 0; i < s.length(); i++){
            if (dicMap.get(s.charAt(i)) == 1){
                return i;
            }
        }

        return -1;
    }

    //lc.17(not finished)
    public static List<String> letterResult(String digits){
        ArrayList<String>  resultList = new ArrayList<>();

        if (digits == null || digits.length() == 0) {
            return resultList;
        }

        String [] digitsBag = new String[8];
        digitsBag[0] = "abc";
        digitsBag[1] = "def";
        digitsBag[2] = "ghi";
        digitsBag[3] = "jkl";
        digitsBag[4] = "mno";
        digitsBag[5] = "pqrs";
        digitsBag[6] = "tuv";
        digitsBag[7] = "wxyz";


        return resultList;


    }

    //lc.22
    public static List<String>  parentThesis(int n){
        ArrayList<String>  resultList = new ArrayList<>();

        return resultList;
    }


    //lc.49
    public static List<List<String>> anagramsSort(String [] strs){
        HashMap<String, List<String>> strMap = new HashMap<>();
        for (int i= 0 ;i < strs.length; i++){
            char [] anagramChars = strs[i].toCharArray();

            Arrays.sort(anagramChars);

            String key = String.valueOf(anagramChars);

            if (strMap.containsKey(key)){
                strMap.get(key).add(strs[i]);
            }else {
                List<String> tempList = new ArrayList<String>();
                tempList.add(strs[i]);
                strMap.put(key, tempList);
            }


        }

        return new ArrayList<List<String>>(strMap.values());
    }


    //lc.1737




}
