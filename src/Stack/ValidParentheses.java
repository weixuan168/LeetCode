package Stack;

import java.util.Stack;

/**
 * Created by Xuan on 2017/11/13.
 * 第20题 判断输入的字符串中括号是否合法配对
 *
 * 思路：遇到左括号就入栈，遇到右括号则弹出栈顶，并比较是否配对。
 *      当输入字符串读完后判断栈是否为空。
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            }
            if (c == ')') {
                if (stack.size() == 0 || !(stack.pop() == '(')) return false;
            } else if (c == '}') {
                if (stack.size() == 0 || !(stack.pop() == '{')) return false;
            } else if (c == ']') {
                if (stack.size() == 0 || !(stack.pop() == '[')) return false;
            }
        }
        return stack.size() == 0;
    }

    public static void main(String[] args) {
        ValidParentheses vp = new ValidParentheses();
        System.out.println(vp.isValid("([)]"));
        System.out.println(vp.isValid("(){}[]"));
    }
}
