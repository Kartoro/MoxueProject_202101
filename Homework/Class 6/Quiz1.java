// Leetcode.155 最小栈

class MinStack {

    Stack<Integer> stack = new Stack<>();
    Stack<Integer> monotonousStack = new Stack<>();

    /** initialize your data structure here. */
    public MinStack() {

    }
    
    public void push(int x) {
        if (stack == null || stack.size() == 0){
            stack.push(x);
            monotonousStack.push(x);
        } else {
            if (monotonousStack.peek() < x) {
                stack.push(x);
            } else {
                stack.push(x);
                monotonousStack.push(x);
            }
        }
    }
    
    public void pop() {
        if (stack.peek().compareTo(monotonousStack.peek()) == 0) {
            stack.pop();
            monotonousStack.pop();
        } else {
            stack.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return monotonousStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */