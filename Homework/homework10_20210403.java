// 202
class Solution {
    public boolean isHappy(int n) {
        if(n==1){
            return true;
        }
        ArrayList<Integer> list=new ArrayList<>();
        list.add(n);
        while(n!=1){
            String[] data=String.valueOf(n).split("");
            
            n=0;
            for (int i = 0; i < data.length; i++) {
              n=n+Integer.parseInt(data[i])*Integer.parseInt(data[i]);
            }
            for (int i = 0; i <list.size(); i++) {
                if (n == list.get(i)) {
                    return false;
                }
            }
            list.add(n);
            
            if(n==1){
              return true;
            }
        }
        return false;
    }
}

// 409
class Solution {
    public int longestPalindrome(String s) {
        int count = 0;
        int[] arr = new int[52];  //记录每个字母出现的次数，包括大小写
        for(char c: s.toCharArray()){
            if(c>='a' && c<='z'){  
                arr[c-'a']++;
            }else{arr[c-'A'+26]++;}  
        }
        for(int n: arr){
            if(n%2==1){
                count += n-1;  //出现奇数次则减一
            }else{
                count += n;  //出现偶数次直接加上
            }
        }
        return count<s.length()?count+1:count;  //判断是否有单个字母可以放在回文串中间
    }
}

// 91

// 1647
class Solution {
    public int minDeletions(String s) {
        int[] count = new int[26];
        for(int i = 0; i < s.length(); i++) {
            count[s.charAt(i)-'a']++;
        }
        Arrays.sort(count);
        int res = 0;
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < 26; i++) {
            while(set.contains(count[i]) && count[i] != 0) {
                res++;
                count[i]--;
            }
            if(count[i] != 0) set.add(count[i]);
        }

        return res;
    }
}