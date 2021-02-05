// Leetcode.49 字母易位词分组
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        ArrayList<String> sortedList = new ArrayList<>();
        List<List<String>> resultList = new ArrayList<>();

        for (int i = 0; i < strs.length; i++){
            char tempArray[] = strs[i].toCharArray();
            Arrays.sort(tempArray);
            String sortedString = new String (tempArray);
            sortedList.add(sortedString);
        }

        for (int j = 0; j < sortedList.size(); j++){
            ArrayList<String> resultString = new ArrayList<>();
            if (!sortedList.get(j).equals("*")){
                resultString.add(strs[j]);

                for (int k = j + 1; k < sortedList.size(); k++){
                    if (sortedList.get(j).equals(sortedList.get(k))){
                        resultString.add(strs[k]);
                        sortedList.set(k, "*");
                    }
                }
                resultList.add(resultString);
                sortedList.set(j, "*");
            }

        }

        return resultList;
    }
}