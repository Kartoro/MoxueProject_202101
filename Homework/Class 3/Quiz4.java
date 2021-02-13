// Leetcode.22 括号生成
class Solution {

    ArrayList<String> resultList = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        processMethod(n, n, "");
        return resultList;
    }

    public void processMethod (int leftTotal, int rightTotal, String current) {
        if (leftTotal == 0 && rightTotal == 0) {
            resultList.add(current);
            return;
        }

        if (leftTotal == rightTotal) {
            processMethod(leftTotal - 1, rightTotal, current +"(");
        }
        if (leftTotal < rightTotal){
            if (leftTotal > 0) {
                processMethod(leftTotal - 1, rightTotal, current +"(");
            } 
            processMethod(leftTotal, rightTotal - 1, current +")");
        }
    }

}