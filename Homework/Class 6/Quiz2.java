// Leetcode.232 用栈实现队列

class MyQueue {

    Stack<Integer> stack = new Stack<>();
    Stack<Integer> reverseStack = new Stack<>();

    /** Initialize your data structure here. */
    public MyQueue() {

    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        stack.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        while(stack.size() != 0){
            reverseStack.push(stack.pop());
        }
        int pop = reverseStack.pop();
        while(reverseStack.size() != 0){
            stack.push(reverseStack.pop());
        }
        reverseStack.empty();
        return pop;
    }
    
    /** Get the front element. */
    public int peek() {
        while(stack.size() != 0) {
            reverseStack.push(stack.pop());
        }
        int peek = reverseStack.peek();
        while(reverseStack.size() != 0){
            stack.push(reverseStack.pop());
        }
        return peek;
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        if (stack.size() == 0){
            return true;
        }
        return false;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */