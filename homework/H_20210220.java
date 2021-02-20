import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class H_20210220 {

    public int[] nextGreaterElements(int[] nums) {
        int[] result = new int[nums.length];
        Arrays.fill(result, -1);

        Stack<Integer> deposit = new Stack<>();

        for (int i = 0; i < 2 * nums.length; i++) {
            while (!deposit.empty() && nums[deposit.peek()] < nums[i % nums.length])
                result[deposit.pop()] = nums[i % nums.length];
            deposit.push(i % nums.length);
        }

        return result;
    }


}


//lc155.minimal stack
class MinStack {
    Deque<Integer> firstStack;
    Deque<Integer> secondStack;

    public MinStack() {
        firstStack = new LinkedList<Integer>();
        secondStack = new LinkedList<Integer>();
        secondStack.push(Integer.MAX_VALUE);
    }


    public void push(int x) {
        firstStack.push(x);
        secondStack.push(Math.min(secondStack.peek(), x));
    }

    public void pop() {
        firstStack.pop();
        secondStack.pop();
    }

    public int top() {
        return firstStack.peek();
    }

    public int getMin() {
        return secondStack.peek();
    }


}


//lc232. queue by stack
class MyQueue {

    Stack<Integer> fStack;
    Stack<Integer> sStack;

    /**
     * Initialize your data structure here.
     */
    public MyQueue() {
        fStack = new Stack<>();
        sStack = new Stack<>();

    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        fStack.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        if (sStack.isEmpty()) {
            while (!fStack.isEmpty()) {
                sStack.push(fStack.pop());
            }
        }

        return sStack.pop();

    }

    /**
     * Get the front element.
     */
    public int peek() {
        if (sStack.isEmpty()) {
            while (!fStack.isEmpty()) {
                sStack.push(fStack.pop());
            }
        }
        return sStack.peek();

    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return fStack.isEmpty() && sStack.isEmpty();
    }
}

