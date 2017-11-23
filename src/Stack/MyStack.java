package Stack;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by Xuan on 2017/11/23.
 * 第225题，用队列实现栈。
 * 思路：入队时，将队尾前面的数依次出队，再入队，构造成栈的存储顺序。
 */
public class MyStack {
    /**
     * Initialize your data structure here.
     */
    Queue<Integer> queue;

    public MyStack() {
        queue = new ArrayDeque<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue.add(x);
        for(int i=1;i<queue.size();i++) {
            queue.add(queue.poll());
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queue.poll();
    }

    /** Get the top element. */
    public int top() {
        return queue.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }

    public static void main(String[] args) {
    }
}
