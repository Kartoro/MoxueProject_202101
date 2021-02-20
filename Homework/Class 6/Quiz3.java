// Leetcode.503 下一个更大元素 II

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++){
            int j = -1;
            j = i + 1;
            while (j != i){
                if (j < nums.length){
                    if (nums[j] > nums[i]){
                        result[i] = nums[j];
                        break;
                    }
                } else {
                    j = 0;
                    if (nums[j] > nums[i]){
                        result[i] = nums[j];
                        break;
                    } else {
                        j = -1;
                    }
                }
                j++;
            }
            if (j == i && result[i] == 0){
                result[i] = - 1;
            }

        }
        return result;
    }
}