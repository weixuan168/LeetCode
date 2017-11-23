package Stack;

import java.util.NoSuchElementException;

/**
 * Created by Xuan on 2017/11/23.
 * 第155题 构造一个Stack,可以push,pop,输出top,以及最小值（在常数时间内）。
 */
public class MinStack {

    /**
     * initialize your data structure here.
     */
    class Node {
        int min;
        int value;
        Node next;
    }

    Node first;
    int size;

    public boolean isEmpty() {
        return size == 0;
    }
    public MinStack() {
        first = null;
        size = 0;
    }

    public void push(int x) {
        Node node = new Node();
        node.value = x;
        node.next = first;
        if (isEmpty()) {
            node.min = x;
        } else {
            node.min = x > first.min ? first.min : x;
        }
        first = node;
        size++;
    }

    public void pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("The Stack is empty");
        }
        first = first.next;
        size--;
    }

    public int top() {
        if (isEmpty()) {
            throw new NoSuchElementException("The Stack is empty");
        }
        return first.value;
    }

    public int getMin() {
        if (isEmpty()) {
            throw new NoSuchElementException("The Stack is empty");
        }
        return first.min;
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-1);
        minStack.push(0);
        minStack.push(3);
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }

}
