//Leetcode.17 电话号码的字母组合
class Solution {

    ArrayList<String> resultList = new ArrayList<>();
    String[] digitLetters = {"_", "!@#", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        
        if (digits == null || digits.length() == 0) {
            return resultList;
        }

        digitLetterMethod(digits, digitLetters, 0);

        return resultList;
    }

    public void digitLetterMethod (String digits, String[] digitLetters, int i){

        if (i  == digits.length()) {
            return;
        } else {
            ArrayList<String> newResultList = new ArrayList<>();
            if (i == 0) {
                for (char eachLetter : digitLetters[digits.charAt(i) - '0'].toCharArray()) {
                    newResultList.add(String.valueOf(eachLetter));
                }
            } else {
                
                for (char eachLetter : digitLetters[digits.charAt(i) - '0'].toCharArray()) {

                    for (String each : resultList) {
                        String newEach = each + eachLetter;

                        newResultList.add(newEach);
                    }
                }
                
            }
            resultList = newResultList;
            digitLetterMethod(digits, digitLetters, i + 1);
        }
    }
}