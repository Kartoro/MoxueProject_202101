import java.util.*;

public class java_49 {

    public static void main(String[] args){

        String[] ss ={"eat","tea","tan","ate","nat","bat"};
        System.out.println(groupAnagrams(ss));
    }
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<String,List<String>>();

        if(strs.length == 0){
            return new ArrayList<>();
        }
        for(int i =0;i<strs.length; i++){

            char[] arrayCh = strs[i].toCharArray();
            Arrays.sort(arrayCh);
            //换位是对原数组进行变化
            String tem = Arrays.toString(arrayCh);
            if(map.containsKey(tem)){
                map.get(tem).add(strs[i]);

            }else{
                map.put(tem,new ArrayList<String>());
                map.get(tem).add(strs[i]);

            }
        }
        return new ArrayList<>(map.values());

    }
}
