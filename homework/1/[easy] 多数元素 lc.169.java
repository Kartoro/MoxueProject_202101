import java.util.ArrayList;
import java.util.List;

public class Main{
    public static void main(String[]args){
        System.out.println(majorityElement1(new int[]{1, 2, 1, 2, 1}));
        System.out.println(majorityElement2(new int[]{1,2,3,1,2,3,3,3,3}));
    }

    public static int majorityElement1(int[] nums) {
        int cand_num = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (cand_num == nums[i])
                count++;
            else if (count == 0){
                cand_num = nums[i];
                count = 1;
            } else {
                count--;
            }
        }
        return cand_num;
    }
    public static List<Integer> majorityElement2(int[] nums){
        List<Integer> cand_num = new ArrayList<>();
        int cand_num1 = nums[0];
        int cand_num2 = nums[0];
        int count1 = 0;
        int count2 = 0;
        for (int i = 1; i < nums.length; i++){
            if (cand_num1 == nums[i]){
                count1++;
            }
            else if (cand_num2 == nums[i]){
                count2++;
            }
            else if (count1 == 0) {
                cand_num1 = nums[i];
                count1++;
            }
            else if (count2 == 0) {
                cand_num2 = nums[i];
                count2++;
            } else {
                count1--;
                count2--;
            }
        }
        cand_num.add(cand_num1);
        cand_num.add(cand_num2);
        return cand_num;
    }//without checking the existence of elements

}