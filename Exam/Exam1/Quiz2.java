// 227. 基本计算器II
class Solution {
    public int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        String trimString = s.replace(" ", "");
        ArrayList<String> arrayList = new ArrayList<String>();

        int i = 0;
        StringBuffer stringBuffer = new StringBuffer();
        while (i < trimString.length()) {
            if (trimString.charAt(i) == '+') {
                arrayList.add(stringBuffer.toString());
                stringBuffer.setLength(0);
                arrayList.add("+");
                i++;
            } else if (trimString.charAt(i) == '-') {
                arrayList.add(stringBuffer.toString());
                stringBuffer.setLength(0);
                arrayList.add("-");
                i++;
            } else if (trimString.charAt(i) == '*') {
                arrayList.add(stringBuffer.toString());
                stringBuffer.setLength(0);
                arrayList.add("*");
                i++;
            } else if (trimString.charAt(i) == '/') {
                arrayList.add(stringBuffer.toString());
                stringBuffer.setLength(0);
                arrayList.add("/");
                i++;
            } else {
                stringBuffer.append(trimString.charAt(i));
                i++;
            }
        }
        arrayList.add(stringBuffer.toString());

        int currentResult = 0;
        for (int j = 0; j < arrayList.size(); j++) {
            if (arrayList.get(j).equals("*") || arrayList.get(j).equals("/")) {
                currentResult = process (arrayList.get(j - 1), arrayList.get(j), arrayList.get(j + 1));
                arrayList.set(j - 1, "@");
                arrayList.set(j, "@");
                arrayList.set(j + 1, String.valueOf(currentResult));
            }
        }

        
        ArrayList<String> noZeroArrayList = new ArrayList<>();
        for (int k = 0; k < arrayList.size(); k++){
            if (!arrayList.get(k).equals("@")){
                noZeroArrayList.add(arrayList.get(k));
            }
        }

        if (noZeroArrayList == null || noZeroArrayList.size() == 0){
            return 0;
        }

        for (int m = 0; m < noZeroArrayList.size(); m++) {
            if (noZeroArrayList.get(m).equals("+") || noZeroArrayList.get(m).equals("-")) {
                currentResult = process (noZeroArrayList.get(m - 1), noZeroArrayList.get(m), noZeroArrayList.get(m + 1));
                noZeroArrayList.set(m - 1, "@");
                noZeroArrayList.set(m, "@");
                noZeroArrayList.set(m + 1, String.valueOf(currentResult));
            }
        }

        return Integer.valueOf(noZeroArrayList.get(noZeroArrayList.size() - 1));
    }

    public int process (String left, String operator, String right){
        int result = 0;
        if (operator.equals("*")) {
            result = Integer.valueOf(left) * Integer.valueOf(right);
        }

        if (operator.equals("/")) {
            result = Integer.valueOf(left) / Integer.valueOf(right);
        }

        if (operator.equals("+")) {
            result = Integer.valueOf(left) + Integer.valueOf(right);
        }

        if (operator.equals("-")) {
            result = Integer.valueOf(left) - Integer.valueOf(right);
        }

        return result;
    }
}