package Stack;

import java.util.Stack;

/**
 * Created by Xuan on 2017/11/23.
 * 第232题，用栈实现队列。
 */
public class MyQueue {
    /**
     * Initialize your data structure here.
     */
    Stack<Integer> stack;
    Stack<Integer> tmp;

    public MyQueue() {
        stack = new Stack<>();
        tmp = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stack.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        int num = stack.size();
        for(int i=1;i<num;i++) {
            tmp.push(stack.pop());
        }
        int result=stack.pop();
        for(int i=1;i<num;i++) {
            stack.push(tmp.pop());
        }
        return result;
    }

    /** Get the front element. */
    public int peek() {
        int num = stack.size();
        for (int i = 0; i < num; i++) {
            tmp.push(stack.pop());
        }
        int result=tmp.peek();
        for(int i=0;i<num;i++) {
            stack.push(tmp.pop());
        }
        return result;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1);
        myQueue.push(2);
        System.out.println(myQueue.peek());

    }
}
