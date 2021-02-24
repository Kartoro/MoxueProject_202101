import java.util.*;

public class HomeWork_Class7 {
    //844
    public boolean backspaceCompare(String S, String T) {
        Stack<Character> stackS = new Stack<>();
        Stack<Character> stackT = new Stack<>();

        for(int i =0;i<S.length();i++){
            if(S.charAt(i)=='#'&&!stackS.isEmpty())
                stackS.pop();
            else if(S.charAt(i)!='#')
                stackS.push(S.charAt(i));
        }
        for(int i =0;i<T.length();i++){
            if(T.charAt(i)=='#'&&!stackT.isEmpty())
                stackT.pop();
            else if(T.charAt(i)!='#')
                stackT.push(T.charAt(i));
        }
        if(stackS.size()!=stackT.size())
            return false;
        while(!stackS.isEmpty()&&!stackT.isEmpty()){
            if(stackS.pop()!=stackT.pop())
                return false;
        }
        return true;
    }

    //1021
    public String removeOuterParentheses(String S) {
        StringBuffer result = new StringBuffer();
        int count = 0;
        int index = 0;
        for(int i = 0;i<S.length();i++){
            if(S.charAt(i)=='('){
                result.append('(');
                count = count + 1;
            }
            else{
                count = count - 1;
                if(count==0){
                    result.delete(index,index+1);
                    index = result.length();
                }
                else
                    result.append(')');
            }
        }
        return result.toString();
    }

    //933
    Queue<Integer> counter = new LinkedList<>();
    public RecentCounter() {

    }

    public int ping(int t) {
        counter.offer(t);
        while(counter.peek()<t-3000){
            counter.poll();
        }
        return counter.size();
    }

    //394
    public String decodeString(String s) {
        StringBuffer result = new StringBuffer();
        Stack<StringBuffer> stackS = new Stack<>();
        Stack<Integer> stackI = new Stack<>();
        int k = 0;
        for(int i=0; i<s.length();i++){
            if(Character.isDigit(s.charAt(i))){
                k = k*10+(s.charAt(i)-'0');
            }else if(Character.isLetter(s.charAt(i))){
                result.append(s.charAt(i));
            }else if(s.charAt(i)=='['){
                stackS.push(result);
                stackI.push(k);
                k=0;
                result = new StringBuffer();
            }else if(s.charAt(i)==']'){
                StringBuffer value = result;
                result = stackS.pop();
                int control = stackI.pop();
                for (int j =0; j < control;j++){
                    result.append(value);
                }

            }
        }
        return result.toString();
    }

    //994
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int normal = 0;
        int minus = 0;
        Set<int[]> queue = new HashSet<>();
        Set<int[]> newQueue;
        for(int i =0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j]==2){
                    queue.add(new int[]{i,j});
                }
                else if(grid[i][j]==1){
                    normal++;
                }
            }
        }
        newQueue = queue;
        while(normal>0 &&newQueue.size()>0){
            queue = new HashSet<>();
            for(int[] index : newQueue){
                // System.out.println("i:"+index[0]+",j:"+index[1]);
                if(index[0]-1>=0 && grid[index[0]-1][index[1]]==1){
                    grid[index[0]-1][index[1]] = 2;
                    queue.add(new int[]{index[0]-1,index[1]});
                    normal--;
                }
                if(index[0]+1<rows && grid[index[0]+1][index[1]]==1){
                    grid[index[0]+1][index[1]] = 2;
                    queue.add(new int[]{index[0]+1,index[1]});
                    normal--;
                }
                if(index[1]+1<cols && grid[index[0]][index[1]+1]==1){
                    grid[index[0]][index[1]+1] = 2;
                    queue.add(new int[]{index[0],index[1]+1});
                    normal--;
                }
                if(index[1]-1>=0 && grid[index[0]][index[1]-1]==1){
                    grid[index[0]][index[1]-1] = 2;
                    queue.add(new int[]{index[0],index[1]-1});
                    normal--;
                }
            }
            minus++;
            newQueue = queue;

        }

        return normal!=0?-1:minus;

    }

    //42
    public int trap(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int total = 0;
        int start = 0;
        if(height.length<=2)
            return total;
        for(int i=0;i<height.length;i++){
            if(stack.isEmpty() && height[i]>0){
                start = height[i];
                stack.push(height[i]);
            }
            else if (!stack.isEmpty()){
                if(stack.peek()<height[i]){
                    if(start<=height[i]){
                        while(!stack.isEmpty()){
                            total = total + start - stack.pop();
                        }
                        start = height[i];
                    }
                    else{
                        int count = 0;
                        while(!stack.isEmpty() && stack.peek()<height[i]){
                            count++;
                            total = total + height[i] - stack.pop();
                        }
                        for(int j =0; j<count;j++){
                            stack.push(height[i]);
                        }

                    }
                }
                stack.push(height[i]);

            }

        }
        return total;
    }
}
