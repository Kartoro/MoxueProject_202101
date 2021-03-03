import java.util.*;

public class H_20210224 {
    public static void main(String[] args) {


    }

    //lc 844
    public boolean backspaceCompare(String S, String T) {
        Stack<Character> s1 = new Stack<>();
        Stack<Character> s2 = new Stack<>();

        char[] sChars = S.toCharArray();
        char[] tChars = T.toCharArray();

        for (int i = 0; i < sChars.length; i++) {
            if (sChars[i] == '#') {
                if (!s1.isEmpty()) {
                    s1.pop();
                }
            } else {
                s1.push(sChars[i]);
            }
        }

        for (int j = 0; j < tChars.length; j++) {
            if (tChars[j] == '#') {
                if (!s2.isEmpty()) {
                    s2.pop();
                }
            } else {
                s2.push(tChars[j]);
            }
        }

        if (s1.size() != s2.size()) {
            return false;
        }

        List<Character> s1List = new ArrayList<Character>(s1);
        List<Character> s2List = new ArrayList<Character>(s2);


        for (int k = 0; k < s1List.size(); k++) {
            if (s1List.get(k) != s2List.get(k)) {
                return false;
            }
        }

        return true;


    }

    //lc 1021
    public String removeOuterParentheses(String S) {
        StringBuilder sb = new StringBuilder();
        int level = 0;
        for (char c : S.toCharArray()) {
            if (c == ')') {
                --level;
            }
            if (level >= 1) {
                sb.append(c);
            }
            if (c == '(') {
                ++level;
            }
        }
        return sb.toString();

    }

    //lc 933
    class RecentCounter {


        Queue<Integer> q = new LinkedList<Integer>();

        public RecentCounter() {

        }

        public int ping(int t) {
            q.offer(t);
            while (q.peek() < t - 3000) {
                q.poll();
            }
            return q.size();

        }
    }

    //lc 394
    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<Integer> sInteger = new Stack<>();
        Stack<String> sString = new Stack<>();

        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                count = count * 10 + s.charAt(i) - '0';
            } else if (s.charAt(i) == '[') {
                sInteger.push(count);
                count = 0;
                sString.push(sb.toString());
                sb = new StringBuilder();
            } else if (s.charAt(i) == ']') {
                int n = sInteger.pop();
                String tmp = sb.toString();
                for (int j = 1; j < n; j++) {
                    sb.append(tmp);
                }
                sb = new StringBuilder(sString.pop() + sb.toString());
            } else {
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();
    }

    //lc 994
    public int orangesRotting(int[][] grid) {
        int l = grid.length;
        int w = grid[0].length;

        Queue<int[]> q = new LinkedList<>();

        int fresh = 0;
        for (int m = 0; m < l; m++) {
            for (int n = 0; n < w; n++) {
                if (grid[m][n] == 2) {
                    q.add(new int[]{m, n});
                }
                else if (grid[m][n] == 1) {
                    fresh++;
                }
            }
        }

        int time = 0;
        while (fresh > 0 && !q.isEmpty()) {
            time++;
            int size = q.size();

            for (int i = 0; i < size; i++) {
                int[] rusty = q.poll();

                int a = rusty[0];
                int b = rusty[1];

                if (a - 1 >= 0 && grid[a - 1][b] == 1) {
                    grid[a - 1][b] = 2;
                    fresh--;
                    q.add(new int[]{a - 1, b});
                }

                if (a + 1 < l && grid[a + 1][b] == 1) {
                    grid[a + 1][b] = 2;
                    fresh--;
                    q.add(new int[]{a + 1, b});
                }

                if (b - 1 >= 0 && grid[a][b - 1] == 1) {
                    grid[a][b - 1] = 2;
                    fresh--;
                    q.add(new int[]{a, b - 1});
                }

                if (b + 1 < w && grid[a][b + 1] == 1) {
                    grid[a][b + 1] = 2;
                    fresh--;
                    q.add(new int[]{a, b + 1});
                }


            }
        }

        if (fresh > 0) {
            return -1;
        } else {
            return time;
        }

    }

    //lc 42
    public int trap(int[] height) {
        if (height == null || height.length == 0){
            return 0;
        }
        int sum = 0;
        int size = height.length;
        int[] left_max = new int[size];
        int[] right_max = new int[size];

        left_max[0] = height[0];
        right_max[size - 1] = height[size - 1];

        for (int i = 1; i < size; i++){
            left_max[i] = Math.max(height[i],height[i-1]);
        }

        for (int j = size - 2; j >=0; j--){
            right_max[j] = Math.max(height[j], height[j+1]);
        }

        for (int m = 1; m < size-1; m++){
            sum += Math.max(left_max[m], right_max[m]) - height[m];
        }

        return sum;
    }

    //lc 567







}
