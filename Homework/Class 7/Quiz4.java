// Leetcode.394 字符串解码

class Solution {

    String result = "";

    public String decodeString(String s) {
        if (s == null || s.length() == 0){
            return "";
        } else if (s.length() == 1){
            return s;
        } else {
            process(s);
            return result;
        }
    }

    public void process (String s) {


        Stack<Integer> stack = new Stack<>();
        int count = 0;
        int leftBracketCount = 0;

        // convert String to ArrayList
        ArrayList<String> arrayList = stringToArrayList(s);


        for (int j = 0; j < arrayList.size(); j++){

            if (arrayList.get(j).equals("[")){
                leftBracketCount = j;
                stack.push(leftBracketCount);
            }
            if (arrayList.get(j).equals("]")){

                int times = Integer.valueOf(arrayList.get(stack.pop() - 1));
                StringBuffer stringBuffer = new StringBuffer();
                for (int i = 0; i < times; i++){
                    stringBuffer.append(arrayList.get(j - 1));
                }
                process(s.replace(times + "[" + arrayList.get(j - 1) + "]", stringBuffer.toString()));
                return;
            }
            count++;

            if (stack.empty() && count == arrayList.size()){
                result = s;
                return;
            }

        }
    }

    public ArrayList<String> stringToArrayList (String s){

        ArrayList<String> arrayList = new ArrayList<>();
        StringBuffer digitStringBuffer = new StringBuffer();
        StringBuffer letterStringBuffer = new StringBuffer();

        for (int i = 0; i < s.length() - 1; i++){
            if (Character.isDigit(s.charAt(i))){
                digitStringBuffer.append(s.charAt(i));
                if (s.charAt(i + 1) == '['){
                    arrayList.add(digitStringBuffer.toString());
                    digitStringBuffer.setLength(0);
                    arrayList.add("[");
                    i++;
                }
            } else if (Character.isLetter(s.charAt(i))){
                letterStringBuffer.append(s.charAt(i));
                if (i + 1 == s.length() - 1 || Character.isDigit(s.charAt(i + 1))){
                    arrayList.add(letterStringBuffer.toString());
                    letterStringBuffer.setLength(0);
                } else if (s.charAt(i + 1) == ']'){
                    arrayList.add(letterStringBuffer.toString());
                    letterStringBuffer.setLength(0);
                    arrayList.add("]");
                    i++;
                }
            } else {
                arrayList.add("]");
            }
        }

        // deal with the last index
        if (s.charAt(s.length() - 1) == ']'){
            arrayList.add("]");
        } else if (Character.isLetter(s.charAt(s.length() - 1)) && s.charAt(s.length() - 2) != ']') {
            String lastElement = arrayList.get(arrayList.size() - 1) + s.charAt(s.length() - 1);
            arrayList.set(arrayList.size() - 1, lastElement);
        } else {
            arrayList.add(String.valueOf(s.charAt(s.length() - 1)));
        }

        return arrayList;
    }

}