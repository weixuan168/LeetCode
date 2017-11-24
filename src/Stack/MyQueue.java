package Stack;

import java.util.NoSuchElementException;
import java.util.Stack;

/**
 * Created by Xuan on 2017/11/23.
 * 第232题，用栈实现队列。
 *
 * 思路1：（我最先想到的思路）维护栈1和栈2，入队即压入栈1，出队时先将栈1倒入栈2（n-1)个元素，
 *        将栈1栈底元素弹出，再将栈2元素依次压入栈1。
 *
 * 思路2：（按思路1提交到leetcode上时，时间性能非常不好，因此百度了优化方法）
 *        维护栈1和栈2，入队即压入栈1，出队时先判断栈2是否为空，若不为空，则弹出栈顶元素，
 *        若为空，则将栈1元素全部倒入栈2。
 * 重点：栈2不用往栈1回倒。
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
        if (tmp.isEmpty()) {
            if (stack.isEmpty()) {
                throw new NoSuchElementException("queue is empty");
            }
            int num = stack.size();
            for (int i = 0; i < num; i++) {
                tmp.push(stack.pop());
            }
        }
        return tmp.pop();
    }

    /** Get the front element. */
    public int peek() {
        if (tmp.isEmpty()) {
            if (stack.isEmpty()) {
                throw new NoSuchElementException("queue is empty");
            }
            int num = stack.size();
            for (int i = 0; i < num; i++) {
                tmp.push(stack.pop());
            }
        }
        return tmp.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack.isEmpty()&&tmp.isEmpty();
    }

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1);
        myQueue.push(2);
        System.out.println(myQueue.peek());

    }
}
