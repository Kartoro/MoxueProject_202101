// Leetcode.503 下一个更大元素 II

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[nums.length];

        Arrays.fill(result, -1);

        for (int i = 0; i < nums.length * 2; i++){
            int index = i % nums.length;
            while (!stack.isEmpty() && nums[index] > nums[stack.peek()]){
                int popIndex = stack.pop();
                result[popIndex] = nums[index];
            }
            stack.push(index);
        }
            
        return result;
    }
}