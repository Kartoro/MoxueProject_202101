// Leetcode.875 爱吃香蕉的珂珂
class Solution {
    public int minEatingSpeed(int[] piles, int H) {

        Arrays.sort(piles);

        int min = Integer.MAX_VALUE;
        for (int n = piles[piles.length - 1]; n >= 1 ; n--){
            int count = 0;
            for (int each : piles){
                if (each % n == 0){
                    count += each / n;
                }
                else {
                    count += each / n + 1;
                }
            }
            if (count <= H){
                min = Math.min(min, n);
            } else {
                break;
            }
        }
        return min;
    }
}