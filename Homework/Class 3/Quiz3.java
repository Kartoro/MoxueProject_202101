//Leetcode.17 电话号码的字母组合
class Solution {
    public List<String> letterCombinations(String digits) {
        HashMap<String, String> digitMap = new HashMap<>();
        digitMap.put("2", "abc");
        digitMap.put("3", "def");
        digitMap.put("4", "ghi");
        digitMap.put("5", "jkl");
        digitMap.put("6", "mno");
        digitMap.put("7", "pqrs");
        digitMap.put("8", "tuv");
        digitMap.put("9", "wxyz");

        ArrayList<String> stringList = new ArrayList<>();
        ArrayList<String> resultList = new ArrayList<>();

        for (char each : digits.toCharArray()){
            stringList.add(digitMap.get(String.valueOf(each)));
        }

         if (digits.length() == 0){
            return resultList;
        } else if (digits.length() == 1) {
            for (char a : stringList.get(0).toCharArray()){
                resultList.add(String.valueOf(a));
            }
        } else if (digits.length() == 2){
            for (char a : stringList.get(0).toCharArray()){
                for (char b : stringList.get(1).toCharArray()){
                    String combo = String.valueOf(a) + String.valueOf(b);
                    resultList.add(combo);
                }
            }
        } else if (digits.length() == 3){
            for (char a : stringList.get(0).toCharArray()){
                for (char b : stringList.get(1).toCharArray()){
                    for (char c : stringList.get(2).toCharArray()){
                        String combo = String.valueOf(a) + String.valueOf(b) + String.valueOf(c);
                        resultList.add(combo);
                    }
                }
            }
        } else if (digits.length() == 4){
            for (char a : stringList.get(0).toCharArray()){
                for (char b : stringList.get(1).toCharArray()){
                    for (char c : stringList.get(2).toCharArray()){
                        for (char d : stringList.get(3).toCharArray()){
                            String combo = String.valueOf(a) + String.valueOf(b) + String.valueOf(c) + String.valueOf(d);
                            resultList.add(combo);
                        }
                    } 
                }
            }
        }

        return resultList;
    }
}