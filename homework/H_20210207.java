import java.util.HashMap;
import java.util.Map;

public class H_20210207 {
    public static void main(String[] args) {

    }

    //lc643
    public static double findMaxAverage(int[] nums, int k) {
        if (nums.length < k) {
            return 0;
        }

        double sum = 0;

        for (int j = 0; j < k; j++) {
            sum += nums[j];
        }

        double tempSum = sum;

        for (int i = k; i < nums.length; i++) {

            tempSum = tempSum - nums[i - k] + nums[i];

            sum = Math.max(tempSum, sum);

        }

        return sum / k;
    }

    //lc424
    public static int characterReplacement(String s, int k) {

        int stringLen = s.length();
        int sameCount = 0;
        int leftPosition = 0;
        int rightPosition = 0;


        //
        int[] countArray = new int[26];


        for (; rightPosition < stringLen; rightPosition++) {
            int indexNumber = s.charAt(rightPosition) - 'A';
            countArray[indexNumber]++;

            sameCount = Math.max(sameCount, countArray[indexNumber]);

            if (sameCount + k < rightPosition - leftPosition + 1) {
                countArray[s.charAt(leftPosition) - 'A']--;
                leftPosition++;
            }

        }

        return rightPosition - leftPosition;

    }

    //lc1590
    public int minSubarray(int[] nums, int p) {

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = (sum + nums[i]) % p;
        }

        if (sum == 0) return 0;

        Map<Integer, Integer> intMap = new HashMap<>();
        intMap.put(0, -1);
        int currentNum = 0;
        int subLength = nums.length;
        for (int j = 0; j < nums.length; j++) {
            currentNum = (currentNum + nums[j]) % p;
            intMap.put(currentNum, j);
            int target = (currentNum - sum + p) % p;
            if (intMap.containsKey(target)) {
                subLength = Math.min(subLength, j - intMap.get(target));
            }
        }

        return subLength < nums.length ? subLength : -1;


    }


    //lc1733
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {


    }


    //lc875
    public static int minEatingSpeed(int[] piles, int H) {
        int count = 1;
        while (count >= 0) {
            if (eatAll(piles, H, count)) {
                return count;
            }
        }
    }


    public static boolean eatAll(int piles[], int H, int count) {
        int time = 0;
        for (int i = 0; i < piles.length; i++) {
            time += piles[i] / count + (piles[i] % count == 0 ? 0 : 1);
            if (time > H) {
                return false;
            }
        }
        return true;
    }


    //lc480


}
