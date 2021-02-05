import java.lang.reflect.Array;
import java.util.*;

public class HomeWork_Week2 {
    //125. 验证回文串
    public boolean isPalindrome(String s) {
        if (s.equals(""))
            return true;
        else if (s.length() == 1)
            return true;
        int index1 = 0, index2 = s.length() - 1;
        while (index1 < index2) {
            while (index1 < index2 && !Character.isLetterOrDigit(s.charAt(index1))) {
                index1 = index1 + 1;
            }
            while (index1 < index2 && !Character.isLetterOrDigit(s.charAt(index2))) {
                index2 = index2 - 1;
            }
            if(index1<index2){
                if (Character.toLowerCase(s.charAt(index1))==Character.toLowerCase(s.charAt(index2))){
                    index1 = index1 + 1;
                    index2 = index2 - 1;
                }else {
                    return false;
                }

            }
        }
        return true;
    }

    //387. 字符串中的第一个唯一字符
    public int firstUniqChar(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            if(map.containsKey(s.charAt(i))){
                map.put(s.charAt(i),-1);
            }else{
                map.put(s.charAt(i),i);
            }

        }

        int pos = Integer.MAX_VALUE;
        for(Character character:map.keySet()){
            if(map.get(character)!= -1 && map.get(character)<pos){
                pos = map.get(character);
            }
        }
        if(pos==Integer.MAX_VALUE)
            return -1;
        else return pos;
    }

    //17. 电话号码的字母组合
    public List<String> letterCombinations(String digits) {
        ArrayList<String> array = new ArrayList<>();
        if(digits.length()==0)
            return array;
        StringBuffer result = new StringBuffer();
        HashMap<Character,String> map = new HashMap<Character,String>(){{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }
        };
        returnValue(digits,0,map,array,result);

        return array;
    }

    void returnValue(String value,int level,HashMap<Character,String> map,ArrayList<String> arrayList,StringBuffer result){
        String string = (String) map.get(value.charAt(level));

        int totalLevel = value.length();
        for(int i = 0 ; i<string.length(); i++){
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(result);
            stringBuffer.append(string.charAt(i));
            if(level<totalLevel-1){
                level = level +1;
                returnValue(value,level,map,arrayList,stringBuffer);
                level = level -1;
            }
            else{
                arrayList.add(stringBuffer.toString());
            }
        }
    }
    //22. 括号生成
    public List<String> generateParenthesis(int n) {
        StringBuffer result = new StringBuffer();
        List<String> returnResult = new ArrayList<>();
        if(n==0)
            return returnResult;
        dfs(result, n, n,returnResult);
        return returnResult;
    }
    void dfs(StringBuffer result, int left, int right,List<String> returnResult){
        if(left==0 && right==0)
        {
            returnResult.add(String.valueOf(result));
            return;
        }

        if(left>right)
            return;
        if(left > 0){
            result.append("(");
            dfs(result, left - 1, right,returnResult);
            result.deleteCharAt(result.length()-1);
        }
        if(right > 0){
            result.append(")");
            dfs(result, left , right - 1,returnResult);
            result.deleteCharAt(result.length()-1);
        }



    }


    //49. 字母异位词分组
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String str : strs) {
            char[] old = str.toCharArray();
            Arrays.sort(old);
            String key = String.valueOf(old);
            List<String> results;
            if (map.containsKey(key)) {
                results = map.get(key);
            } else {
                results = new ArrayList<>();
            }
            results.add(str);
            map.put(key, results);
        }

        List<List<String>> returnResults = new ArrayList<>();
        for(String key : map.keySet()){
            returnResults.add(map.get(key));
        }

        return returnResults;
    }

    //1737. 满足三条件之一需改变的最少字符数
    public int minCharacters(String a, String b) {
        int alen = a.length(),blen = b.length();
        int[] aArray = new int[26],bArray = new int[26];
        int minCharacter = Integer.MAX_VALUE;
        for(char s : a.toCharArray()){
            aArray[s-'a'] = aArray[s-'a']+1;
        }
        for(char s : b.toCharArray()){
            bArray[s-'a'] = bArray[s-'a']+1;
        }
        int atotal = aArray[0];
        int btotal = bArray[0];
        for(int i =1;i<26;i++){
            minCharacter = Math.min(alen - atotal + btotal, minCharacter);
            minCharacter = Math.min(blen - btotal + atotal, minCharacter);
            minCharacter = Math.min(alen + blen - aArray[i] - bArray[i], minCharacter);
            atotal = atotal + aArray[i];
            btotal = btotal + bArray[i];
        }
        minCharacter = Math.min(alen + blen - aArray[0] - bArray[0], minCharacter);
        return minCharacter;
    }
}
