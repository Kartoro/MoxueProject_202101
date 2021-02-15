import javax.annotation.processing.SupportedSourceVersion;
import java.util.*;

public class HomeWork_Week3 {
    //643. 子数组最大平均数 I
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        for(int i = 0; i < k; i++){
            sum = sum + nums[i];
        }
        int result = sum;
        for(int i = k;i<nums.length;i++){
            sum = sum + nums[i] - nums[i-k];
            result = Math.max(sum,result);
        }
        return (double)(result)/ (double)(k);
    }

    //424. 替换后的最长重复字符
    public int characterReplacement(String s, int k) {

        int maxsame = 0;
        int len = s.length();
        int left = 0;
        int[] arr = new int[26];
        int right = 0;
        while(right < len){
            int index = s.charAt(right) - 'A';
            arr[index]++;
            maxsame = Math.max(maxsame,arr[index]);
            if (maxsame + k < right - left + 1) {
                arr[s.charAt(left) - 'A']--;
                left++;
            }
            ++right;
        }

        return right - left;
    }
    //1590. 使数组和能被 P 整除
    public int minSubarray(int[] nums, int p) {
        int[] numsMode = new int[nums.length];
        int sumMode = 0;
        for(int i = 0; i < nums.length; i++){
            numsMode[i] = nums[i] % p;
            sumMode = (sumMode + nums[i]) % p;
        }
        if(sumMode==0)
            return 0;
        int count = nums.length;
        for(int i = 0;i<numsMode.length;i++){
            int sum = 0;
            int subCount = 0;
            for(int j = i;j<numsMode.length;j++){
                sum = (sum + numsMode[j])%p;
                subCount = subCount + 1;
                if(sum == sumMode){
                    count = Math.min(subCount,count);
                    j = numsMode.length;
                }
            }
        }
        return count == nums.length ? -1 : count ;
    }

    //1733. 需要教语言的最少人数
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        int[] language =new int[n+1];
        int[] people =new int[languages.length];
        int uncommon=0;
        for (int[] f:friendships) {
            int f1=f[0]-1;
            int f2=f[1]-1;
            if(!hasCommon(languages,f1,f2)){
                if(people[f1]==0){
                    people[f1]++;
                    uncommon++;
                    for (int i = 0; i < languages[f1].length ; i++) {
                        language[languages[f1][i]]++;
                    }
                }
                if(people[f2]==0){
                    people[f2]++;
                    uncommon++;
                    for (int i = 0; i < languages[f2].length ; i++) {
                        language[languages[f2][i]]++;
                    }
                }
            }
        }
        int maxL=0;
        for (int j : language) {
            maxL = Math.max(maxL, j);
        }
        return uncommon-maxL;
    }
    public boolean hasCommon(int[][] languages,int x,int y){
        for(int l1:languages[x]){
            for( int l2:languages[y]){
                if(l1==l2)return true;
            }
        }
        return false;
    }

    //875. 爱吃香蕉的珂珂
    public int minEatingSpeed(int[] piles, int H) {
        int lo = 1;
        int hi = 1000000000;
        while (lo < hi) {
            int mi = (lo + hi) / 2;
            if (!possible(piles, H, mi))
                lo = mi + 1;
            else
                hi = mi;
        }

        return lo;

    }

    public boolean possible(int[] piles, int H, int K) {
        int time = 0;
        for (int p: piles)
            time += p/K + (p%K==0?0:1);
        return time <= H;
    }

}
