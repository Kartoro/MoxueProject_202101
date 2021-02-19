import java.util.Stack;

public class HomeWork_Class6 {
    //155. 最小栈
    class MinStack {
        Stack<Integer> stack;
        Stack<Integer> minStack;
        /** initialize your data structure here. */
        public MinStack() {
            stack = new Stack();
            minStack = new Stack();
        }

        public void push(int x) {
            stack.push(x);
            if(minStack.isEmpty()){
                minStack.push(x);
            }else{
                if(minStack.peek()>=x){
                    minStack.push(x);
                }else{
                    minStack.push(minStack.peek());
                }
            }
        }

        public void pop() {
            stack.pop();
            minStack.pop();

        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }


    }

    //232. 用栈实现队列
    class MyQueue {
        Stack<Integer> list;
        Stack<Integer> stack;
        /** Initialize your data structure here. */
        public MyQueue() {
            stack = new Stack();
            list = new Stack();
        }

        /** Push element x to the back of queue. */
        public void push(int x) {


            while(!list.isEmpty()){
                stack.push(list.peek());
                list.pop();
            }
            list.push(x);
            while(!stack.isEmpty()){
                list.push(stack.peek());
                stack.pop();
            }



        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            return list.pop();
        }

        /** Get the front element. */
        public int peek() {
            return list.peek();
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return list.isEmpty();
        }
    }

    //503. 下一个更大元素 II
    public int[] nextGreaterElements(int[] nums) {

        Stack<Integer> stack = new Stack();
        int[] result = new int[nums.length];
        if(nums.length==0){
            return result;
        }else if(nums.length==1){
            result[0] = -1;
            return result;
        }
        result[nums.length-1] = -1;
        stack.push(nums[nums.length-1]);
        int loop = 0;
        for(int i = nums.length-2;i>=0;i--){

            while(!stack.isEmpty()){
                if(nums[i]>=stack.peek()){
                    stack.pop();
                }else{
                    result[i] = stack.peek();
                    stack.push(nums[i]);
                    break;
                }

            }
            if(stack.isEmpty()){
                result[i] = -1;
                stack.push(nums[i]);
            }

            if(i==0 && loop==0){
                i = i + nums.length;
                loop++;
            }
        }
        return result;
    }

}
