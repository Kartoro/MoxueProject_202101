//567
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        if(len1 > len2){
            return false;
        }
        int left = 0;
        int right = 0;
        int[] freq = new int[26];
        for(char c:s1.toCharArray()){
            freq[c-'a']++;
        }
        while(right < len2){
            freq[s2.charAt(right)-'a']--;
            while(freq[s2.charAt(right)-'a']<0){
                ++freq[s2.charAt(left++)-'a'];
            }
            right++;
            if(right - left == len1){
                return true;
            }
        }
        return false;
    }
}

//832
class Solution {
    public int[][] flipAndInvertImage(int[][] A) {


        for(int[] s:A){
            int left = 0;
            int right = s.length - 1;
            while(left <= right){
                int temp = s[left]^1;
                s[left] = s[right]^1;
                s[right] = temp;
                left = left + 1;
                right = right - 1;
            }
        }
        return A;

    }
}

//766
class Solution{
    public boolean isToeplitzMatrix(int[][] matrix) {
        int m = matrix.length; 
        int n = matrix[0].length; 

        for (int i = 0; i < n - 1; i++) {// 第一行 从[0, n - 1)
            int num = matrix[0][i];//当前需要比较的数字
            for (int x = 0,y = i; x < m && y < n; x++,y++) {//往右下方遍历
                if (num != matrix[x][y]) {
                    return false;
                }
            }
        }

        for (int i = 1; i < m - 1; i++) {// 第一列 从[1, m - 1)
            int num = matrix[i][0];//当前需要比较的数字
            for (int x = i,y = 0; x < m && y < n; x++,y++) {//往右下方遍历
                if (num != matrix[x][y]) {
                    return false;
                }
            }
        }
        return true;
    }
}

//1052
class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int ans = 0;    //不生气时的客户总数
        int tem = 0;    //生气时X范围内的最大客户数
        int sum = 0;   //生气时X范围内的客户数
        int start = 0;
        for (int i = 0; i < customers.length; i++) {
            if (grumpy[i] == 0) {
                ans += customers[i];
                customers[i] = 0;
            }
            //滑动窗口
            if (X == i) {
                X++;
                sum = sum + customers[i] - customers[start]; //每个窗口的最多值
                tem = Math.max(tem, sum);
                start++;
            } else {  //找窗口的边界
                sum += customers[i];
                tem = Math.max(tem, sum);
            }
        }
        return ans + tem;
    }
}

//6











