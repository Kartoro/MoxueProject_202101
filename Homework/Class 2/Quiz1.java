// Leetcode.35 搜索插入位置
class Solution {
    public int searchInsert(int[] nums, int target) {

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }
            if (target < nums[i] && target > nums[i-1] ){
                return i;
            }
        }
        if (target > nums[nums.length - 1]){
            return nums.length;
        } else {
            return 0;
        }
    }
}