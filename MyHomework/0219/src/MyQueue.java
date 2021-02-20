import java.util.ArrayList;
import java.util.List;
//232
class MyQueue {
    private List<Integer> list;
    int start;
    /** Initialize your data structure here. */
    public MyQueue() {
        list = new ArrayList<>();
        start =0;
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        list.add(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        int ans = list.remove(start);

        return ans;
    }

    /** Get the front element. */
    public int peek() {
        return list.get(0);
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        if(!list.isEmpty()){
            return false;
        }
        return true;
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
