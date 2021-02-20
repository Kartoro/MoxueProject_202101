import java.util.Arrays;
import java.util.Stack;

public class NextGreater {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> maxList = new Stack<>();
        int[] res = new int[nums.length];
        Arrays.fill(res,-1);
        for(int i=0; i <2*nums.length; i++){
            while(!maxList.isEmpty() && nums[maxList.peek()] <nums[i%nums.length]){
                res[maxList.pop()] = nums[i%nums.length];
            }
            maxList.push(i%nums.length);
        }
        return res;
    }
}
